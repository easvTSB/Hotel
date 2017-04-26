package Technical;

import java.sql.SQLException;

/**
 * Created by Martynas on 2017-04-24.
 */
public class FoodDB extends DBFacade{
    private String food_Name;
    private String food_Description;
    private double food_Price;

    public FoodDB () throws SQLException {

    }

    public void addFood(String food_Name, String food_Description,double food_Price) throws SQLException {
        this.food_Name = food_Name;
        this.food_Description = food_Description;
        this.food_Price = food_Price;

        cs = con.prepareCall("{call CreateFood(?,?,?)}");
        cs.setString(1,food_Name);
        cs.setString(2,food_Description);
        cs.setDouble(3,food_Price);

        cs.execute();
    }

    public void deleteFood(String food_Name) throws SQLException{
        cs = con.prepareCall("{call DeleteFood(?)}");
        cs.setString(1,food_Name);

        cs.execute();
    }

    public void EditFoodPrice(String food_Name,double food_Price) throws SQLException{
        cs = con.prepareCall("{call EditFoodPrice(?,?)}");
        cs.setString(1,food_Name);
        cs.setDouble(2,food_Price);

        cs.execute();
    }

    public void EditFoodDescription(String food_Name, String food_Description)throws SQLException{
        cs = con.prepareCall("{call EditFoodDescription(?,?)}");
        cs.setString(1,food_Name);
        cs.setString(2,food_Description);

        cs.execute();
    }

    public void display(){
        System.out.println(food_Name+"             "+food_Description+"   "+food_Price);
    }

}
