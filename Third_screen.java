import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Third_screen extends JFrame{
    // Third_screen ts = new Third_screen();
    JFrame window;
    JPanel jp;
    JLabel uncon,pncon,phcon,emcon,jl,un,psw,ph,em,signup,go_to_login,container;
    JTextField uname,phone,email;
    JPasswordField password;
    JLabel reg_back_pic;
    public Third_screen(){
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        
        ImageIcon img = new ImageIcon("reg.jpg");
        reg_back_pic = new JLabel("",img,JLabel.CENTER);
        reg_back_pic.setBounds(0, 0, 1200, 800);
        window.setLayout(null);
        window.add(reg_back_pic);
        
        jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(300,80,600,650);
        reg_back_pic.add(jp);
        jp.setOpaque(false); // making the jpanel invisible or transparent

        jl = new JLabel("Signup",JLabel.CENTER);
        jl.setBounds(100, -50, 400, 200);
        jp.add(jl);

        Font font = new Font("Seoge Script",Font.BOLD,90);
        jl.setFont(font);
        jl.setForeground(Color.GREEN);

        uncon = new JLabel(new ImageIcon("username_blue.png"),JLabel.CENTER);
        uncon.setBounds(0, 120, 64, 62);
        jp.add(uncon);
        
        Font font2 = new Font("Serif",Font.BOLD,30);
        un = new JLabel("Username :");
        un.setFont(font2);
        un.setBounds(70, 100, 200, 100);
        un.setForeground(Color.WHITE);
        jp.add(un);
        
        pncon = new JLabel(new ImageIcon("pass_blue.png"),JLabel.CENTER);
        pncon.setBounds(0, 220, 64, 62);
        jp.add(pncon);

        psw = new JLabel("Password :");
        psw.setFont(font2);
        psw.setBounds(70, 200, 200, 100);
        psw.setForeground(Color.WHITE);
        jp.add(psw);

        phcon = new JLabel(new ImageIcon("phone_green.png"),JLabel.CENTER);
        phcon.setBounds(0, 320, 64, 62);
        jp.add(phcon);

        ph = new JLabel("Phone :");
        ph.setFont(font2);
        ph.setBounds(70, 300, 200, 100);
        ph.setForeground(Color.WHITE);
        jp.add(ph);

        emcon = new JLabel(new ImageIcon("email_pink.png"),JLabel.CENTER);
        emcon.setBounds(0, 420, 64, 62);
        jp.add(emcon);

        em = new JLabel("Email :");
        em.setFont(font2);
        em.setBounds(70, 400, 200, 100);
        em.setForeground(Color.WHITE);
        jp.add(em);

        uname = new JTextField(200);
        uname.setBounds(230, 125, 300, 50);
        jp.add(uname);

        password = new JPasswordField(200);
        password.setBounds(230, 225, 300, 50);
        jp.add(password);

        phone = new JTextField(200);
        phone.setBounds(230, 325, 300, 50);
        jp.add(phone);

        email = new JTextField(200);
        email.setBounds(230, 425, 300, 50);
        jp.add(email);

        signup = new JLabel(new ImageIcon("button_signup.png"),JLabel.CENTER);
        signup.setBounds(200, 510, 140, 52);
        jp.add(signup);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if (x<=140||y<=52) {
                    JOptionPane.showMessageDialog(container,"Signup Completed Successfully");
                    // Insert_signup_to_db.insert_to_db(ts);
                }
            }
        });
        
        go_to_login = new JLabel(new ImageIcon("button_go_back_login.png"),JLabel.CENTER);
        go_to_login.setFont(new Font("Seoge Script",Font.BOLD,40));
        go_to_login.setBounds(150, 600, 241, 40);
        jp.add(go_to_login);
        go_to_login.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if(x<=241||y<=40){
                    new Second_screen();
                    window.dispose();
                }
            }
        });
        window.setVisible(true);
    }
    public static void main(String[] args) {
        Third_screen ts = new Third_screen();
        boolean ans = Insert_signup_to_db.insert_to_db(ts);
        if (ans) {
            System.out.println("Connection Added successfully");
        }
        else{
            System.out.println("Something went wrong");
        }
    }
}

// class user_signup_details{
    
//     private int serial_number;
//     private String username;
//     private String password;
//     private String phone;
//     private String email;
    
//     public user_signup_details(int serial_number, String username, String password, String phone, String email) {
//         super();
//         this.serial_number = serial_number;
//         this.username = username;
//         this.password = password;
//         this.phone = phone;
//         this.email = email;
//     }

//     public user_signup_details(String username, String password, String phone, String email) {
//         super();
//         this.username = username;
//         this.password = password;
//         this.phone = phone;
//         this.email = email;
//     }

//     public user_signup_details() {
//         super();
//     }

//     public int getSerial_number() {
//         return serial_number;
//     }

//     public void setSerial_number(int serial_number) {
//         this.serial_number = serial_number;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public void setPhone(String phone) {
//         this.phone = phone;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     @Override
//     public String toString() {
//         return "user_signup_details [serial_number=" + serial_number + ", username=" + username + ", password="
//                 + password + ", phone=" + phone + ", email=" + email + "]";
//     }
//     public static void main(String[] args) {
//         user_signup_details usd = new user_signup_details(null, null, null, null)
//     }
    
// }