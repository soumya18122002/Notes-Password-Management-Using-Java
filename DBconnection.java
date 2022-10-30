import java.sql.*;
public class DBconnection{
    static Connection con;
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/Signup";
            con = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
        
    }
}