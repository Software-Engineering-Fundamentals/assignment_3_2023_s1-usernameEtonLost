package src;

import java.util.Scanner;

public class Main {
    public static Manager manager = new Manager();

    public static void main(String[] args) {
        GeneralUser user = new GeneralUser();

        System.out.println("Lodging request");
        System.out.println("Enter a query: ");

        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        user.lodgeInquiry(query);

        System.out.println("Printing inquiries");
        manager.viewTickets();

        System.out.println("Answer request");
        System.out.println("Enter a request ID: ");

        int ticketID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter a response: ");

        String response = scanner.nextLine();
        boolean answered = manager.answerTicket(ticketID, response);

        if (!answered) {
            System.out.println("Unable to answer ticket: Ticket not found");
        }

        System.out.println("Printing inquiries");
        user.viewTickets();

        /**
         * Refund request implementation
         */
        FinanceManager finManager = new FinanceManager();

        System.out.print("Enter trainee ID: ");
        int traineeID = scanner.nextInt();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        user.login(traineeID, password);
        System.out.println();

        System.out.println("What course would you like a refund for?");
        System.out.print("Please enter a course ID: ");
        int courseToRefund = scanner.nextInt();

        finManager.refundTrainee(traineeID, courseToRefund);
        





    }
}