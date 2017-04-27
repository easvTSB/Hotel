package Domain;

import Technical.DBFacade;
import Technical.Encrypting;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


/**
 * Created by Sebas on 25-04-2017.
 */
public class Account {
    private String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
    private Random rand = new Random();
    private String fName;
    private int ID;
    private String lName;
    private String userName;
    private String passWord;
    private String userLevel;

    public Account(String FName, String LName, String userLevel){
        this.fName = FName;
        this.lName = LName;
        this.userLevel = userLevel;

        generateUsername(fName,lName);
        generatePassword();
        JOptionPane.showMessageDialog(null,"Username: "+getUserName()+"\nPassword: "+getPassword());
    }

    public Account(String username, String passWord){
        this.userName = username;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassword() {
        return passWord;
    }

    public String getUserLevel() {
        return userLevel;
    }

    private void generateUsername(String fName, String lName){
        String username = "";
        for (int i = 0; i < fName.length(); i++) {
            if (i <=3) {
                username += fName.charAt(i);
            }
        }
        for (int i = 0; i <= 1; i++) {
            username+=lName.charAt(i);
        }

        username+=Integer.toString(rand.nextInt(9999)+1000);
        userName = username;
    }

    private void generatePassword() {
        String password = "";
        for (int i = 1; i<=6;i++){
            password += symbols.charAt(rand.nextInt(symbols.length()));
        }
        passWord = password;
    }
}