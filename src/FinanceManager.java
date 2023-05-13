package src;
import java.util.ArrayList;

public class FinanceManager {
  // Constructor
  public FinanceManager() {}

  /**
   * given a trainee and a course, this function will refund a trainee
   * if they are enrolled in it when called
   * @param traineeID the trainee that is requesting the refund
   * @param course the course the trainee wants a refund for
   * @return true if the refund was successful, false otherwise.
   */

  public boolean refundTrainee(int traineeID, RefundRequest refundRequest) {
    // get the course from the ID
    TrainingCourse course = OnlineSystem.getCourseFromID(refundRequest.courseID);
    
    // Get the trainees enrolled in the course like in the diagram
    ArrayList<Trainee> traineeList = course.getCourseTraineeList();
    boolean currentlyEnrolled = false;
    // Loop over all the trainees and see if the user is enrolled in it
    for (Trainee trainee : traineeList) {
      if (trainee.traineeID == traineeID) {
        // The trainee is in the course, so update found status
        currentlyEnrolled = true;
        break;
      }
    }

    // The alt block in the sequence diagram with return values following what is drawn
    if (currentlyEnrolled) {
      // Refund the trainee if they are in the course like in diagram
      refundMoney(traineeID, course);
      // call unenrollTrainee from course like in the diagram
      course.unenrollTrainee(traineeID);
      return true;
    } else {
      // Do not refund if not found in course
      System.out.println("Could not refund. You are not enrolled in this course.");
      return false;
    }
  }

  // Skeleton code representing how refund money would be used
  private void refundMoney(int traineeID, Course course) {
    System.out.println("Refunding amount of $" + Double.toString(course.fee) + " to traineeID " + Integer.toString(traineeID) + ".");
  }
}
