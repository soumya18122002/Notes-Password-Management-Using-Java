import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Fifth_screen extends JFrame {
    JFrame window;
    JTextArea jt;
    JScrollPane scp;
    JMenuBar jmb;
    JMenu file, edit, format, theme, fnt, fntsize;
    JMenuItem ne, ne_win, open, save, save_as, exit, wrap;
    JMenuItem arl, csmc, tnr;
    JMenuItem f8, f12, f16, f20, f24, f28, f36, f48, f72, f96;
    JMenuItem thm1, thm2, thm3, thm4;
    JMenuItem undo, redo;
    String filename, fileaddress, font_name;
    JLabel msg;
    boolean word_wrap_on = false;
    Font arial, comicsansms, timesnewroman, font_details, font_dt;
    UndoManager um = new UndoManager();

    // JLabel jl;
    public Fifth_screen() {
        window = new JFrame();
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setSize(1200, 800);
        window.setTitle("Notepad Application");
        // jl = new JLabel("I am inside fifth screen");
        // window.add(jl);
        jt = new JTextArea();
        jt.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
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

        create_file_menu(); // function calling
        create_format_menu(); // function calling
        create_theme_menu(); // function calling
        create_edit_menu(); // function calling
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
        arl = new JMenuItem("Arial");
        arl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fnt.add(arl);

        arl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_details = jt.getFont(); // parsing the who font details of the jtextarea jt
                int a = font_details.getSize(); // pasing the font size of the textfield
                arial = new Font("Arial", Font.PLAIN, a);
                jt.setFont(arial);
            }
        });
        csmc = new JMenuItem("Cosmic Sans Ms");
        csmc.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fnt.add(csmc);
        csmc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_details = jt.getFont(); // parsing the who font details of the jtextarea jt
                int a = font_details.getSize(); // pasing the font size of the textfield
                comicsansms = new Font("Comic Sans Ms", Font.PLAIN, a);
                jt.setFont(comicsansms);
            }
        });
        tnr = new JMenuItem("Times New Roman");
        tnr.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fnt.add(tnr);
        tnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_details = jt.getFont(); // parsing the who font details of the jtextarea jt
                int a = font_details.getSize(); // pasing the font size of the textfield
                timesnewroman = new Font("Times New Roman", Font.PLAIN, a);
                jt.setFont(timesnewroman);
            }
        });

        fntsize = new JMenu("Font Size");
        ImageIcon fsi = new ImageIcon("button_font_size.png");
        fntsize.setIcon(fsi);
        fntsize.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        format.add(fntsize);
        f8 = new JMenuItem("8");
        f8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f8);
        f8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 8));
            }
        });
        f12 = new JMenuItem("12");
        f12.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f12);
        f12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 12));
            }
        });
        f16 = new JMenuItem("16");
        f16.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f16);
        f16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 16));
            }
        });
        f20 = new JMenuItem("20");
        f20.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f20);
        f20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 20));
            }
        });
        f24 = new JMenuItem("24");
        f24.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f24);
        f24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 24));
            }
        });
        f28 = new JMenuItem("28");
        f28.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f28);
        f28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 28));
            }
        });
        f36 = new JMenuItem("36");
        f36.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f36);
        f36.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 36));
            }
        });
        f48 = new JMenuItem("48");
        f48.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f48);
        f48.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 48));
            }
        });
        f72 = new JMenuItem("72");
        f72.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f72);
        f72.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 72));
            }
        });
        f96 = new JMenuItem("96");
        f96.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        fntsize.add(f96);
        f96.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font_dt = jt.getFont();
                jt.setFont(new Font(font_dt.getName(), font_dt.getStyle(), 96));
            }
        });

    }

    public void create_theme_menu() {
        thm1 = new JMenuItem("White");
        thm1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        theme.add(thm1);
        thm1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().setBackground(Color.white);
                jt.setBackground(Color.white);
                jt.setForeground(Color.black);
                jmb.setBackground(Color.white); // makes the background of the menubar of the above white
            }
        });
        thm2 = new JMenuItem("Black");
        thm2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        theme.add(thm2);
        thm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().setBackground(Color.black);
                jt.setBackground(Color.black);
                jt.setForeground(Color.white);
                jmb.setBackground(Color.black); // makes the background of the menubar of the above black
            }
        });
        thm3 = new JMenuItem("Dark Gray");
        thm3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        theme.add(thm3);
        thm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().setBackground(Color.darkGray);
                jt.setBackground(Color.darkGray);
                jt.setForeground(Color.white);
                jmb.setBackground(Color.darkGray); // makes the background of the menubar of the above gray
            }
        });
        thm4 = new JMenuItem("Golden Brown");
        thm4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        theme.add(thm4);
        thm4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = new Color(186, 178, 8);
                window.getContentPane().setBackground(c);
                jt.setBackground(c);
                jt.setForeground(Color.black);
                jmb.setBackground(c);
            }
        });

    }

    public void create_edit_menu() {
        undo = new JMenuItem("Undo");
        undo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        ImageIcon un = new ImageIcon("button_undo.png");
        undo.setIcon(un);
        edit.add(undo);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                um.undo();
            }
        });
        redo = new JMenuItem("Redo");
        redo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        ImageIcon re = new ImageIcon("button_redo.png");
        redo.setIcon(re);
        edit.add(redo);
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                um.redo();
            }
        });
    }

    public static void main(String[] args) {
        Fifth_screen obj = new Fifth_screen();
    }
}
