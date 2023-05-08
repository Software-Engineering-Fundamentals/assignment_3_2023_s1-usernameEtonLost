package src;

import java.util.ArrayList;

public class Manager {
    private ArrayList<InquiryTicket> inquiryTickets = new ArrayList<>();

    public Manager() {}

    public void addTicket(InquiryTicket ticket) {
        inquiryTickets.add(ticket);
    }

    public void viewTickets() {
        for (InquiryTicket ticket: inquiryTickets) {
            System.out.println("ID: " + ticket.getTicketID() + " query: " + ticket.getQuery());
        }
    }

    public boolean answerTicket(int ticketID, String answer) {
        InquiryTicket ticket = null;

        for (InquiryTicket ticketSearch: inquiryTickets) {
            if (ticketSearch.getTicketID() == ticketID) {
                ticket = ticketSearch;
            }
        }

        if (ticket != null) {
            ticket.setResponse(answer);
            return true;
        }
        else {
            return false;
        }
    }
}
