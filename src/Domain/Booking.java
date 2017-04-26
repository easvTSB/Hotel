package Domain;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Booking {
    private int bookingID;
    private int customerID;
    private int staffID;
    private int bookingDate;
    private double totalPrice;
    private boolean paid;
    private String comment;

    public Booking(int bookingID, int customerID, int staffID, int bookingDate, boolean paid, String comment) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.bookingDate = bookingDate;
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

    public int getBookingDate() {
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
