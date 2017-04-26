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
    private static int number = 8;
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
}
