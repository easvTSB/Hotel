package Domain;

import java.time.LocalDate;

/**
 * Created by LPNielsen on 25-Apr-17.
 */
public class Staff {
    private int ID;
    private String fName;
    private String lName;
    private String phoneNo;
    private String email;
    private String address;
    private int zipCode;
    private String jobTitle;
    private LocalDate localDate = LocalDate.now();

    public Staff(String fName, String lName, String phoneNo, String email,
                 String address, int zipCode, String jobTitle) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.jobTitle = jobTitle;
    }

    public Staff(int staff_ID, String fName, String lName, String phoneNo, String email,
                 String address, int zipCode, String jobTitle) {
        this.ID = staff_ID;
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.jobTitle = jobTitle;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
