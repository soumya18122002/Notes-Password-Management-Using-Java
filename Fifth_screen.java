import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class Fifth_screen extends JFrame {
    JFrame window;
    JTextArea jt;
    JScrollPane scp;
    JMenuBar jmb;
    JMenu file, edit, format, theme, fnt, fntsize;
    JMenuItem ne, ne_win, open, save, save_as, exit, wrap, arl;
    String filename, fileaddress;
    JLabel msg;
    boolean word_wrap_on = false;

    // JLabel jl;
    public Fifth_screen() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        window.setTitle("Notepad Application");
        // jl = new JLabel("I am inside fifth screen");
        // window.add(jl);
        jt = new JTextArea();

        scp = new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp.setBorder(BorderFactory.createEmptyBorder());
        window.add(scp);

        jmb = new JMenuBar();
        window.setJMenuBar(jmb);

        ImageIcon fic = new ImageIcon("button_file.png");
        file = new JMenu();
        file.setIcon(fic);
        jmb.add(file);

        ImageIcon edc = new ImageIcon("button_edit.png");
        edit = new JMenu();
        edit.setIcon(edc);
        jmb.add(edit);

        ImageIcon foc = new ImageIcon("button_format.png");
        format = new JMenu();
        format.setIcon(foc);
        jmb.add(format);

        ImageIcon thc = new ImageIcon("button_theme.png");
        theme = new JMenu();
        theme.setIcon(thc);
        jmb.add(theme);

        create_file_menu();
        create_format_menu();

        window.setVisible(true);

    }

    public void create_file_menu() {
        ImageIcon nei = new ImageIcon("button_new.png");
        ne = new JMenuItem("New");
        ne.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        ne.setIcon(nei);
        file.add(ne);
        ne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText("");
                window.setTitle("New");
                fileaddress = null;
                filename = null;
            }
        });

        ImageIcon newi = new ImageIcon("button_new_window.png");
        ne_win = new JMenuItem("New Window");
        ne_win.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        ne_win.setIcon(newi);
        file.add(ne_win);
        ne_win.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fifth_screen obj1 = new Fifth_screen();
            }
        });

        ImageIcon opi = new ImageIcon("button_open.png");
        open = new JMenuItem("Open");
        open.setIcon(opi);
        open.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        file.add(open);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(window, "Open", FileDialog.LOAD);
                fd.setVisible(true);
                if (fd.getFile() != null) {
                    filename = fd.getFile();
                    fileaddress = fd.getDirectory();
                    window.setTitle(filename);
                }
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
                    jt.setText("");
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        jt.append(line + "\n");
                    }
                    br.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(msg, "Error!! To open the File");
                }
            }
        });

        ImageIcon sai = new ImageIcon("button_save.png");
        save = new JMenuItem("Save");
        save.setIcon(sai);
        save.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        file.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filename == null) {
                    FileDialog fd = new FileDialog(window, "Save As", FileDialog.SAVE);
                    fd.setVisible(true);
                    if (fd.getFile() != null) {
                        filename = fd.getFile();
                        fileaddress = fd.getDirectory();
                        window.setTitle(filename);
                    }
                    try {
                        FileWriter fw = new FileWriter(fileaddress + filename);
                        fw.write(jt.getText());
                        fw.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(msg, "Error While Saving the File!!\nPlease Try Again");
                    }
                } else {
                    try {
                        FileWriter fw = new FileWriter(fileaddress + filename);
                        fw.write(jt.getText());
                        window.setTitle(filename);
                        fw.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(msg, "Error While Saving the File!!\nPlease Try Again");
                    }
                }
            }
        });

        ImageIcon savai = new ImageIcon("button_save_as.png");
        save_as = new JMenuItem("Save As");
        save_as.setIcon(savai);
        save_as.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        file.add(save_as);
        save_as.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(window, "Save As", FileDialog.SAVE);
                fd.setVisible(true);
                if (fd.getFile() != null) {
                    filename = fd.getFile();
                    fileaddress = fd.getDirectory();
                    window.setTitle(filename);
                }
                try {
                    FileWriter fw = new FileWriter(fileaddress + filename);
                    fw.write(jt.getText());
                    window.setTitle(filename);
                    fw.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(msg, "Error While Saving the File!!\nPlease Try Again");
                }
            }
        });

        ImageIcon ei = new ImageIcon("button_exit.png");
        exit = new JMenuItem("Exit");
        exit.setIcon(ei);
        exit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        file.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void create_format_menu() {
        wrap = new JMenuItem("Word Wrap: off");
        ImageIcon wri = new ImageIcon("button_word_wrap.png");
        wrap.setIcon(wri);
        wrap.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        format.add(wrap);
        wrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (word_wrap_on == false) {
                    word_wrap_on = true;
                    jt.setLineWrap(true);
                    jt.setWrapStyleWord(true);
                    wrap.setText("Word Wrap: on");
                } else if (word_wrap_on == true) {
                    word_wrap_on = false;
                    jt.setLineWrap(false);
                    jt.setWrapStyleWord(false);
                    wrap.setText("Word Wrap: off");
                }

            }
        });

        fnt = new JMenu("Font");
        ImageIcon fi = new ImageIcon("button_font.png");
        fnt.setIcon(fi);
        fnt.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        format.add(fnt);

        fntsize = new JMenu("Font Size");
        ImageIcon fsi= new ImageIcon("button_font_size.png");
        fntsize.setIcon(fsi);
        fntsize.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        format.add(fntsize);
    }

    public static void main(String[] args) {
        Fifth_screen obj = new Fifth_screen();
    }
}
