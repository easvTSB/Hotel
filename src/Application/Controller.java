package Application;

import Domain.Bookings.*;
import Domain.*;
import Technical.*;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Technical.Encrypting.encrypt;

/**
 * Created by LPNielsen on 26-Apr-17.
 */
public class Controller {
    private DBFacade db = new DBFacade();
    //
    public Object [][] staff = new Object[30][9];
    public Object [][] foodMenu = new Object[38][4];

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
        // Creates an booking with customer
        db.createBooking(new Booking(1,false,comment),customerID);
        // For loop creating corresponding booking transactions.
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

    /**
     * Creates an arrangement and corresponding transactions, with an already existing customer.
     * @param customerID
     * @param eventType
     * @param eventDate
     * @param comment
     * @param roomsBooked
     */
    public void createArrangement(long customerID,String eventType,String eventDate, String comment, ArrayList<String> roomsBooked){
        // creates an arrangement with already existing customer
        db.createArrangement(new Arrangement(eventType,1,false,comment), customerID);
        // For loop creating the arrangement transactions.
        for(int i = 0 ; i < roomsBooked.size(); i++){
            db.createArrangementTransactionCus(new ArrangementTransactions(roomsBooked.get(i),eventDate));
        }
    }

    /** -------- CATERING METHODS --------- */

    public void createCusCatering(String firstName, String lastName, String mail, String phone, String address, int zip,
                                  String deliveryAddress, int zipDeliv, int peopleQuantity,String deliveryTime,String deliveryDate,String comment,
                                  ArrayList<String> foodItems, ArrayList<Integer> foodAmount){

        // Creates a customer.
        db.createCustomer(new Customer(firstName,lastName,mail,phone,address,zip));
        // Creates a catering order with the customer.
        db.createCateringCus(new Catering(1,deliveryAddress,zipDeliv,peopleQuantity,deliveryTime,deliveryDate,false,comment));
        // For loop that adds all the items related to the catering order.
        for(int i = 0 ; i < foodItems.size() ; i++){
            db.createCateringFood(new CateringTransactions(foodItems.get(i),foodAmount.get(i)));
        }

    }

    /**
     * Creates a catering order with already existing
     * @param customerID
     * @param deliveryAddress
     * @param zipDeliv
     * @param peopleQuantity
     * @param deliveryDate
     * @param comment
     * @param foodItems
     * @param foodAmount
     */
    public void createCatering(long customerID,String deliveryAddress, int zipDeliv, int peopleQuantity,String deliveryDate,
                               String deliveryTime,String comment, ArrayList<String> foodItems, ArrayList<Integer> foodAmount){

        // Creates a catering order with already existing customer.
        db.createCatering(new Catering(1,deliveryAddress,zipDeliv,peopleQuantity,deliveryTime,deliveryDate,false,comment), customerID);
        // For loop that adds all the items related to the catering order.
        for(int i = 0 ; i < foodItems.size() ; i++){
            db.createCateringFood(new CateringTransactions(foodItems.get(i),foodAmount.get(i)));
        }
    }

    /** -------- STAFF METHODS --------- */

    public void staffCreate(String fName, String lName, String phoneNo, String email,
                            String address, int zipCode, String jobTitle) {

        db.staffCreate(new Staff(fName, lName, phoneNo, email, address, zipCode, jobTitle));

    }

    public void accountCreate(String userName, String password, String userLevel){
        db.accountCreate(new Account(userName, password, userLevel));
    }

    public void viewStaff()throws SQLException{

        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Staff;");
        int i = 0;
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String phoneNo = rs.getString(4);
            String email = rs.getString(5);
            Date startDate = rs.getDate(6);
            String address = rs.getString(7);
            int cityZip = rs.getInt(8);
            String occupation = rs.getString(9);

            staff[i][0]=id ;
            staff[i][1]=firstName;
            staff[i][2]=lastName;
            staff[i][3]=phoneNo;
            staff[i][4]=email;
            staff[i][5]=startDate;
            staff[i][6]=address;
            staff[i][7]=cityZip;
            staff[i][8]=occupation;

            i++;
        }
    }

    /** -------- FOOD MENU METHODS --------- */


    public void viewFood() throws SQLException{

        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Food;");
        int i = 0;
        while (rs.next()) {
            String foodName = rs.getString(1);
            String foodDescription = rs.getString(2);
            Double foodPrice = rs.getDouble(3);

            foodMenu[i][0] = null;
            foodMenu[i][1] = foodName;
            foodMenu[i][2] = foodDescription;
            foodMenu[i][3] = foodPrice;

            i++;
        }
    }
}
