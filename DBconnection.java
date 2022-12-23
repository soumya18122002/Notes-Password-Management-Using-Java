import java.sql.*;
public class DBconnection{
    static Connection con = null;
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "YTXr@295";
            String url = "jdbc:mysql://localhost:3306/Signup";
            con = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
        
    }
}