package src;
public class Trainee extends GeneralUser {
  public final int traineeID;
  private String name;
  private String username;
  private String DOB;
  private String address;
  private String password;
  private String contactNum;
  private String emgContact;
  private String emailID;

  public Trainee(final int ID, String name, String username, String DOB, String address, String password, String contactNum, String emgContact, String emailID) {
    this.traineeID = ID;
    this.name = name;
    this.username = username;
    this.DOB = DOB;
    this.address = address;
    this.password = password;
    this.contactNum = contactNum;
    this.emgContact = emgContact;
    this.emailID = emailID;
  }

  // public Trainee() {}

  public boolean requestRefund(int courseID) {
    
    
    return true;
  }
  
}
