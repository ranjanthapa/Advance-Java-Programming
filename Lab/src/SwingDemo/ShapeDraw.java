package SwingDemo;

import javax.swing.*;
import java.awt.*;

public class ShapeDraw extends JFrame {
    public ShapeDraw(){
        setTitle("Shape Drawing");
        setSize(300, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new ShapePanel());
    }

    public static class ShapePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.drawLine(10, 50, 300, 50);
            g.drawOval(100, 70, 100, 60);
            g.drawOval(100, 150, 100, 100);
            g.drawRect(10, 270, 300, 200);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeDraw::new);
    }
}
