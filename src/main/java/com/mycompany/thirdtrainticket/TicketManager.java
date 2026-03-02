/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thirdtrainticket;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TicketManager {
    
     // ArrayList to store multiple TrainTicket objects (Requirement 2.1)
    private ArrayList<ThirdTrainTicket> tickets = new ArrayList<>();

    // Method to add a ticket with validation
    public String addTicket(String name, String destination, String ticketClass) {

        // Validate input fields using conditional statements (Requirement 2.2)
        if (name.isEmpty() || destination.isEmpty() || ticketClass.isEmpty()) {
            return "Error: All fields must be filled!";
        }

        // Base price for all tickets
        double basePrice = 100.0;
        double finalPrice;

        // Validate ticket class and apply price multiplier
        if (ticketClass.equalsIgnoreCase("Economy")) {
            finalPrice = basePrice; // Economy = base price
        } else if (ticketClass.equalsIgnoreCase("Business")) {
            finalPrice = basePrice * 1.5; // Business = 1.5 × base price
        } else {
            // Error if invalid ticket class entered
            return "Error: Ticket class must be Economy or Business!";
        }

        // Create TrainTicket object (Object-Oriented Principle)
        ThirdTrainTicket ticket = new ThirdTrainTicket(name, destination, ticketClass, finalPrice);

        // Add ticket object to ArrayList collection
        tickets.add(ticket);

        return "Ticket added successfully!";
    }

    // Method to display all tickets stored in the ArrayList
    public String displayTickets() {

        // Check if the collection is empty
        if (tickets.isEmpty()) {
            return "No tickets booked yet.";
        }

        // StringBuilder for efficient string concatenation
        StringBuilder output = new StringBuilder();

        // Loop through all tickets in the ArrayList
        for (ThirdTrainTicket ticket : tickets) {
            // Append formatted ticket details
            output.append(ticket.getFormattedTicket());
        }

        // Return all ticket information as a single formatted string
        return output.toString();
    }
    
    public String searchByDestination(String destination) {

    StringBuilder results = new StringBuilder();

    for (ThirdTrainTicket ticket : tickets) {
        if (ticket.getDestination().equalsIgnoreCase(destination)) {
            results.append(ticket.getFormattedTicket());
        }
    }

    if (results.length() == 0) {
        return "No tickets found for destination: " + destination;
    }

    return results.toString();
}
    
}
