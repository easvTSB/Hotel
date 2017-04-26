package Technical;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

/**
 * Created by Martynas on 2017-04-25.
 */
public class RoomService extends DBFacade {

    private long roomservice_ID;
    private long booking_ID;
    private String service_Service;
    private int roomservice_Quantity;
    private Date roomservice_Date;
    private Time roomservice_Time;

    public RoomService () throws SQLException{

    }

    public void createRoomService (long roomservice_ID,long booking_ID,String service_Service,int roomservice_Quantity,
                                   Date roomservice_Date, Time roomservice_Time ) throws SQLException{
        this.roomservice_ID = roomservice_ID;
        this.booking_ID = booking_ID;
        this.service_Service = service_Service;
        this.roomservice_Quantity = roomservice_Quantity;
        this.roomservice_Date = roomservice_Date;
        this.roomservice_Time = roomservice_Time;

        cs = con.prepareCall("{call CreateBooking(?,?,?,?,?,?)}");
        cs.setLong(1,roomservice_ID);
        cs.setLong(2,booking_ID);
        cs.setString(3,service_Service);
        cs.setInt(4,roomservice_Quantity);
        cs.setDate(5,roomservice_Date);
        cs.setTime(6,roomservice_Time);

        cs.execute();
    }


}
