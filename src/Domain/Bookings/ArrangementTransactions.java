package Domain.Bookings;

public class ArrangementTransactions {
    private int arrangementID;
    private String roomNo;
    private String eventDate;

    /**
     * Constructor for a new Arrangement Transaction
     * @param roomNo
     * @param eventDate

     */
    public ArrangementTransactions(String roomNo, String eventDate) {
        this.roomNo = roomNo;
        this.eventDate = eventDate;
    }

    /**
     * Constructor for a already existing transaction.
     * @param arrangementID
     * @param roomNo
     * @param eventDate
     */
    public ArrangementTransactions(int arrangementID, String roomNo, String eventDate) {
        this.arrangementID = arrangementID;
        this.roomNo = roomNo;
        this.eventDate = eventDate;
    }

    public int getArrangementID() {
        return arrangementID;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getEventDate() {
        return eventDate;
    }

}
