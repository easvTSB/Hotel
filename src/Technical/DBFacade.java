package Technical;

import Domain.Account;
import Domain.Bookings.*;
import Domain.Customer;
import Domain.Job;
import Domain.Staff;

import java.sql.*;

public class DBFacade {
    private String userName = "sa";
    private String password = "123456";
    private String port = "1433";
    private String databaseName = "Hotel";
    public Statement stmt;
    public Connection con;
    private PreparedStatement ps;
    public CallableStatement cs;

    public DBFacade() {
        openConnection();
    }

    /**
     * Open connection to the database
     */
    private void openConnection()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName,userName,password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement createStatement(String sql) throws SQLException {
        ps = con.prepareStatement(sql);
        return ps;
    }

    public CallableStatement createCallable(String sql) throws SQLException {
        cs = con.prepareCall(sql);
        return cs;
    }

    private void closeConnection() {
        try {
            ps.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void createCustomer (Customer cus) {
        try {
            cs = con.prepareCall("{call CreateCustomer(?,?,?,?,?,?)}");
            cs.setString(1,cus.getfName());
            cs.setString(2,cus.getlName());
            cs.setString(3,cus.getMail());
            cs.setString(4,cus.getPhoneNo());
            cs.setString(5,cus.getAddress());
            cs.setInt(6,cus.getZip());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createBooking (Booking b, long customerID)  {

        try {
            cs = con.prepareCall("{call insert_BookingCus(?,?,?,?,?)}");
            cs.setLong(1,customerID);
            cs.setInt(2,b.getStaffID());
            cs.setString(3,b.getBookingDate());
            cs.setBoolean(4,b.isPaid());
            cs.setString(5,b.getComment());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void createBookingCus (Booking b) {

        try {
            cs = con.prepareCall("{call insert_BookingCus(?,?,?,?)}");
            cs.setInt(1,b.getStaffID());
            cs.setString(2,b.getBookingDate());
            cs.setBoolean(3,b.isPaid());
            cs.setString(4,b.getComment());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createBookingTransactionCus(BookingTransactions bt){
        try {
            cs = con.prepareCall("{call InsertBookingTransaction(?,?,?)}");
            cs.setString(1,bt.getRoomNo());
            cs.setString(2,bt.getCheckIn());
            cs.setString(3,bt.getCheckOut());

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createArrangement(Arrangement ar, long customerID ){
        try {
            cs = con.prepareCall("{call CreateArrangement(?,?,?,?,?,?)}");
            cs.setString(1,ar.getEventType());
            cs.setLong(2,customerID);
            cs.setInt(3,ar.getStaffID());
            cs.setString(4,ar.getDayOrderPlaced());
            cs.setBoolean(5,ar.isPaid());
            cs.setString(6,ar.getComment());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createArrangementCus (Arrangement ar) {
        try {
            cs = con.prepareCall("{call insert_ArrangeCus(?,?,?,?,?)}");
            cs.setString(1,ar.getEventType());
            cs.setInt(2,ar.getStaffID());
            cs.setString(3,ar.getDayOrderPlaced());
            cs.setBoolean(4,ar.isPaid());
            cs.setString(5,ar.getComment());

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createArrangementTransactionCus(ArrangementTransactions arrT) {
        try {
            cs = con.prepareCall("{call InsertArrangementTransaction(?,?)}");
            cs.setString(1, arrT.getRoomNo());
            cs.setString(2, arrT.getEventDate());

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createCatering(Catering c, long customerID){
        try {
            cs = con.prepareCall("{call insert_catering(?,?,?,?,?,?,?,?,?,?)}");
            cs.setLong(1,customerID);
            cs.setInt(2,c.getStaffID());
            cs.setString(3,c.getDeliveryAddress());
            cs.setInt(4,c.getZip());
            cs.setInt(5,c.getPeopleQuantity());
            cs.setString(6,c.getDateOrdered());
            cs.setString(7,c.getDeliveryTime());
            cs.setString(8,c.getDeliveryDate());
            cs.setBoolean(9,c.isPaid());
            cs.setString(10,c.getComment());

            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCateringCus(Catering c){
        try {
            cs = con.prepareCall("{call insert_cateringCus(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,c.getStaffID());
            cs.setString(2,c.getDeliveryAddress());
            cs.setInt(3,c.getZip());
            cs.setInt(4,c.getPeopleQuantity());
            cs.setString(5,c.getDateOrdered());
            cs.setString(6,c.getDeliveryTime());
            cs.setString(7,c.getDeliveryDate());
            cs.setBoolean(8,c.isPaid());
            cs.setString(9,c.getComment());

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCateringFood(CateringTransactions ct){
        try {
            cs = con.prepareCall("{call InsertCatteringTransaction(?,?)}");
            cs.setString(1,ct.getFoodName());
            cs.setInt(2,ct.getQuantity());

            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginAccount(Account acc){

    }

    public void staffCreate(Staff staff){
        try {
            cs = con.prepareCall("{call CreateStaffMember(?,?,?,?,?,?,?,?)}");
            cs.setString(1,staff.getfName());
            cs.setString(2,staff.getlName());
            cs.setString(3,staff.getPhoneNo());
            cs.setString(4,staff.getEmail());
            cs.setString(5, staff.getLocalDate().toString());
            cs.setString(6,staff.getAddress());
            cs.setInt(7,staff.getZipCode());
            cs.setString(8,staff.getJobTitle());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void staffDelete(int staff_id) {
        try {
            cs = con.prepareCall("{call DeleteStaffMember(?)}");
            cs.setInt(1, staff_id);

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void jobCreate(Job job){
        try {
            cs = con.prepareCall("{call CreateJob(?,?)}");
            cs.setString(1,job.getName());
            cs.setString(2,job.getDesc());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void jobDelete(String job_name) {
        try {
            cs = con.prepareCall("{call DeleteJob(?)}");
            cs.setString(1, job_name);

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void accountCreate(Account acc){
        String password = Encrypting.encrypt(acc.getPassword());
        try {
            cs = con.prepareCall("{call CreateAccount(?,?,?)}");
            cs.setString(1,acc.getUserName());
            cs.setString(2,password);
            cs.setString(3,acc.getUserLevel());

            cs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}