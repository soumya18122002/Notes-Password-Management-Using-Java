// import java.sql.*;

// public class Insert_signup_to_db {
//     public static boolean insert_to_db(Third_screen ts) {
//         boolean f = false;
//         String un="sou_name",pas="sou_pas",ph="sou_num",eml="sou@gmail.com";
//         try {
//             Connection conn = DBconnection.createConnection();
//             String q = "insert into Users(Username,Passwords,Phone,Email) values(?,?,?,?)";
//             PreparedStatement pdst = conn.prepareStatement(q);
//             un = ts.uname.getText().toString();
//             pas = ts.password.getPassword().toString();
//             ph = ts.phone.getText().toString();
//             eml = ts.email.getText().toString();
//             // String un = "Soumya";
//             // String pas = "Soumya";
//             // String ph = "Soumya";
//             // String eml = "Soumya";
            
//             pdst.setString(1, un);
//             pdst.setString(2, pas);
//             pdst.setString(3, ph);
//             pdst.setString(4, eml);
//             pdst.executeUpdate();
//             f = true;
            
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
        
//         System.out.println(un+pas+ph+eml);
//         System.out.println(f);
//         return f;
//     }
//     public static void main(String[] args) {
//         Insert_signup_to_db obj = new Insert_signup_to_db();
//     }
// }
