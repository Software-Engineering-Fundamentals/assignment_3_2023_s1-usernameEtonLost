package src;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Trainee extends GeneralUser {
  public int traineeID;
  private String name;
  private String username;
  private String DOB;
  private String address;
  private String password;
  private String contactNum;
  private String emgContact;
  private String emailID;

  public ArrayList<RefundRequest> refundRequests;

  public Trainee(final int ID, String name, String username, String DOB, String address, String password, String contactNum, String emgContact, String emailID, ArrayList<RefundRequest> refundRequests) {
    this.traineeID = ID;
    this.name = name;
    this.username = username;
    this.DOB = DOB;
    this.address = address;
    this.password = password;
    this.contactNum = contactNum;
    this.emgContact = emgContact;
    this.emailID = emailID;
    this.refundRequests = refundRequests;
  }

  // public Trainee() {}

  /*
   * TODO: THIS MUST BE FIT IN SOMEWHERE
   */
  public boolean requestRefund(int courseID) {
    // Now we want to simulate a refund request.
    // If you want a valid refund, you need to enter course ID "1118"
    // because that is the only one this trainee is enrolled to
    
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    RefundRequest refundRequest = new RefundRequest(courseID, dtf.format(now));

    boolean result = OnlineSystem.financeManager.refundTrainee(this.traineeID, refundRequest);

    // refundRequest.refundTrainee();

    return result;
  }
  
}
