package Technical;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Martynas on 2017-04-24.
 */
public class BookingDB extends MainJDBC {

    private long booking_ID;
    private long customer_ID;
    private int staff_ID;
    private Date bookingDate;
    private boolean booking_Paid;
    private String booking_Comment;

    public BookingDB() throws SQLException{

    }

    public void createBooking (long booking_ID,long customer_ID,int staff_ID,Date bookingDate,
                               boolean booking_Paid,String booking_Comment) throws SQLException{
        this.booking_ID = booking_ID;
        this.customer_ID = customer_ID;
        this.staff_ID = staff_ID;
        this.bookingDate = bookingDate;
        this.booking_Paid = booking_Paid;
        this.booking_Comment = booking_Comment;

        cs = con.prepareCall("{call CreateBooking(?,?,?,?,?,?)}");
        cs.setLong(1,booking_ID);
        cs.setLong(2,customer_ID);
        cs.setInt(3,staff_ID);
        cs.setDate(4,bookingDate);
        cs.setBoolean(5,booking_Paid);
        cs.setString(6,booking_Comment);

        cs.execute();
    }

    public void deleteBooking (long booking_ID) throws SQLException{
        cs = con.prepareCall("{call DeleteBooking(?)}");
        cs.setLong(1,booking_ID);

        cs.execute();
    }

    public void editBookingCustomerID (long booking_ID, long customer_ID) throws SQLException{
        cs = con.prepareCall("{call EditBookingCustomerID(?,?)}");
        cs.setLong(1,booking_ID);
        cs.setLong(2,customer_ID);

        cs.execute();
    }

    public void editBookingStaffID (long booking_ID, int staff_ID) throws SQLException{
        cs = con.prepareCall("{call EditBookingStaffID(?,?)}");
        cs.setLong(1,booking_ID);
        cs.setInt(2,staff_ID);

        cs.execute();
    }

    public void editBookingDate (long booking_ID, Date bookingDate) throws SQLException{
        cs = con.prepareCall("{call EditBookingDate(?,?)}");
        cs.setLong(1,booking_ID);
        cs.setDate(2,bookingDate);

        cs.execute();
    }

    public void editBookingPaid (long booking_ID, boolean booking_Paid) throws SQLException{
        cs = con.prepareCall("{call EditBookingPaid(?,?)}");
        cs.setLong(1,booking_ID);
        cs.setBoolean(2,booking_Paid);

        cs.execute();
    }

    public void editBookingComment (long booking_ID, String booking_Comment) throws SQLException{
        cs = con.prepareCall("{call EditBookingComment(?,?)}");
        cs.setLong(1,booking_ID);
        cs.setString(2,booking_Comment);

        cs.execute();
    }


}
