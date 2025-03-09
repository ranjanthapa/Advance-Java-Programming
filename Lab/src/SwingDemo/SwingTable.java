package SwingDemo;

import SwingDemo.model.Student;

import javax.swing.*;

public class SwingTable {
    SwingTable() {
        JFrame tableFrame = new JFrame("Register Students");

        String[] columnName = {"SN", "Full Name", "Address", "Permanent Address", "Gender", "Registration Number",
                "Batch", "Department"};

        Student[] studentData = new Student[]{
                new Student("John Doe", "123 Main St", "456 Elm St", "Male", "REG123456", "Batch 2023", "BCA"),
                new Student("Jane Smith", "789 Pine Rd", "101 Oak Ave", "Female", "REG789123", "Batch 2022", "BHM"),
                new Student("Alex Johnson", "321 Birch Blvd", "654 Maple Dr", "Male", "REG321654", "Batch 2021", "BBS"),
                new Student("Maria Garcia", "555 Cedar Lane", "987 Pine St", "Female", "REG555987", "Batch 2024", "BCA"),
                new Student("William Brown", "888 Elm St", "234 Birch Blvd", "Male", "REG888234", "Batch 2022", "BHM"),
                new Student("Emily White", "222 Oak St", "678 Birch Rd", "Female", "REG222678", "Batch 2023", "BBS"),
                new Student("Michael Davis", "333 Maple Dr", "555 Cedar St", "Male", "REG333555", "Batch 2021", "BCA"),
                new Student("Sarah Miller", "444 Pine Ave", "123 Birch Rd", "Female", "REG444123", "Batch 2024", "BHM")
        };

        String[][] tableData = new String[studentData.length][8];
        for (int i = 0; i < studentData.length; i++) {
            tableData[i][0] = String.valueOf(i + 1);
            tableData[i][1] = studentData[i].getFullName();
            tableData[i][2] = studentData[i].getAddress();
            tableData[i][3] = studentData[i].getPAddress();
            tableData[i][4] = studentData[i].getGender();
            tableData[i][5] = studentData[i].getRegistration();
            tableData[i][6] = studentData[i].getBatch();
            tableData[i][7] = studentData[i].getDepartment();
        }
        JTable stdTable = new JTable(tableData, columnName);
        JScrollPane scrollPane = new JScrollPane(stdTable);

        tableFrame.add(scrollPane);
        tableFrame.setBounds(30, 40, 600, 400);
        tableFrame.setVisible(true);
        tableFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingTable();
    }
}
