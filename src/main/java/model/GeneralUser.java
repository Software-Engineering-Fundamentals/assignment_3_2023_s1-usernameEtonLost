package src.main.java.model;

import java.util.ArrayList;

public class GeneralUser {
    // GeneralUser has a one to many relationship with InquiryTicket as seen in class diagram
    private ArrayList<InquiryTicket> inquiryTickets = new ArrayList<>();

    // Constructor is assumed
    public GeneralUser() {}

    // Public method to lodge an inquiry to manager. Method creates a ticket object
    // and adds it to the list
    public void lodgeInquiry(String query) {
        InquiryTicket inquiryTicket = new InquiryTicket(query);
        inquiryTickets.add(inquiryTicket);
    }

    // Method to print the current user tickets
    public void viewTickets() {
        // For each ticket, print the ID and related query and response (if any)
        for (InquiryTicket ticket: inquiryTickets) {
            System.out.println("ID: " + ticket.getTicketID() + "\nquery: " + ticket.getQuery() + "\nresponse: " + ticket.getResponse());
        }
    }

    // Method to log general user in as a trainee
    public void login(int traineeID, String passwordString) {
        OnlineSystem.currentTrainee.traineeID = traineeID;
        System.out.println("Logged in as " + Integer.toString(traineeID));
    }
}
