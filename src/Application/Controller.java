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
    public Object[][] staff;
    public Object[][] jobs;
    public Object[][] foodMenu;
    public Object[][] bookingView;
    public Object[][] arrangementView;

    /**
     * Creates a new customer with bookings.
     *
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
                                 String checkIn, String checkout, String comment, ArrayList<String> roomsBooked) {

        db.createCustomer(new Customer(firstName, lastName, mail, phone, address, zip));
        db.createBookingCus(new Booking(1, false, comment));
        for (int i = 0; i < roomsBooked.size(); i++) {
            db.createBookingTransactionCus(new BookingTransactions(roomsBooked.get(i), checkIn, checkout));
        }
    }

    /**
     * Creates booking with existing customer.
     *
     * @param customerID
     * @param checkIn
     * @param checkOut
     * @param comment
     * @param roomsBooked
     */
    public void createBooking(long customerID, String checkIn, String checkOut, String comment, ArrayList<String> roomsBooked) {
        // Creates an booking with customer
        db.createBooking(new Booking(1, false, comment), customerID);
        // For loop creating corresponding booking transactions.
        for (int i = 0; i < roomsBooked.size(); i++) {
            db.createBookingTransactionCus(new BookingTransactions(roomsBooked.get(i), checkIn, checkOut));
        }

    }


    public void viewBooking() throws SQLException {
        bookingView = new Object[42][6];
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Booking;");
        int i = 0;
        while (rs.next()) {
            long booking_ID = rs.getLong(1);
            long customer_ID = rs.getLong(2);
            int staffID = rs.getInt(3);
            Date bookingDate = rs.getDate(4);
            boolean paid = rs.getBoolean(5);
            String comments = rs.getString(6);

            bookingView[i][0] = booking_ID;
            bookingView[i][1] = customer_ID;
            bookingView[i][2] = staffID;
            bookingView[i][3] = bookingDate;
            bookingView[i][4] = paid;
            bookingView[i][5] = comments;

            i++;
        }
    }
    /**
     * -------- ARRANGEMENT METHODS ---------
     */

    public void createCusArrangement(String firstName, String lastName, String mail, String phone, String address, int zip,
                                     String eventType, String eventDate, String comment, ArrayList<String> roomsBooked) {

        db.createCustomer(new Customer(firstName, lastName, mail, phone, address, zip));
        db.createArrangementCus(new Arrangement(eventType, 1, false, comment));
        for (int i = 0; i < roomsBooked.size(); i++) {
            db.createArrangementTransactionCus(new ArrangementTransactions(roomsBooked.get(i), eventDate));
        }


    }

    public void viewArrangement() throws SQLException {
        arrangementView = new Object[42][8];
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.arrangementView;");
        int i = 0;
        while (rs.next()) {
            long arrangementID = rs.getLong(1);
            String customerName = rs.getString(2);
            String staffName = rs.getString(3);
            Date arrangementDate = rs.getDate(4);
            Date eventDate = rs.getDate(5);
            String roomNo = rs.getString(6);
            double price = rs.getDouble(7);
            boolean paid = rs.getBoolean(8);

            arrangementView[i][0] = arrangementID;
            arrangementView[i][1] = customerName;
            arrangementView[i][2] = staffName;
            arrangementView[i][3] = arrangementDate;
            arrangementView[i][4] = eventDate;
            arrangementView[i][5] = roomNo;
            arrangementView[i][6] = price;
            arrangementView[i][7] = paid;

            i++;
        }
    }

    /**
     * Creates an arrangement and corresponding transactions, with an already existing customer.
     *
     * @param customerID
     * @param eventType
     * @param eventDate
     * @param comment
     * @param roomsBooked
     */
    public void createArrangement(long customerID, String eventType, String eventDate, String comment, ArrayList<String> roomsBooked) {
        // creates an arrangement with already existing customer
        db.createArrangement(new Arrangement(eventType, 1, false, comment), customerID);
        // For loop creating the arrangement transactions.
        for (int i = 0; i < roomsBooked.size(); i++) {
            db.createArrangementTransactionCus(new ArrangementTransactions(roomsBooked.get(i), eventDate));
        }
    }

    /**
     * -------- CATERING METHODS ---------
     */

    public void createCusCatering(String firstName, String lastName, String mail, String phone, String address, int zip,
                                  String deliveryAddress, int zipDeliv, int peopleQuantity, String deliveryTime, String deliveryDate, String comment,
                                  ArrayList<String> foodItems, ArrayList<Integer> foodAmount) {

        // Creates a customer.
        db.createCustomer(new Customer(firstName, lastName, mail, phone, address, zip));
        // Creates a catering order with the customer.
        db.createCateringCus(new Catering(1, deliveryAddress, zipDeliv, peopleQuantity, deliveryTime, deliveryDate, false, comment));
        // For loop that adds all the items related to the catering order.
        for (int i = 0; i < foodItems.size(); i++) {
            db.createCateringFood(new CateringTransactions(foodItems.get(i), foodAmount.get(i)));
        }

    }

    /**
     * Creates a catering order with already existing
     *
     * @param customerID
     * @param deliveryAddress
     * @param zipDeliv
     * @param peopleQuantity
     * @param deliveryDate
     * @param comment
     * @param foodItems
     * @param foodAmount
     */
    public void createCatering(long customerID, String deliveryAddress, int zipDeliv, int peopleQuantity, String deliveryDate,
                               String deliveryTime, String comment, ArrayList<String> foodItems, ArrayList<Integer> foodAmount) {

        // Creates a catering order with already existing customer.
        db.createCatering(new Catering(1, deliveryAddress, zipDeliv, peopleQuantity, deliveryTime, deliveryDate, false, comment), customerID);
        // For loop that adds all the items related to the catering order.
        for (int i = 0; i < foodItems.size(); i++) {
            db.createCateringFood(new CateringTransactions(foodItems.get(i), foodAmount.get(i)));
        }
    }

    /**
     * -------- Jobs METHODS ---------
     */

    public void jobCreate(String name, String desc) {
        db.jobCreate(new Job(name, desc));
    }

    public void jobDelete(String name) {
        db.jobDelete(name);
    }

    public void jobView() throws SQLException {
        jobs = new Object[30][2];
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.JobTitle;");
        int i = 0;
        while (rs.next()) {
            String title = rs.getString(1);
            String desc = rs.getString(2);

            jobs[i][0] = title;
            jobs[i][1] = desc;

            i++;
        }
    }

    /**
     * -------- STAFF METHODS ---------
     */

    public void staffCreate(String fName, String lName, String phoneNo, String email,
                            String address, int zipCode, String jobTitle) {

        db.staffCreate(new Staff(fName, lName, phoneNo, email, address, zipCode, jobTitle));

    }

    public void accountCreate(String userName, String password, String userLevel) {
        db.accountCreate(new Account(userName, password, userLevel));
    }

    public void staffDelete(int staff_ID){
        db.staffDelete(staff_ID);
    }

    public void viewStaff() throws SQLException {
        staff = new Object[30][9];
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.ViewStaff;");
        int i = 0;
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String email = rs.getString(3);
            String phoneNo = rs.getString(4);
            String address = rs.getString(5);
            int cityZip = rs.getInt(6);
            Date startDate = rs.getDate(7);
            String userName = rs.getString(8);
            String occupation = rs.getString(9);

            staff[i][0] = id;
            staff[i][1] = firstName;
            staff[i][2] = email;
            staff[i][3] = phoneNo;
            staff[i][4] = address;
            staff[i][5] = cityZip;
            staff[i][6] = startDate;
            staff[i][7] = userName;
            staff[i][8] = occupation;

            i++;
        }
    }




    /**
     * -------- FOOD MENU METHODS ---------
     */

    public void viewFood() throws SQLException {
        foodMenu = new Object[38][4];
        db.stmt = db.con.createStatement();
        ResultSet rs = db.stmt.executeQuery("SELECT * FROM dbo.Food;");
        int i = 0;
        while (rs.next()) {
            String foodName = rs.getString(1);
            String foodDescription = rs.getString(2);
            Double foodPrice = rs.getDouble(3);

            foodMenu[i][0] = foodName;
            foodMenu[i][1] = foodDescription;
            foodMenu[i][2] = foodPrice;

            i++;
        }
    }


}
