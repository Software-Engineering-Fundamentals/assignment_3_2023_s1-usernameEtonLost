package src.main.java.model;
import java.util.ArrayList;

/*
 * This follows the TrainingCourse class in the class diagram
 * and inherits from Course
 */
public class TrainingCourse extends Course {
  public String censusDate;
  // There is a 0 to many relationship between Course and Trainee
  private ArrayList<Trainee> traineeList = new ArrayList<>();

  public TrainingCourse() {}

  public TrainingCourse(String name, int courseID, double fee, int trainerID, String censusDate) {
    this.name = name;
    this.courseID = courseID;
    this.fee = fee;
    this.trainerID = trainerID;
    this.censusDate = censusDate;
  }

  /*
   * a get function to unenroll a trainee from the course
   * This is a new addition in the sequence diagram and is not in the class diagram.
   */
  public void unenrollTrainee(int traineeID) {
    int index = 0;
    for (Trainee trainee : traineeList) {
      if (trainee.traineeID == traineeID) {
        break;
      }
      index++;
    }

    if (index < traineeList.size()) {
      traineeList.remove(index);
    }
  }

  /*
   * a get function to return all trainees currently enrolled in the course
   * Get functions are assumed in the class diagram.
   */
  public ArrayList<Trainee> getCourseTraineeList() {
    return traineeList;
  }

  /*
   * Adds a trainee to the course for demo purposes
   */
  public void enrolTrainee(Trainee trainee) {
    this.traineeList.add(traineeList.size(), trainee);
  }

  /*
   * Show a summary of course information for demonstration purposes
   */
  public void viewInfo() {
    System.out.println("Course Name: " + name);
    System.out.println("Course ID: " + Integer.toString(courseID));
    System.out.println("Enrolled trainee IDs: ");
    if (traineeList.size() == 0) {
      System.out.println("None enrolled.");
    } else {
      for (Trainee trainee : traineeList) {
        System.out.println(" - " + trainee.traineeID);
      }
    }
  }
}
