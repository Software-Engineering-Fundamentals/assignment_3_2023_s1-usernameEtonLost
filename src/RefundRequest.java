package src;

/*
 * Following the RefundRequest class with minor modifications
 * - added traineeID and courseID as fields or else there would be no way
 *   for the finance manager to easily get this information
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
