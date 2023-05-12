package src;
import java.util.ArrayList;

public class TrainingCourse extends Course {
  public String censusDate;
  private ArrayList<Trainee> traineeList = new ArrayList<Trainee>();

  public TrainingCourse() {}

  public TrainingCourse(String name, int courseID, double fee, int trainerID, String censusDate) {
    this.name = name;
    this.courseID = courseID;
    this.fee = fee;
    this.trainerID = trainerID;
    this.censusDate = censusDate;
  }

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

  // a get function to return all trainees currently enrolled in the course
  public ArrayList<Trainee> getCourseTraineeList() {
    return traineeList;
  }

  /*
   * Adds a trainee to the course
   */
  public void enrolTrainee(Trainee trainee) {
    this.traineeList.add(traineeList.size(), trainee);
  }
}
