package Application;

import Domain.Account;
import Technical.DBFacade;

import javax.swing.*;
import java.sql.*;

import static Technical.Encrypting.encrypt;

/**
 * Created by LPNielsen on 25-04-2017.
 */
public class LoginController {
    private DBFacade dbFacade = new DBFacade();

    private String username;
    private String password;
    private int staffID;
    private String userLevel;

    public boolean getLoginVerification(Account account) throws SQLException {
        PreparedStatement ps = dbFacade.createStatement("SELECT user_UserName, user_Password, staff_ID, userlevel_UserType FROM Account");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            username = rs.getString("user_UserName");
            password = rs.getString("user_Password");
            if (username.equals(account.getUserName()) && password.equals(account.getPassword())){
                staffID = rs.getInt("staff_ID");
                userLevel = rs.getString("userlevel_UserType");
                rs.close();
                return true;
            }
        }
        rs.close();
        return false;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public boolean verifyLogin(JTextField loginUsername,JPasswordField passwordField) throws SQLException {
        String username = loginUsername.getText();
        String password = getPassword(passwordField);

        Account tempAccount = Creator.tempVerifyAccount(username,password);

        return getLoginVerification(tempAccount);
    }

    public String getPassword(JPasswordField loginPassword) {
        String password = "";
        for (int i = 0; i < loginPassword.getPassword().length; i++) {
            password+=loginPassword.getPassword()[i];
        }
        password = encrypt(password);
        return password;
    }
}
