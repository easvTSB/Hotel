package Domain;

import Technical.Encrypting;

import java.util.Random;


/**
 * Created by Sebas on 25-04-2017.
 */
public class Account {
    private String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
    private Random rand = new Random();
    private String userName;
    private String passWord;
    private String userLevel;

    public Account(String username, String password){
        userName = username;
        passWord = password;
    }

    public Account(String userName, String password, String userLevel) {
        this.userName = userName;
        this.passWord = password;
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return passWord;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setPassword(){
        generatePassword();
    }

    public void setUserName(String fName, String lName){
        generateUsername(fName,lName);
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
        password = Encrypting.encrypt(password);
        passWord = password;
    }
}