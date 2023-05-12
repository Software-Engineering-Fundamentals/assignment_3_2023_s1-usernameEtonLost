package src;

public class RefundRequest {
  public int courseID;
  public String date;

  public RefundRequest(int courseID, String date) {
    this.courseID = courseID;
    this.date = date;
  }
}
