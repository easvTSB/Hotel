package Domain;

import Application.Creator;
import Technical.DBFacade;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by LPNielsen on 25-Apr-17.
 */
public class Staff extends DBFacade{
    private static LocalDate localDate = LocalDate.now();
    private static String fName;
    private static String lName;
    private static String phoneNo;
    private static String email;
    private static String address;
    private static int zipCode;
    private static String jobTitle;
    private static CallableStatement cs;

    public Staff(String fName, String lName, String phoneNo, String email,
                 String address, int zipCode, String jobTitle) {
        Staff.fName = fName;
        Staff.lName = lName;
        Staff.phoneNo = phoneNo;
        Staff.email = email;
        Staff.address = address;
        Staff.zipCode = zipCode;
        Staff.jobTitle = jobTitle;
    }

    public void createEmployee() throws SQLException {
        cs = con.prepareCall("{call CreateStaffMember(?,?,?,?,?,?,?,?)}");
        cs.setString(1, fName);
        cs.setString(2, lName);
        cs.setString(3, phoneNo);
        cs.setString(4, email);
        cs.setString(5, localDate.toString());
        cs.setString(6, address);
        cs.setInt(7, zipCode);
        cs.setString(8, jobTitle);
        cs.execute();
    }

    public void createStaffAccount(String userLevel) throws SQLException {
        Account.setUserName(fName,lName);
        Account.setPassword();
        String username = Account.getUserName();
        String password = Account.getPassword();

        cs = con.prepareCall("{call CreateAccount(?,?,?)}");
        cs.setString(1, username);
        cs.setString(2, password);
        cs.setString(3, userLevel);
        cs.execute();
        cs.close();
    }
}
