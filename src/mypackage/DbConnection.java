package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        String uname = "root";
        String pass = "";
        try {
            con = DriverManager.getConnection(url, uname, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
