import java.sql.*;

public class ConnectionProvider {
    private static Connection con;
    public static Connection getConnection(){
        try{
            if(con == null){
                //1. load and register the driver
                //name of mysql driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                //2. Establish the connection with database
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
