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
  // NOTE: added courseID as a parameter for this (different to class diagram) 
  public boolean refundTrainee(int traineeID, RefundRequest refundRequest) {
    // get the course from the ID
    TrainingCourse course = OnlineSystem.getCourseFromID(refundRequest.courseID);
    
    // Get the trainees enrolled in the course
    ArrayList<Trainee> traineeList = course.getCourseTraineeList();
    boolean found = false;
    // Loop over all the trainees and see if the user is enrolled in it
    for (Trainee trainee : traineeList) {
      if (trainee.traineeID == traineeID) {
        // The trainee is in the course, so update found status
        found = true;
        break;
      }
    }

    if (found) {
      // Refund the trainee if they are in the course
      refundMoney(course);
      course.unenrollTrainee(traineeID);
    } else {
      // Do not refund if not found in course
      System.out.println("Could not refund. You are not enrolled in this course.");
    }

    return found;
  }

  private void refundMoney(Course course) {
    System.out.println("Refunding amount of $" + Double.toString(course.fee));
  }
}
