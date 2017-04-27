package Domain;

import Technical.DBFacade;
import Technical.FoodDB;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by LPNielsen on 25-04-2017.
 */
public class Food {
    private static DBFacade dbFacade = new DBFacade();
    private static String name;
    private static String desc;
    private static double price;
    private FoodDB foodDB = new FoodDB();

    public Food(String name, String desc, double price) throws SQLException{
        Food.name = name;
        Food.desc = desc;
        Food.price = price;
    }

    public void createFood() throws SQLException {
        foodDB.addFood(name,desc,price);
    }

    public void deleteFood(String name) throws SQLException{
        foodDB.deleteFood(name);
    }
}
