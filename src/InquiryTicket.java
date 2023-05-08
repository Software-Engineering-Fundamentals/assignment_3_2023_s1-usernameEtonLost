package src;

import java.util.concurrent.ThreadLocalRandom;

public class InquiryTicket {
    private final int ticketID;
    private final String query;
    private String response;
    private boolean answered;

    public InquiryTicket(String query) {
        this.ticketID = ThreadLocalRandom.current().nextInt(100, 1000);
        this.query = query;

        Main.manager.addTicket(this);
    }

    public int getTicketID() {
        return this.ticketID;
    }

    public String getQuery() {
        return this.query;
    }

    public void setResponse(String response) {
        this.answered = true;
        this.response = response;
    }

    public String getResponse() {
        return this.response;
    }

    public boolean isAnswered() {
        return this.answered;
    }
}
