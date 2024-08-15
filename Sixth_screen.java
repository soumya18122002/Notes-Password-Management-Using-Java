import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class Sixth_screen extends JFrame {
    JFrame window;
    JLabel background;
    // JTable jt;
    JPanel jp;

    public Sixth_screen() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);

        ImageIcon img = new ImageIcon("password_background.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        window.add(background);

        jp = new JPanel();
        // jp.setLayout(null);
        jp.setBounds(150, 100, 900, 500);
        background.add(jp);
        

        jp.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));
        String[][] rec = {
                { "1", "Steve", "AUS" },
                { "2", "Virat", "IND" },
                { "3", "Kane", "NZ" },
                { "4", "David", "AUS" },
                { "5", "Ben", "ENG" },
                { "6", "Eion", "ENG" },
        };
        String[] header = { "Rank", "Player", "Country" };
        JTable jt = new JTable(rec, header);
        jp.add(new JScrollPane(jt));

        // Object[][] data = {{"Gmail","soumyadeepdwn@gmail.com",12321}};
        // String[] column_names = {"Sites","Username","Password"};
        // DefaultTableModel model = new DefaultTableModel(data,column_names);
        // jt = new JTable(model);
        // jp.add(new JScrollPane(jt));

        window.setVisible(true);

    }

    public static void main(String[] args) {
        new Sixth_screen();
    }
}
