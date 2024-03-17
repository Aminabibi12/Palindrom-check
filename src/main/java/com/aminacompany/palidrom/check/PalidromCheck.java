package com.aminacompany.palidrom.check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalidromCheck extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton checkButton;

    public PalidromCheck() {
        super("Palindrome Checker");

        // Create input field and check button
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(200, 40)); 
        checkButton = new JButton("Check");

        // Add components to frame
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a string: "));
        panel.add(inputField);
        panel.add(checkButton);
        add(panel);

        // Register action listener for check button
        checkButton.addActionListener(this);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
         setSize(600, 300); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get input text from input field
        String inputText = inputField.getText().trim();

        // Check if the input string is a palindrome
        boolean isPalindrome = isPalindrome(inputText);

        // Display result in a dialog box
        String message = isPalindrome ? "Yes, it's a palindrome!" : "No, it's not a palindrome.";
        JOptionPane.showMessageDialog(this, message);
    }

    // Method to check if a string is a palindrome
    private boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the string is equal to its reverse
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        new PalidromCheck();
    }
}
