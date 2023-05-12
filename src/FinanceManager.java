package src;
import java.util.ArrayList;

public class FinanceManager {
  

  public FinanceManager() {}


  // added courseID as a parameter for this
  // difference to class diagram ^^^
  public boolean refundTrainee(int traineeID, TrainingCourse course) {
    ArrayList<Trainee> traineeList = course.getCourseTraineeList();
    boolean found = false;
    for (Trainee trainee : traineeList) {
      if (trainee.traineeID == traineeID) {
        found = true;
      }
    }

    if (found) {
      System.out.println("Refunding money.");
      refundMoney();
    } else {
      System.err.println("Could not refund. User is not in course");
    }

    return found;
  }

  private int refundMoney() {
    return -1;
  }
}
