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
    private static DBFacade dbFacade = new DBFacade();

    private static PreparedStatement ps = null;
    private static Connection con = null;
    private static Statement stmt = null;

    private static String username;
    private static String password;
    private static String staffID;
    private static String userLevel;

    public boolean getLoginVerification(Account account) throws SQLException {
        PreparedStatement ps = dbFacade.createStatement("SELECT user_UserName, user_Password, userlevel_UserType  FROM Account");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            username = rs.getString("user_UserName");
            password = rs.getString("user_Password");
            userLevel = rs.getString("userlevel_UserType");
            if (username.equals(account.getUserName()) && password.equals(account.getPassword())){

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
