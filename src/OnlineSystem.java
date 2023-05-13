package src;
import java.util.ArrayList;

/*
 * This class is needed to simulate the online servers.
 * Otherwise, the objects cannot communicate with each other easily.
 */
public class OnlineSystem {
  public static FinanceManager financeManager;
  public static ArrayList<TrainingCourse> courses = new ArrayList<TrainingCourse>();
  public static Trainee currentUser;

  public static TrainingCourse getCourseFromID(int courseID) {
    for (TrainingCourse course : courses) {
      // if a course with matching ID is found, return that course
      if (course.courseID == courseID) {
        return course;
      }
    }
    // if not found, return null
    return null;
  }
  
}
