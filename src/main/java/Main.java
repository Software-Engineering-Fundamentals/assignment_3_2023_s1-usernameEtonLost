package src.main.java;

import java.util.Scanner;

import src.main.java.model.FinanceManager;
import src.main.java.model.GeneralUser;
import src.main.java.model.Manager;
import src.main.java.model.OnlineSystem;
import src.main.java.model.RefundRequest;
import src.main.java.model.Trainee;
import src.main.java.model.TrainingCourse;

import java.util.ArrayList;   

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ticketImplementation(scanner);
        refundImplementation(scanner);

        scanner.close();
    }

    public static void ticketImplementation(Scanner scanner) {
        System.out.println("TICKET IMPLEMENTATION");
        System.out.println("---------------------");

        // Initialise pseudo objects to simulate lodging and answering a request
        OnlineSystem.manager = new Manager();
        GeneralUser user = new GeneralUser();

        // Simulating entering a query
        System.out.println("Lodging request");
        System.out.println("Enter a query: ");

        String query = scanner.nextLine();

        // Call lodgeInquiry to create ticket
        user.lodgeInquiry(query);

        // On manager side, simulating viewing current tickets
        System.out.println("Printing inquiries");
        OnlineSystem.manager.viewTickets();

        // Simulating answering a request
        System.out.println("Answer request");
        System.out.println("Enter a request ID: ");

        // Get the ticket ID
        int ticketID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter a response: ");

        // Get a response
        String response = scanner.nextLine();
        // Attempt to answer the response.
        boolean answered = OnlineSystem.manager.answerTicket(ticketID, response);

        // Simulate not being able to answer the request
        if (!answered) {
            System.out.println("Unable to answer ticket: Ticket not found");
        }

        // Print out the user inquiries, to show that it has/has not been answered
        System.out.println("Printing inquiries");
        user.viewTickets();
        System.out.println();
    }
    
    public static void refundImplementation(Scanner scanner) {
        System.out.println("REFUND IMPLEMENTATION");
        System.out.println("---------------------");

        /**
         * We initialise all the objects required to simulate a refund
         * - this includes an example training course with arbitrary ID "1118"
         * - we save a some into a pseuodo online system for demo purposes
         */
        GeneralUser generalUser = new GeneralUser();
        FinanceManager finManager = new FinanceManager();
        OnlineSystem.financeManager = finManager;
        TrainingCourse trainingCourse = new TrainingCourse("Health", 1118, 100.0, 2314, "12/5/2023");
        Trainee trainee = new Trainee(-1, null, null, null, null, null, null, null, null, new ArrayList<RefundRequest>());
        OnlineSystem.currentTrainee = trainee;

        // Enrol the trainee to the created course for demonstration purposes
        // Pretend that they enrolled in the wrong course and now want a refund
        trainingCourse.enrolTrainee(trainee);
        // Add to online system for demo
        OnlineSystem.courses.add(OnlineSystem.courses.size(), trainingCourse);

        // A simple skeleton block to simulate the login feature
        System.out.println("To continue, please log in:");
        System.out.print("Enter trainee ID: ");
        int traineeID = scanner.nextInt();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // The controller calls login from general user like in the diagram
        generalUser.login(traineeID, password);
        
        // See the course information for demonstration convenience
        System.out.println("\nCurrent courses available:");
        System.out.println("------------------------");
        trainingCourse.viewInfo();
        System.out.println();


        // Now we want to simulate a refund request.
        // If you want a valid refund, you need to enter course ID "1118"
        // because that is the only one this trainee is enrolled to
        System.out.println("What course would you like a refund for?");
        System.out.print("Please enter a course ID: ");
        int courseToRefund = scanner.nextInt();

        // Update the selected course for demo purposes
        if (courseToRefund != trainingCourse.courseID) {
            /* For demo purposes, create a new course if the inputted ID is different
            * to simulate other courses being available and the trainee choosing one
            * that they are not enrolled in
            */
            OnlineSystem.courses.add(OnlineSystem.courses.size(), new TrainingCourse("Some Other Course", courseToRefund, -1, -1, null));
        }
        
        // The controller calls request refund from trainee like the diagram
        boolean refundSuccess = OnlineSystem.currentTrainee.requestRefund(courseToRefund);

        // Just print out the status to show that refund status is returned to controller
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
    }
}