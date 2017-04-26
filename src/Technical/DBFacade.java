package Technical;

import java.sql.*;

public class DBFacade {
    private String userName = "sa";
    private String password = "123456";
    private String port = "1433";
    private String databaseName = "Hotel";
    private Connection con;
    private PreparedStatement ps;
    private CallableStatement cl;

    public DBFacade() {
        openConnection();
    }

    /**
     * Open connection to the database
     */
    private void openConnection()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName,userName,password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement createStatement(String sql) throws SQLException {
        ps = con.prepareStatement(sql);
        return ps;
    }

    public CallableStatement createCallable(String sql) throws SQLException {
        cl = con.prepareCall(sql);
        return cl;
    }

    private void closeConnection() {
        try {
            ps.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}