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
