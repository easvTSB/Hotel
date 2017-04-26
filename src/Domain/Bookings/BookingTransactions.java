package Domain.Bookings;

/**
 * Created by Sebas on 24-04-2017.
 */
public class BookingTransactions {
    private int bookingID;
    private String roomNo;
    private String checkIn;
    private String checkOut;

    /**
     * Constructor for new booking transactions.
     * @param roomNo
     * @param checkIn
     * @param checkOut
     */
    public BookingTransactions(String roomNo, String checkIn, String checkOut) {
        this.roomNo = roomNo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    /**
     * Constructor for already existing booking transactions.
     * @param bookingID
     * @param roomNo
     * @param checkIn
     * @param checkOut
     */
    public BookingTransactions(int bookingID, String roomNo, String checkIn, String checkOut) {
        this.bookingID = bookingID;
        this.roomNo = roomNo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }
}
