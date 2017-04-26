package Domain;

import Technical.DBFacade;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by LPNielsen on 25-04-2017.
 */
public class Food {
    private static DBFacade dbFacade = new DBFacade();
    private static String name;
    private static String desc;
    private static int price;

    public Food(String name, String desc, int price) {
        Food.name = name;
        Food.desc = desc;
        Food.price = price;
    }

    public static void createFood() throws SQLException {
        CallableStatement cl = dbFacade.createCallable("insert into Food values (?,?,?)");
        cl.setString(1, name);
        cl.setString(2, desc);
        cl.setInt(3, price);
        cl.execute();
        cl.close();
    }
}
