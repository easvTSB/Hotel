package Technical;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Martynas on 2017-04-24.
 */
public class CustomerDB extends DBFacade {

    private long customer_ID;
    private String customer_FName;
    private String customer_LName;
    private String customer_Mail;
    private String customer_PhoneNo;
    private String customer_Address;
    private int city_Zip;

    public CustomerDB()throws SQLException{

    }

    public void createCustomer (long customer_ID,String customer_FName,String customer_LName,
                                String customer_Mail,String customer_PhoneNo,String customer_Address,
                                int city_Zip) throws SQLException{
        this.customer_ID = customer_ID;
        this.customer_FName = customer_FName;
        this.customer_LName = customer_LName;
        this.customer_Mail = customer_Mail;
        this.customer_PhoneNo = customer_PhoneNo;
        this.customer_Address = customer_Address;
        this.city_Zip = city_Zip;

        cs = con.prepareCall("{call CreateBooking(?,?,?,?,?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_FName);
        cs.setString(3,customer_LName);
        cs.setString(4,customer_Mail);
        cs.setString(5,customer_PhoneNo);
        cs.setString(6,customer_Address);
        cs.setInt(7,city_Zip);

        cs.execute();
    }

    public void deleteCustomer (long customer_ID) throws SQLException{
        cs = con.prepareCall("{call DeleteCustomer(?)}");
        cs.setLong(1,customer_ID);

        cs.execute();
    }

    public void editCustomerFirstName (long customer_ID, String customer_FName) throws SQLException{
        cs = con.prepareCall("{call EditCustomerFirstName(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_FName);

        cs.execute();
    }

    public void editCustomerLastName (long customer_ID, String customer_LName) throws SQLException{
        cs = con.prepareCall("{call EditCustomerLastName(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_LName);

        cs.execute();
    }

    public void editCustomerMail (long customer_ID, String customer_Mail) throws SQLException{
        cs = con.prepareCall("{call EditCustomerMail(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_Mail);

        cs.execute();
    }

    public void editCustomerPhoneNo (long customer_ID, String customer_PhoneNo) throws SQLException{
        cs = con.prepareCall("{call EditCustomerPhoneNo(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_PhoneNo);

        cs.execute();
    }

    public void editCustomerAddress (long customer_ID, String customer_Address) throws SQLException{
        cs = con.prepareCall("{call EditCustomerAddress(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setString(2,customer_Address);

        cs.execute();
    }

    public void editCustomerCityZip (long customer_ID, int city_Zip) throws SQLException{
        cs = con.prepareCall("{call EditCustomerCityZip(?,?)}");
        cs.setLong(1,customer_ID);
        cs.setInt(2,city_Zip);

        cs.execute();
    }



}
