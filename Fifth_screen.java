import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Fifth_screen extends JFrame{
    JFrame window;
    JLabel jl;
    public Fifth_screen(){
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        jl = new JLabel("I am inside fifth screen");
        window.add(jl);
        window.setVisible(true);

    }
    public static void main(String[] args) {
        new Fifth_screen();
    }
}
