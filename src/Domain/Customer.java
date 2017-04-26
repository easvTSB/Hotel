package Domain;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Customer {
    private int id;
    private String fName;
    private String lName;
    private String mail;
    private String phoneNo;
    private String address;
    private int zip;

    public Customer(int id, String fName, String lName, String mail, String phoneNo, String address, int zip) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mail = mail;
        this.phoneNo = phoneNo;
        this.address = address;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }
}
