package Application;

import Domain.Bookings.*;
import Domain.*;
import Technical.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Technical.Encrypting.encrypt;

/**
 * Created by LPNielsen on 26-Apr-17.
 */
public class Controller {
    private DBFacade db = new DBFacade();

    public ArrayList<String> foodNames = new ArrayList<String>();
    public ArrayList<String> foodDescriptions = new ArrayList<String>();
    public ArrayList<Double> foodPrices = new ArrayList<Double>();
    public ArrayList<String> staffFirstName = new ArrayList();

    /**
     * Creates a new customer with bookings.
     * @param firstName
     * @param lastName
     * @param mail
     * @param phone
     * @param address
     * @param zip
     * @param checkIn
     * @param checkout
     * @param comment
     * @param roomsBooked
     */
    public void createCusBooking(String firstName, String lastName, String mail, String phone, String address, int zip,
                                   String checkIn, String checkout,String comment, ArrayList<String> roomsBooked)  {

        db.createCustomer(new Customer(firstName,lastName,mail,phone,address,zip));
        db.createBookingCus(new Booking(1,false,comment));
        for(int i = 0 ; i < roomsBooked.size(); i++){
            db.createBookingTransactionCus(new BookingTransactions(roomsBooked.get(i),checkIn,checkout));
        }
    }

    /**
     * Creates booking with existing customer.
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param comment
     * @param roomsBooked
     */
    public void createBooking(long customerID, String checkIn, String checkOut,String comment, ArrayList<String> roomsBooked)  {

        db.createBooking(new Booking(1,false,comment),customerID);
        for(int i = 0 ; i < roomsBooked.size(); i++){
            db.createBookingTransactionCus(new BookingTransactions(roomsBooked.get(i),checkIn,checkOut));
        }

    }

    /** -------- ARRANGEMENT METHODS --------- */

    public void createCusArrangement(String firstName, String lastName, String mail, String phone, String address, int zip,
                                     String eventType,String eventDate, String comment, ArrayList<String> roomsBooked ){

        db.createCustomer(new Customer(firstName,lastName,mail,phone,address,zip));
        db.createArrangementCus(new Arrangement(eventType,1,false,comment));
        for(int i = 0 ; i < roomsBooked.size(); i++){
            db.createArrangementTransactionCus(new ArrangementTransactions(roomsBooked.get(i),eventDate));
        }


    }

    public void createArrangement(long customerID,String eventType,String eventDate, String comment, ArrayList<String> roomsBooked){
        db.createArrangement(new Arrangement(eventType,1,false,comment), customerID);
        for(int i = 0 ; i < roomsBooked.size(); i++){
            db.createArrangementTransactionCus(new ArrangementTransactions(roomsBooked.get(i),eventDate));
        }
    }

    /** -------- CATERING METHODS --------- */

    public void createCusCatering(String firstName, String lastName, String mail, String phone, String address, int zip,
                                  String deliveryAddress, int zipDeliv, int peopleQuantity,String deliveryDate,String comment){


    }

    public void createCatering(long customerID, String deliveryAddress, int zipDeliv, int peopleQuantity,String deliveryDate,
                               String comment){


    }

    /** -------- STAFF METHODS --------- */

    public void staffCreate(String fName, String lName, String phoneNo, String email,
                            String address, int zipCode, String jobTitle) {

        db.staffCreate(new Staff(fName, lName, phoneNo, email, address, zipCode, jobTitle));

    }

    public void accountCreate(String userName, String password, String userLevel){
        db.accountCreate(new Account(userName, password, userLevel));
    }

    /** -------- FOOD MENU METHODS --------- */

    public void viewNames()throws SQLException{
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Food;");

        for(int i = 0;i<30;i++){
            foodNames.add(null);
            foodDescriptions.add(null);
            foodPrices.add(null);
        }

        int i = 0;
        while (rs.next()) {   // only picking the first row
            String foodName = rs.getString(1);
            foodNames.add(i,foodName);

            String foodDescription = rs.getString(2);
            foodDescriptions.add(i,foodDescription);

            double foodPrice = rs.getDouble(3);
            foodPrices.add(i,foodPrice);

            i++;
        }
    }

    public void viewStaff()throws SQLException {
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Staff;");

        for (int i = 0; i < 50; i++) {
            staffFirstName.add(null);
        }

        int i = 0;
        while (rs.next()) {
            String firstName = rs.getString(2);
            staffFirstName.add(i, firstName);
            i++;
        }
    }
}
