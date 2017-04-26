package Technical;

import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Martynas on 2017-04-24.
 */
public class ArrangementDB extends MainJDBC {

    private long arrangement_ID;
    private String event_Type;
    private long customer_ID;
    private int staff_ID;
    private Date arrDate;
    private boolean paid;
    private String comment;


    public ArrangementDB () throws SQLException{

    }

    public void createArrangement (long arrangement_ID, String event_Type, long customer_ID, int staff_ID,
                                   Date arrDate,boolean paid,String comment) throws SQLException{
        this.arrangement_ID = arrangement_ID;
        this.event_Type = event_Type;
        this.customer_ID = customer_ID;
        this.staff_ID = staff_ID;
        this.arrDate = arrDate;
        this.paid = paid;
        this.comment = comment;

        cs = con.prepareCall("{call CreateArrangement(?,?,?,?,?,?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setString(2,event_Type);
        cs.setLong(3,customer_ID);
        cs.setInt(4,staff_ID);
        cs.setDate(5,arrDate);
        cs.setBoolean(6,paid);
        cs.setString(7,comment);

        cs.execute();
    }

    public void DeleteArrangement (long arrangement_ID) throws SQLException{
        cs = con.prepareCall("{call DeleteArrangement(?)}");
        cs.setLong(1,arrangement_ID);

        cs.execute();
    }

    public void editArrangementEventType (long arrangement_ID, String event_Type) throws SQLException{
        cs = con.prepareCall("{call EditArrangementEventType(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setString(2,event_Type);

        cs.execute();
    }

    public void editArrangementCustomerID (long arrangement_ID, long customer_ID) throws SQLException{
        cs = con.prepareCall("{call EditArrangementCustomerID(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setLong(2, customer_ID);

        cs.execute();
    }

    public void editArrangementStaffID (long arrangement_ID, int staff_ID) throws SQLException{
        cs = con.prepareCall("{call EditArrangementStaffID(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setInt(2,staff_ID);

        cs.execute();
    }

    public void editArrangementArrDate (long arrangement_ID, Date arrDate) throws SQLException{
        cs = con.prepareCall("{call EditArrangementArrDate(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setDate(2,arrDate);

        cs.execute();
    }

    public void editArrangementPaid (long arrangement_ID, boolean paid) throws SQLException{
        cs = con.prepareCall("{call EditArrangementPaid(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setBoolean(2,paid);

        cs.execute();
    }

    public void editArrangementComment (long arrangement_ID, String comment) throws SQLException{
        cs = con.prepareCall("{call EditArrangementComment(?,?)}");
        cs.setLong(1,arrangement_ID);
        cs.setString(2,comment);

        cs.execute();
    }
}
