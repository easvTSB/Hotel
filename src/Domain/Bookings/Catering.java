package Domain.Bookings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Catering {
    private int cateringOrderID;
    private int customerID;
    private int staffID;
    private String deliveryAddress;
    private int zip;
    private int peopleQuantity;
    private String dateOrdered;
    private String deliveryDate;
    private boolean paid;

    /**
     * Constructor for creating a catering order.
     * @param customerID
     * @param staffID
     * @param deliveryAddress
     * @param zip
     * @param peopleQuantity
     * @param deliveryDate
     * @param paid
     */
    public Catering(int customerID, int staffID, String deliveryAddress, int zip, int peopleQuantity,
                     String deliveryDate, boolean paid) {
        this.customerID = customerID;
        this.staffID = staffID;
        this.deliveryAddress = deliveryAddress;
        this.zip = zip;
        this.peopleQuantity = peopleQuantity;
        LocalDate localDate = LocalDate.now();
        this.dateOrdered = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
        this.deliveryDate = deliveryDate;
        this.paid = paid;
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
                    String dateOrdered, String deliveryDate, boolean paid) {
        this.cateringOrderID = cateringOrderID;
        this.customerID = customerID;
        this.staffID = staffID;
        this.deliveryAddress = deliveryAddress;
        this.zip = zip;
        this.peopleQuantity = peopleQuantity;
        this.dateOrdered = dateOrdered;
        this.deliveryDate = deliveryDate;
        this.paid = paid;
    }

    public int getCateringOrderID() {
        return cateringOrderID;
    }

    public int getCustomerID() {
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public boolean isPaid() {
        return paid;
    }
}
