package src;

import java.util.ArrayList;

public class Manager {
    private ArrayList<InquiryTicket> inquiryTickets = new ArrayList<>();

    public Manager() {}

    // Add the ticket to the list
    public void addTicket(InquiryTicket ticket) {
        inquiryTickets.add(ticket);
    }

    // Function to print out the current tickets in the list
    public void viewTickets() {
        // For each ticket, print the ID and the related query
        for (InquiryTicket ticket: inquiryTickets) {
            System.out.println("ID: " + ticket.getTicketID() + " query: " + ticket.getQuery());
        }
    }

    // Answer the ticket with the manager's response
    public boolean answerTicket(int ticketID, String answer) {
        InquiryTicket ticket = null;

        // First, find the ticket that is being answered
        for (InquiryTicket ticketSearch: inquiryTickets) {
            if (ticketSearch.getTicketID() == ticketID) {
                ticket = ticketSearch;
            }
        }

        // If the ticket is found, then set the response and
        // return true that it has been answered
        if (ticket != null) {
            ticket.setResponse(answer);
            return true;
        }
        else {
            return false;
        }
    }
}
