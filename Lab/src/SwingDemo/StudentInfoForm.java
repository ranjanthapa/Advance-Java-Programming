package SwingDemo;

import SwingDemo.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoForm {
    public static void main(String[] args) {
        System.out.println("Running the form");
        JFrame frame = new JFrame("Student registration form");
        frame.setLayout(new GridLayout(8, 2, 10, 5));

        JLabel fullNameLabel = new JLabel("fullName");
        JTextField fullNameTf = new JTextField();
        frame.add(fullNameLabel);
        frame.add(fullNameTf);


        JLabel addressLabel = new JLabel("address");
        JTextField addressTf = new JTextField();
        frame.add(addressLabel);
        frame.add(addressTf);

        JLabel pAddressLabel = new JLabel("Permanent Address");
        JTextField pAddressTf = new JTextField();
        frame.add(pAddressLabel);
        frame.add(pAddressTf);


        JPanel genderPanel = new JPanel();
        JLabel genderLabel = new JLabel("Gender");
        JRadioButton maleBtn = new JRadioButton("male");
        JRadioButton femaleBtn = new JRadioButton("female");
        JRadioButton otherBtn = new JRadioButton("other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderGroup.add(otherBtn);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        genderPanel.add(otherBtn);
        frame.add(genderLabel);
        frame.add(genderPanel);

        JLabel registrationLabel = new JLabel("registration number");
        JTextField registrationTf = new JTextField();
        frame.add(registrationLabel);
        frame.add(registrationTf);


        JLabel batchLabel = new JLabel("batch");
        JTextField batchTf = new JTextField();
        frame.add(batchLabel);
        frame.add(batchTf);


        JLabel departmentLabel = new JLabel("department");
        String[] departments = {"BCA", "BHM", "BBS"};
        JComboBox<String> departmentOptions = new JComboBox<>(departments);
        frame.add(departmentLabel);
        frame.add(departmentOptions);

        JButton submitBtn = new JButton("Submit");
        frame.add(submitBtn);



        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameTf.getText();
                String address = addressTf.getText();
                String pAddress = pAddressTf.getText();
                String gender = maleBtn.isSelected() ? "Male" : femaleBtn.isSelected() ? "Female" : "Other";
                String registration = registrationTf.getText();
                String batch = batchTf.getText();
                String department =  departmentOptions.getSelectedItem().toString();

                int isConfirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to create?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                System.out.println(isConfirm);
                if (isConfirm == JOptionPane.YES_OPTION) {
                    Student student = new Student(fullName, address, pAddress, gender, registration, batch, department);
                    JOptionPane.showMessageDialog(null, "Student created successfully:\n" + student);
                }
                    fullNameTf.setText("");
                    addressTf.setText("");
                    pAddressTf.setText("");
                    registrationTf.setText("");
                    batchTf.setText("");
                    departmentOptions.setSelectedIndex(0);
                    genderGroup.clearSelection();

            }
        });

    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);



    }
}
