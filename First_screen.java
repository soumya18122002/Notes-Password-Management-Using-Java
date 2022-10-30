import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class First_screen extends JFrame {
    JFrame window;
    JLabel background;
    JLabel jb;
    public First_screen() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200,800);
        window.setLayout(null);
        
        ImageIcon img = new ImageIcon("first_pic.jpeg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,800);
        window.add(background);

        jb = new JLabel(new ImageIcon("next.png"));
        jb.setBounds(550, 600, 85, 85);
        background.add(jb);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if (x<=85||y<=85) {
                    new Second_screen();
                    window.dispose();
                }
            }
        });
        window.setVisible(true);
        // jb.addActionListener(this);
    }
    
    public static void main(String[] args) {
        new First_screen();
    }
}
