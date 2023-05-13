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


  public boolean requestRefund(int courseID) {
    // Get the time and date that the refund request was made
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    // Create a new refund request like in the diagram
    RefundRequest refundRequest = new RefundRequest(this.traineeID, courseID, dtf.format(now));
    // send this refund request to the finance manager who returns whether or not the refund was successful
    // this calls financeManager like in the diagram
    boolean refundStatus = OnlineSystem.financeManager.refundTrainee(this.traineeID, refundRequest);

    // return the refund status like in the diagram
    return refundStatus;
  }
  
}
