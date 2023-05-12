package src;
import java.util.ArrayList;

public class TrainingCourse extends Course {
  public int cencusDate;
  private ArrayList<Trainee> traineeList = new ArrayList<Trainee>();

  public TrainingCourse() {}

  public TrainingCourse(String name, int courseID, double fee, int trainerID, String censusDate) {
    this.name = name;
    this.courseID = courseID;
    this.fee = fee;
    this.trainerID = trainerID;
    this.cencusDate = cencusDate;
  }

  public ArrayList<Trainee> getCourseTraineeList() {
    return traineeList;
  }

  public void enrolTrainee(Trainee trainee) {
    this.traineeList.add(traineeList.size()-1, trainee);
  }
}
