package src.main.java.model;

import java.util.concurrent.ThreadLocalRandom;

public class InquiryTicket {
    private final int ticketID;
    private final String query;
    private String response;

    public InquiryTicket(String query) {
        this.ticketID = ThreadLocalRandom.current().nextInt(100, 1000);
        this.query = query;

        OnlineSystem.manager.addTicket(this);
    }

    // Getter method to return ticket ID
    public int getTicketID() {
        return this.ticketID;
    }

    // Getter method to return ticket query
    public String getQuery() {
        return this.query;
    }

    // Setter method to set the response to ticket
    public void setResponse(String response) {
        this.response = response;
    }

    // Getter method to get response to ticket
    public String getResponse() {
        return this.response;
    }
}
