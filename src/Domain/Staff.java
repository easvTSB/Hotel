package Domain;

import Technical.DBFacade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by LPNielsen on 25-Apr-17.
 */
public class Staff {
    private static DBFacade dbFacade = new DBFacade();
    private static LocalDate localDate = LocalDate.now();
    private static int number = 7;
    private static String fName;
    private static String lName;
    private static String phoneNo;
    private static String email;
    private static String address;
    private static int zipCode;
    private static String jobTitle;

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

    public static void createEmployee(Account staffAccount) throws SQLException {
        PreparedStatement ps = dbFacade.createStatement("insert into Staff values (?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, number);
        ps.setString(2, fName);
        ps.setString(3, lName);
        ps.setString(4, phoneNo);
        ps.setString(5, email);
        ps.setString(6, localDate.toString());
        ps.setString(7, address);
        ps.setInt(8, zipCode);
        ps.setString(9, jobTitle);
        ps.execute();

        ps = dbFacade.createStatement("insert into Account values (?,?,?,?)");
        ps.setString(1, staffAccount.getUserName());
        ps.setString(2, staffAccount.getPassword());
        ps.setInt(3, number);
        ps.setString(4, staffAccount.getUserLevel());
        ps.execute();
        ps.close();
    }
}
