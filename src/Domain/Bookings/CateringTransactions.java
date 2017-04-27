package Domain.Bookings;

/**
 * Created by Sebas on 24-04-2017.
 */
public class CateringTransactions {
    private int cateringOrderID;
    private String foodName;
    private int quantity;

    /**
     * Constructor for a new catering order transaction.
     * @param foodName
     * @param quantity
     */
    public CateringTransactions(String foodName, int quantity) {
        this.foodName = foodName;
        this.quantity = quantity;
    }

    /**
     * Constuctor for already existing catering order transaction.
     * @param cateringOrderID
     * @param foodName
     * @param quantity
     */
    public CateringTransactions(int cateringOrderID, String foodName, int quantity) {
        this.cateringOrderID = cateringOrderID;
        this.foodName = foodName;
        this.quantity = quantity;
    }

    public int getCateringOrderID() {
        return cateringOrderID;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }
}
