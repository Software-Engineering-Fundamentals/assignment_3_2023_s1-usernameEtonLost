package src;

import java.util.Scanner;
import java.util.ArrayList;   

public class Main {
    public static Manager manager = new Manager();

    public static void main(String[] args) {
        // GeneralUser user = new GeneralUser();

        // System.out.println("Lodging request");
        // System.out.println("Enter a query: ");

        // Scanner scanner = new Scanner(System.in);
        // String query = scanner.nextLine();

        // user.lodgeInquiry(query);

        // System.out.println("Printing inquiries");
        // manager.viewTickets();

        // System.out.println("Answer request");
        // System.out.println("Enter a request ID: ");

        // int ticketID = scanner.nextInt();
        // scanner.nextLine();

        // System.out.println("Enter a response: ");

        // String response = scanner.nextLine();
        // boolean answered = manager.answerTicket(ticketID, response);

        // if (!answered) {
        //     System.out.println("Unable to answer ticket: Ticket not found");
        // }

        // System.out.println("Printing inquiries");
        // user.viewTickets();
        Scanner scanner = new Scanner(System.in);

        ticketImplementation(scanner);

        /**
         * Refund request implementation
         */
        refundImplementation(scanner);

        scanner.close();

    }

    public static void ticketImplementation(Scanner scanner) {
        System.out.println("TICKET IMPLEMENTATION");
        System.out.println("---------------------");

        GeneralUser user = new GeneralUser();

        System.out.println("Lodging request");
        System.out.println("Enter a query: ");

        // Scanner scanner = new Scanner(System.in);
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
        System.out.println();

        // scanner.close();
    }
    
    public static void refundImplementation(Scanner scanner) {
        // Scanner scanner = new Scanner(System.in);
        
        System.out.println("REFUND IMPLEMENTATION");
        System.out.println("---------------------");

        /**
         * We initialise all the objects required to simulate a refund
         * - this includes a training course with arbitrary ID "1118"
         */
        GeneralUser generalUser = new GeneralUser();
        FinanceManager finManager = new FinanceManager();
        OnlineSystem.financeManager = finManager;
        TrainingCourse trainingCourse = new TrainingCourse("Health", 1118, 100.0, 2314, "12/5/2023");
        Trainee trainee = new Trainee(-1, null, null, null, null, null, null, null, null, new ArrayList<RefundRequest>());
        OnlineSystem.currentUser = trainee;

        // Enrol the trainee to the created course for demonstration purposes
        trainingCourse.enrolTrainee(trainee);

        // A simple skeleton block to simulate the login feature
        // You must be logged in as the correct ID to be able to refund
        System.out.println("To continue, please log in:");
        System.out.print("Enter trainee ID: ");
        int traineeID = scanner.nextInt();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        generalUser.login(traineeID, password);
        
        // See the information for demonstration convenience
        System.out.println("\nCurrent courses available:");
        System.out.println("------------------------");
        trainingCourse.viewInfo();
        System.out.println();

        // Now we want to simulate a refund request.
        // If you want a valid refund, you need to enter course ID "1118"
        // because that is the only one this trainee is enrolled to
        // System.out.println("What course would you like a refund for?");
        // System.out.print("Please enter a course ID: ");
        // int courseToRefund = scanner.nextInt();

        // // Get the time and date that the refund request was made
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        // LocalDateTime now = LocalDateTime.now();  
        // RefundRequest refundRequest = new RefundRequest(courseToRefund, dtf.format(now));
        // // should be trainee.requestRefund() instead

        System.out.println("What course would you like a refund for?");
        System.out.print("Please enter a course ID: ");
        int courseToRefund = scanner.nextInt();

        
        // TrainingCourse selectedCourse;
        if (courseToRefund != trainingCourse.courseID) {
            // For demo purposes, create a new course if the inputted ID is different
            // to simulate other courses being available
            OnlineSystem.courses.add(OnlineSystem.courses.size(), new TrainingCourse("Some Other Course", courseToRefund, -1, -1, null));
        }  else {
            OnlineSystem.courses.add(OnlineSystem.courses.size(), trainingCourse);
        }
        // else {
        //     // If ID matches, the selected course is the one made before.
        //     selectedCourse = trainingCourse;
        // }
        
        boolean refundSuccess = OnlineSystem.currentUser.requestRefund(courseToRefund);

        System.out.println();
        if (refundSuccess) {
            System.out.println("Refund successful!");
        } else {
            System.out.println("Refund unsuccessful.");
        }

        // See the information for demonstration convenience
        System.out.println();
        trainingCourse.viewInfo();
        System.out.println();

        // scanner.close();
    }
}