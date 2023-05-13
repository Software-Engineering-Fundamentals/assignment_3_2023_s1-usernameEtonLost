package src;

/*
 * Following the RefundRequest class
 */
public class RefundRequest {
  public int traineeID;
  public int courseID;
  public String date;

  public RefundRequest(int traineeID, int courseID, String date) {
    this.traineeID = traineeID;
    this.courseID = courseID;
    this.date = date;
  }
}
