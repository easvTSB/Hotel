package Technical;

import Domain.Bookings.Booking;
import Domain.Bookings.BookingTransactions;
import Domain.Customer;

import java.sql.*;

public class DBFacade {
    private String userName = "sa";
    private String password = "8520";
    private String port = "1433";
    private String databaseName = "Hotel";
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


}