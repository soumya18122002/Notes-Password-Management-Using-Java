import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fourth_screen extends JFrame{
    JFrame window;
    JLabel win_background,notes_icon,pas_man_icon;
    JPanel notes,pas_man;
    public Fourth_screen(){
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        
        ImageIcon img = new ImageIcon("fourth_back.jpg");
        win_background = new JLabel("",img,JLabel.CENTER);
        win_background.setBounds(0, 0, 1200, 800);
        window.add(win_background);
        window.setLayout(null);

        notes = new JPanel();
        win_background.add(notes);
        notes.setLayout(null);
        notes.setBounds(100, 200, 400, 400);
        
        notes_icon = new JLabel(new ImageIcon("notes_logo.png"),JLabel.CENTER);
        notes_icon.setBounds(100, 70, 256, 256);
        notes.add(notes_icon);
        notes.setOpaque(false); // to make the notes icon transparent background
        notes_icon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if(x<=256||y<=256){
                    new Fifth_screen();
                    window.dispose();
                }
                
            }
        });
        
        pas_man = new JPanel();
        win_background.add(pas_man);
        pas_man.setLayout(null);
        pas_man.setBounds(600, 200, 400, 400);
        
        pas_man_icon = new JLabel(new ImageIcon("padlock.png"),JLabel.CENTER);
        pas_man_icon.setBounds(50, 70, 256, 256);
        pas_man.add(pas_man_icon);
        pas_man.setOpaque(false); // to make the notes icon transparent background
        pas_man_icon.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // System.out.println(x+" , "+y);
                if(x<=256||y<=256){
                    new Sixth_screen();
                    window.dispose();
                }
                
            }
        });

        window.setVisible(true);
    }
    public static void main(String[] args) {
        new Fourth_screen();
    }
}
