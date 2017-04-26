package Domain;

/**
 * Created by Sebas on 26-04-2017.
 */
public class Arrangement {
    private int arrangementID;
    private String eventType;
    private String customerID;
    private String staffID;
    private String dayOrderPlaced;
    private boolean isPaid;
    private String comment;
    private double totalPrice;

    public Arrangement(int arrangementID, String eventType, String customerID, String staffID, String dayOrderPlaced, boolean isPaid, String comment) {
        this.arrangementID = arrangementID;
        this.eventType = eventType;
        this.customerID = customerID;
        this.staffID = staffID;
        this.dayOrderPlaced = dayOrderPlaced;
        this.isPaid = isPaid;
        this.comment = comment;
    }

    public int getArrangementID() {
        return arrangementID;
    }

    public String getEventType() {
        return eventType;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getDayOrderPlaced() {
        return dayOrderPlaced;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getComment() {
        return comment;
    }

}
