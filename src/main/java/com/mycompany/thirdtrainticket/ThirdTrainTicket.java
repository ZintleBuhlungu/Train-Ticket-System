/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.thirdtrainticket;

/**
 *
 * @author user
 */
public class ThirdTrainTicket {

     // Attributes (Encapsulation - private fields)
    private String passengerName;
    private String destination;
    private String ticketClass;
    private double price;

    // Constructor to initialize ticket details
    public ThirdTrainTicket(String passengerName, String destination, String ticketClass, double price) {
        this.passengerName = passengerName;
        this.destination = destination;
        this.ticketClass = ticketClass;
        this.price = price;
}
 // Getter method to return passenger name
    public String getPassengerName() {
        return passengerName;
    }

    // Getter method to return destination
    public String getDestination() {
        return destination;
    }

    // Getter method to return ticket class
    public String getTicketClass() {
        return ticketClass;
    }

    // Getter method to return price
    public double getPrice() {
        return price;
    }

    // Method to format ticket details for display in JTextArea
    public String getFormattedTicket() {
        return "Passenger: " + passengerName +
               "\nDestination: " + destination +
               "\nClass: " + ticketClass +
               "\nPrice: R" + String.format("%.2f", price) +
               "\n-----------------------------\n";
    }

    public static void main(String[] args) {
        // Start the GUI application
        new TrainTicketGUI();
    } 
}
