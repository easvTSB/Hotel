package Application;

import Domain.Account;
import Domain.Food;
import Domain.Staff;

import java.sql.SQLException;

/**
 * Created by LPNielsen on 25-Apr-17.
 */
public class Creator {

    public static Account tempVerifyAccount(String username, String password){
        Account tempAccount = new Account(username,password);
        return tempAccount;
    }

    public static Account createStaffAccount(String username, String password, String userLevel){
        Account tempAccount = new Account(username,password,userLevel);
        return tempAccount;
    }

    public static Staff createStaff(String fName, String lName, String phoneNo, String email, String address, int zipCode, String jobTitle){
        Staff tempStaff = new Staff(fName,lName,phoneNo,email,address,zipCode,jobTitle);
        return tempStaff;
    }

    public static Food createFood(String name, String desc, int price) throws SQLException {
        Food tempFood = new Food(name,desc,price);
        return tempFood;
    }
}
