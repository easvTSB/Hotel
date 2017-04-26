package Domain;

public class ArrangementTransactions {
    private int arrangementID;
    private String roomNo;
    private String eventDate;
    private boolean paid;

    /**
     * Constructor for a general bookingtransaction. A representation of the database table.
     * @param arrangementID
     * @param roomNo
     * @param eventDate
     * @param paid
     */
    public ArrangementTransactions(int arrangementID, String roomNo, String eventDate, boolean paid) {
        this.arrangementID = arrangementID;
        this.roomNo = roomNo;
        this.eventDate = eventDate;
        this.paid = paid;
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

    public boolean isPaid() {
        return paid;
    }
}
