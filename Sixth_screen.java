import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Sixth_screen extends JFrame{
    JFrame window;
    JLabel jl;
    public Sixth_screen(){
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        jl = new JLabel("I am inside sixth screen"); 
        window.add(jl);
        window.setVisible(true);
        
    }
    public static void main(String[] args) {
        new Sixth_screen();
    }
}
