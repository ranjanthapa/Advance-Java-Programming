package utils.annotations;

import config.DbConnection;
import utils.DbUtils;

import java.lang.reflect.Method;
import java.sql.Connection;

public class TableExistsProcessor {
    public static void processTableExistence(Object object) throws Exception {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(TableExists.class)){
                TableExists annotation = method.getAnnotation(TableExists.class);
                String tableName = annotation.tableName();
                String createQuery = annotation.createQuery();
                try(Connection conn = DbConnection.getConnection()){
                    if(DbUtils.checkTableExists(conn, tableName)){
                        System.out.println("Table " + tableName + " does not exist.");
                        boolean isCreated = DbUtils.createTable(createQuery, conn);
                        if(isCreated){
                            System.out.println("Table " + " created successfully.");
                            return;
                        }else{
                            System.out.println("Table" + tableName + "failed to create");
                        }
                    }
                }

            }
        }
    }
}
