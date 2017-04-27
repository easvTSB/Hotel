package Application;

import Domain.Bookings.*;
import Domain.*;
import Technical.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LPNielsen on 26-Apr-17.
 */
public class Controller {
    private DBFacade db = new DBFacade();

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
     * @throws SQLException
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

    public void createCusCatering(){


    }

    public void createCatering(){


    }

}
