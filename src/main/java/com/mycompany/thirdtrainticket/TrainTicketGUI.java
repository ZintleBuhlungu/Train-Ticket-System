/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package com.mycompany.thirdtrainticket;

import javax.swing.*;        // Import Swing components
import java.awt.*;           // Import layout managers
import java.awt.event.*;     // Import event handling
import java.util.ArrayList;  // Import ArrayList

// GUI class MUST extend JFrame to use setTitle, setSize, add(), etc.
public class TrainTicketGUI extends JFrame {

    // Text fields for user input
    private JTextField nameField;
    private JTextField destinationField;
    private JTextField classField;

    // Text area to display tickets
    private JTextArea displayArea;

    // ArrayList to store multiple TrainTicket objects
    private ArrayList<ThirdTrainTicket> ticketList;

    // Constructor to build the GUI
    public TrainTicketGUI() {
        // Initialize the ticket collection
        ticketList = new ArrayList<>();

        // Set window title
        setTitle("Train Ticket Reservation System");

        // Set window size
        setSize(600, 400);

        // Close application when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager
        setLayout(new BorderLayout());

        // Create input panel (top section)
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // Labels and text fields
        inputPanel.add(new JLabel("Passenger Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Destination:"));
        destinationField = new JTextField();
        inputPanel.add(destinationField);

        inputPanel.add(new JLabel("Ticket Class (Economy/Business):"));
        classField = new JTextField();
        inputPanel.add(classField);

        // Add button to add ticket
        JButton addButton = new JButton("Add Ticket");
        inputPanel.add(addButton);

        // Add input panel to top of frame
        add(inputPanel, BorderLayout.NORTH);

        // Create text area to display tickets
        displayArea = new JTextArea();
        displayArea.setEditable(false);

        // Add scroll pane for text area
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button event listener (when clicked)
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTicket(); // Call method to add ticket
            }
        });

        // Make the window visible
        setVisible(true);
    }

    // Method to validate input and add ticket to ArrayList
    private void addTicket() {
        String name = nameField.getText();
        String destination = destinationField.getText();
        String ticketClass = classField.getText();

        // Input validation (required fields)
        if (name.isEmpty() || destination.isEmpty() || ticketClass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        // Validate ticket class using conditional statement
        if (!ticketClass.equalsIgnoreCase("Economy") &&
            !ticketClass.equalsIgnoreCase("Business")) {
            JOptionPane.showMessageDialog(this, "Invalid Ticket Class! Use Economy or Business.");
            return;
        }

        // Base price
        double basePrice = 100.0;

        // Create TrainTicket object (OOP separation)
        ThirdTrainTicket ticket = new ThirdTrainTicket(name, destination, ticketClass, basePrice);

        // Add ticket to ArrayList collection
        ticketList.add(ticket);

        // Display all tickets
        displayTickets();

        // Clear fields after adding
        nameField.setText("");
        destinationField.setText("");
        classField.setText("");
    }

    // Method to display all tickets in the JTextArea
    private void displayTickets() {
        displayArea.setText(""); // Clear previous text

        // Loop through ArrayList and format ticket details
        for (ThirdTrainTicket ticket : ticketList) {
            displayArea.append(ticket.getFormattedTicket() + "\n\n");
        }
    }
}