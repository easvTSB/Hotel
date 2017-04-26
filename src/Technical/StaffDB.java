package Technical;

import Application.Creator;
import Domain.Account;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Martynas on 2017-04-24.
 */
public class StaffDB extends DBFacade {
    java.sql.Date d;
    LocalDate localDate = LocalDate.now();
    private String staff_FName;
    private String staff_LName;
    private String staff_PhoneNo;
    private String staff_Mail;
    private Date staff_StarteDate;
    private String staff_Address;
    private int city_Zip;
    private String jobtitle_Occupation;
    private static String username;
    private static String password;

    public void createStaffMember(String FName, String LName,
                                  String PhoneNo, String Mail,
                                  String Address, int Zip, String Occupation) throws SQLException{
        this.staff_FName = FName;
        this.staff_LName = LName;
        this.staff_PhoneNo = PhoneNo;
        this.staff_Mail = Mail;
        this.staff_Address = Address;
        this.city_Zip = Zip;
        this.jobtitle_Occupation = Occupation;

        cs = con.prepareCall("{call CreateStaffMember(?,?,?,?,?,?,?,?)}");
        cs.setString(1,staff_FName);
        cs.setString(2,staff_LName);
        cs.setString(3,staff_PhoneNo);
        cs.setString(4,staff_Mail);
        cs.setString(5, localDate.toString());
        cs.setString(6,staff_Address);
        cs.setInt(7,city_Zip);
        cs.setString(8,jobtitle_Occupation);
        cs.execute();

    }

    public Account createStaffAccount(JTextField fname,JTextField lname,JComboBox comboBox) throws SQLException {
        Account.setUserName(fname.getText(),lname.getText());
        Account.setPassword();
        username = Account.getUserName();
        password = Account.getPassword();
        return Creator.createStaffAccount(username,password,comboBox.getSelectedItem().toString());
    }

    public void generateAccount() throws SQLException {
        cs = con.prepareCall("{call CreateAccount(?,?,?)}");
        cs.setString(1, Account.getUserName());
        cs.setString(2, Account.getPassword());
        cs.setString(3, Account.getUserLevel());
        cs.execute();
        cs.close();
    }

    public void deleteStaffMember (int staff_ID) throws SQLException{
        cs = con.prepareCall("{call DeleteStaffMember(?)}");
        cs.setLong(1,staff_ID);

        cs.execute();
    }

    public void editStaffFirstName (int staff_ID, String staff_FName) throws SQLException{
        cs = con.prepareCall("{call EditStaffFirstName(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,staff_FName);

        cs.execute();
    }

    public void editStaffLastName (int staff_ID, String staff_LName) throws SQLException{
        cs = con.prepareCall("{call EditStaffLastName(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,staff_LName);

        cs.execute();
    }

    public void editStaffMail (int staff_ID, String staff_Mail) throws SQLException{
        cs = con.prepareCall("{call EditStaffMail(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,staff_Mail);

        cs.execute();
    }

    public void editStaffPhoneNo (int staff_ID, String staff_PhoneNo) throws SQLException{
        cs = con.prepareCall("{call EditStaffPhoneNo(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,staff_PhoneNo);

        cs.execute();
    }

    public void editStaffStartDate (int staff_ID, Date staff_StarteDate) throws SQLException{
        cs = con.prepareCall("{call EditStaffStartDate(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setDate(2,staff_StarteDate);

        cs.execute();
    }

    public void editStaffAddress (int staff_ID, String staff_Address) throws SQLException{
        cs = con.prepareCall("{call EditStaffAddress(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,staff_Address);

        cs.execute();
    }

    public void editStaffCityZip (int staff_ID, int city_Zip) throws SQLException{
        cs = con.prepareCall("{call EditStaffCityZip(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setInt(2,city_Zip);

        cs.execute();
    }

    public void editStaffJobTitle (int staff_ID, String jobtitle_Occupation) throws SQLException{
        cs = con.prepareCall("{call EditStaffJobTitle(?,?)}");
        cs.setLong(1,staff_ID);
        cs.setString(2,jobtitle_Occupation);

        cs.execute();
    }

}
