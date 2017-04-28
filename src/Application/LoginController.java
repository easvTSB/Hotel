package Application;

import Domain.Account;
import Technical.DBFacade;
import Technical.Encrypting;

import javax.swing.*;
import java.sql.*;

import static Technical.Encrypting.encrypt;

/**
 * Created by LPNielsen on 25-04-2017.
 */
public class LoginController {
    private Controller con = new Controller();
    private DBFacade dbFacade = new DBFacade();

    private String username;
    private String password;
    private char[] passwordArr;
    private int staffID;
    private String userLevel;
    private boolean verified;

    public LoginController(String username, char[] password) throws SQLException {
        this.username = username;
        this.passwordArr = password;
        generatePassword();
        getLoginVerification();
    }

    public void getLoginVerification() throws SQLException {
        verified = false;
        PreparedStatement ps = dbFacade.createStatement("SELECT user_UserName, user_Password, staff_ID, userlevel_UserType FROM Account");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tempUsername = rs.getString("user_UserName");
            String tempPassword = rs.getString("user_Password");
            if (username.equals(tempUsername) && password.equals(tempPassword)){
                staffID = rs.getInt("staff_ID");
                userLevel = rs.getString("userlevel_UserType");
                rs.close();
                verified = true;
                break;
            }
        }
    }

    public String getUserLevel() {
        return userLevel;
    }

    private void generatePassword() {
        String password = "";
        for (int i = 0; i < passwordArr.length; i++) {
            password+=passwordArr[i];
        }
        setPassword(encrypt(password));
    }

    public DBFacade getDbFacade() {
        return dbFacade;
    }

    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}
