package Domain;

public class Room {
    private String roomNo;
    private String roomType;
    private String roomTypeDescription;
    private String roomDescription;
    private double price;

    public Room(String roomNo, String roomType, String roomTypeDescription, String roomDescription, double price) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomTypeDescription = roomTypeDescription;
        this.roomDescription = roomDescription;
        this.price = price;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
