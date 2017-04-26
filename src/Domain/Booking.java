package Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Booking {
    private int bookingID;
    private int customerID;
    private int staffID;
    private String bookingDate;
    private double totalPrice;
    private boolean paid;
    private String comment;

    /**
     * Constructor used for a new booking.
     * @param customerID
     * @param staffID
     * @param paid
     * @param comment
     */
    public Booking(int customerID, int staffID, boolean paid, String comment) {
        this.customerID = customerID;
        this.staffID = staffID;
        LocalDate localDate = LocalDate.now();
        this.bookingDate = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
        this.paid = paid;
        this.comment = comment;
    }

    /**
     * Constructor for already existing booking.
     * @param bookingID
     * @param customerID
     * @param staffID
     * @param bookingDate
     * @param totalPrice
     * @param paid
     * @param comment
     */
    public Booking(int bookingID, int customerID, int staffID, String bookingDate, double totalPrice, boolean paid, String comment) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.bookingDate = bookingDate;
        this.totalPrice = totalPrice;
        this.paid = paid;
        this.comment = comment;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getComment() {
        return comment;
    }

        // TO-DO
    private double calculateTotalPrice(BookingTransactions bt){
        double priceCalculated = 0;

        return priceCalculated;
    }
}
