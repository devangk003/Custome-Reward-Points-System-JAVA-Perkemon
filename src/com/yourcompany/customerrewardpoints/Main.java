package com.yourcompany.customerrewardpoints;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private static Customer loggedInCustomer = null;
    private static CustomerDatabase customerDatabase = new CustomerDatabase();

    private JPanel mainPanel;
    private JPanel registerPanel;
    private JPanel loginPanel;
    private JPanel customerMenuPanel;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField amountField;
    private JTable customerInfoTable;
    private JTextArea transactionsArea;

    public Main() {
        // Set up the main frame
        setTitle("Perkémon");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the frame

        // Main panel setup
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(200, 220, 240)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton registerButton = new JButton("Register New User");
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(registerButton, gbc);

        gbc.gridy = 1;
        mainPanel.add(loginButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(exitButton, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Register panel setup
        registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(220, 240, 200)); // Set background color
        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        addressField = new JTextField(15);
        JButton registerSubmitButton = new JButton("Submit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        registerPanel.add(registerSubmitButton, gbc);

        // Login panel setup
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(240, 220, 200)); // Set background color
        JTextField loginPhoneField = new JTextField(15);
        JButton loginSubmitButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        loginPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        loginPanel.add(loginPhoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        loginPanel.add(loginSubmitButton, gbc);

        // Customer menu panel setup
        customerMenuPanel = new JPanel(new GridBagLayout());
        customerMenuPanel.setBackground(new Color(200, 240, 220)); // Set background color

        String[] columnNames = {"Data", "Values"};
        Object[][] data = {
                {"Name", ""},
                {"Phone", ""},
                {"Address", ""},
                {"Tier", ""},
                {"Reward Points", ""}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        customerInfoTable = new JTable(model);
        customerInfoTable.setBackground(new Color(255, 255, 204)); // Set background color
        customerInfoTable.setFillsViewportHeight(true); // Fill height of the panel

        JScrollPane tableScrollPane = new JScrollPane(customerInfoTable);
        tableScrollPane.setPreferredSize(new Dimension(400, 150)); // Set preferred size

        amountField = new JTextField(15);
        transactionsArea = new JTextArea(10, 30);
        transactionsArea.setEditable(false);
        transactionsArea.setBackground(new Color(255, 255, 204)); // Set background color

        JButton addTransactionButton = new JButton("Add Transaction");
        JButton showTransactionsButton = new JButton("Show Transactions");
        JButton logoutButton = new JButton("Logout");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        customerMenuPanel.add(tableScrollPane, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        customerMenuPanel.add(new JLabel("Transaction Amount:"), gbc);
        gbc.gridx = 1;
        customerMenuPanel.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        customerMenuPanel.add(addTransactionButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        customerMenuPanel.add(showTransactionsButton, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        customerMenuPanel.add(logoutButton, gbc);

        // Add action listeners
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(registerPanel);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(loginPanel);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        registerSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerNewUser();
            }
        });

        loginSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(loginPhoneField.getText());
            }
        });

        addTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTransaction();
            }
        });

        showTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousTransactions();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        showPanel(mainPanel);
        setVisible(true);
    }

    private void showPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void registerNewUser() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 10 digits");
            return;
        }

        Customer customer = new Customer(name, phone, address);
        customerDatabase.addCustomer(customer);
        JOptionPane.showMessageDialog(this, "User registered successfully");
        showPanel(mainPanel);
    }

    private void login(String phone) {
        loggedInCustomer = customerDatabase.findCustomer(phone);
        if (loggedInCustomer != null) {
            showPanel(customerMenuPanel);
            displayCustomerInfo();
        } else {
            JOptionPane.showMessageDialog(this, "Customer not found");
        }
    }

    private void displayCustomerInfo() {
        if (loggedInCustomer != null) {
            customerInfoTable.setValueAt(loggedInCustomer.getName(), 0, 1);
            customerInfoTable.setValueAt(loggedInCustomer.getPhoneNumber(), 1, 1);
            customerInfoTable.setValueAt(loggedInCustomer.getAddress(), 2, 1);
            customerInfoTable.setValueAt(loggedInCustomer.getTier(), 3, 1);
            customerInfoTable.setValueAt(loggedInCustomer.getRewardPoints(), 4, 1);
        }
    }

    private void addNewTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            loggedInCustomer.addTransaction(amount);
            loggedInCustomer.updateTierAndPoints(amount);
            displayCustomerInfo();
            amountField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount");
        }
    }

    private void showPreviousTransactions() {
        StringBuilder sb = new StringBuilder();
        for (double transaction : loggedInCustomer.getTransactions()) {
            sb.append("Transaction: ").append(transaction).append("\n");
        }
        transactionsArea.setText(sb.toString());
        JOptionPane.showMessageDialog(this, new JScrollPane(transactionsArea), "Previous Transactions", JOptionPane.INFORMATION_MESSAGE);
    }

    private void logout() {
        loggedInCustomer = null;
        showPanel(mainPanel);
    }

    public static void main(String[] args) {
        new Main();
    }
}
