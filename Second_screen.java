import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Second_screen extends JFrame {
    JFrame window;
    JLabel ucon, pcon, jl, un, psw, dont_have_ac, login,container;
    JTextField uname;
    JPasswordField password;
    JLabel background_pic;
    JPanel jp;

    public Second_screen() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);

        ImageIcon image = new ImageIcon("login.jpg");
        background_pic = new JLabel("", image, JLabel.CENTER);
        background_pic.setBounds(0, 0, 1200, 800);
        window.add(background_pic);
        window.setLayout(null);

        jp = new JPanel();
        background_pic.add(jp);
        jp.setLayout(null);
        jp.setBounds(300, 100, 700, 600);
        jp.setOpaque(false); // making the jpanel invisible or transparent

        jl = new JLabel("Login", JLabel.CENTER);
        Font font = new Font("Seoge Script", Font.BOLD, 90);
        jl.setFont(font);
        jl.setForeground(Color.CYAN);
        jl.setBounds(150, -50, 300, 300);
        jp.add(jl);

        ucon = new JLabel(new ImageIcon("username_yellow.png"), JLabel.CENTER);
        ucon.setBounds(0, 220, 64, 62);
        jp.add(ucon);

        un = new JLabel("Username :");
        un.setForeground(Color.MAGENTA);
        un.setBounds(70, 200, 200, 100);
        un.setFont(new Font("Serif", Font.BOLD, 35));
        jp.add(un);

        pcon = new JLabel(new ImageIcon("password_blue.png"), JLabel.CENTER);
        pcon.setBounds(0, 320, 64, 62);
        jp.add(pcon);

        psw = new JLabel("Password :");
        psw.setForeground(Color.MAGENTA);
        psw.setFont(new Font("Serif", Font.BOLD, 35));
        psw.setBounds(70, 300, 200, 100);
        jp.add(psw);

        uname = new JTextField(200);
        uname.setBounds(250, 225, 300, 50);
        jp.add(uname);

        password = new JPasswordField();
        password.setBounds(250, 325, 300, 50);
        jp.add(password);

        login = new JLabel(new ImageIcon("button_login.png"), JLabel.CENTER);
        login.setBounds(200, 425, 141, 54);
        jp.add(login);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if (x <= 141 || y <= 54) {
                    boolean s = false;
                    try {
                        Connection conne = DBconnection.createConnection();
                        String q = "Select * from Users where Username = ? AND Passwords = ?";
                        PreparedStatement pstm = conne.prepareStatement(q);
                        String un = uname.getText().toString();
                        String pswd = password.getText().toString();
                        pstm.setString(1, un);
                        pstm.setString(2, pswd);
                        ResultSet rs = pstm.executeQuery();
                        if (rs.next()) {
                            s = true;
                        } else {
                            s = false;
                        }
                    } catch (Exception ex) {
                        // TODO: handle exception
                    }
                    if (s) {
                    JOptionPane.showMessageDialog(container, "LogIn Completed Successfully");

                        new Fourth_screen();
                        window.dispose();
                    }else{
                    JOptionPane.showMessageDialog(container, "Error!! Please Check Username Password Again");
                        
                    }
                }
            }
        });

        dont_have_ac = new JLabel(new ImageIcon("button_d_h_a_ac.png"), JLabel.CENTER);
        dont_have_ac.setBounds(50, 525, 426, 40);
        dont_have_ac.setFont(new Font("Sans Serif", Font.BOLD, 20));
        dont_have_ac.setForeground(Color.BLUE);
        jp.add(dont_have_ac);
        dont_have_ac.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if (x <= 426 || y <= 40) {
                    new Third_screen();
                    window.dispose();
                }
            }
        });

        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Second_screen();
    }
}
