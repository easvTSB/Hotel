package Domain.Bookings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Catering {
    private int cateringOrderID;
    private long customerID;
    private int staffID;
    private String deliveryAddress;
    private int zip;
    private int peopleQuantity;
    private String dateOrdered;
    private String deliveryTime;
    private String deliveryDate;
    private boolean paid;
    private String comment;

    /**
     * Constructor for creating a catering order.
     * @param staffID
     * @param deliveryAddress
     * @param zip
     * @param peopleQuantity
     * @param deliveryDate
     * @param paid
     */
    public Catering(int staffID, String deliveryAddress, int zip, int peopleQuantity,String deliveryTime,
                     String deliveryDate, boolean paid, String comment) {
        this.staffID = staffID;
        this.deliveryAddress = deliveryAddress;
        this.zip = zip;
        this.peopleQuantity = peopleQuantity;
        LocalDate localDate = LocalDate.now();
        this.dateOrdered = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
        this.deliveryTime = deliveryTime;
        this.deliveryDate = deliveryDate;
        this.paid = paid;
        this.comment = comment;
    }

    /**
     * Constructor for already existing orders from the database.
     * @param cateringOrderID
     * @param customerID
     * @param staffID
     * @param deliveryAddress
     * @param zip
     * @param peopleQuantity
     * @param dateOrdered
     * @param deliveryDate
     * @param paid
     */
    public Catering(int cateringOrderID, int customerID, int staffID, String deliveryAddress, int zip, int peopleQuantity,
                    String dateOrdered,String deliveryTime, String deliveryDate, boolean paid, String comment) {
        this.cateringOrderID = cateringOrderID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.deliveryAddress = deliveryAddress;
        this.zip = zip;
        this.peopleQuantity = peopleQuantity;
        this.dateOrdered = dateOrdered;
        this.deliveryTime = deliveryTime;
        this.deliveryDate = deliveryDate;
        this.paid = paid;
        this.comment = comment;
    }

    public int getCateringOrderID() {
        return cateringOrderID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getZip() {
        return zip;
    }

    public int getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getComment() {
        return comment;
    }
}
