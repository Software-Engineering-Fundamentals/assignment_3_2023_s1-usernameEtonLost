package src;

import java.util.ArrayList;

public class GeneralUser {
    private ArrayList<InquiryTicket> inquiryTickets = new ArrayList<>();

    public GeneralUser() {}

    public void lodgeInquiry(String query) {
        InquiryTicket inquiryTicket = new InquiryTicket(query);
        inquiryTickets.add(inquiryTicket);
    }

    public void viewTickets() {
        for (InquiryTicket ticket: inquiryTickets) {
            System.out.println("ID: " + ticket.getTicketID() + "\nquery: " + ticket.getQuery() + "\nresponse: " + ticket.getResponse());
        }
    }

    public void login(int traineeID, String passwordString) {
        OnlineSystem.currentTrainee.traineeID = traineeID;
        System.out.println("Logged in as " + Integer.toString(traineeID));
    }
}
