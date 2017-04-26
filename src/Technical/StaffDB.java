package Technical;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Martynas on 2017-04-24.
 */
public class StaffDB extends MainJDBC {

    private int staff_ID;
    private String staff_FName;
    private String staff_LName;
    private String staff_PhoneNo;
    private String staff_Mail;
    private Date staff_StarteDate;
    private String staff_Address;
    private int city_Zip;
    private String jobtitle_Occupation;

    public StaffDB () throws SQLException{
    }

    public void createStaffMember (int staff_ID,String staff_FName,String staff_LName,
                                   String staff_PhoneNo,String staff_Mail,Date staff_StarteDate,
                                   String staff_Address,int city_Zip,String jobtitle_Occupation) throws SQLException{
        this.staff_ID = staff_ID;
        this.staff_FName = staff_FName;
        this.staff_LName = staff_LName;
        this.staff_PhoneNo = staff_PhoneNo;
        this.staff_Mail = staff_Mail;
        this.staff_StarteDate = staff_StarteDate;
        this.staff_Address = staff_Address;
        this.city_Zip = city_Zip;
        this.jobtitle_Occupation = jobtitle_Occupation;

        cs = con.prepareCall("{call CreateStaffMember(?,?,?,?,?,?,?,?,?)}");
        cs.setInt(1,staff_ID);
        cs.setString(2,staff_FName);
        cs.setString(3,staff_LName);
        cs.setString(4,staff_PhoneNo);
        cs.setString(5,staff_Mail);
        cs.setDate(6,staff_StarteDate);
        cs.setString(7,staff_Address);
        cs.setInt(8,city_Zip);
        cs.setString(9,jobtitle_Occupation);

        cs.execute();
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
