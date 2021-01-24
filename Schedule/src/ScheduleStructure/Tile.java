package ScheduleStructure;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angelponce
 */
public class Tile extends JLabel {

    public static final String HOUR = "h";
    public static final String COURSE = "c";
    private String type;
    private String courseName;
    private String url;
    private String hour;
    private JPopupMenu popupMenuCourse;
    private JMenuItem changeName;
    private JSeparator separator1;
    private JMenuItem changeLink;
    private JSeparator separator2;
    private JMenuItem changeBackground;
    private JPopupMenu popupMenuHour;
    private JMenuItem changeHour;
    private JSeparator separator3;
    private JMenuItem changeBackground2;
    private Component componentClicked = null;

    public Tile(String type, String courseName, String url, String hour, Color background) {
        initComponents();
        this.type = type;
        this.courseName = courseName;
        this.url = url;
        this.hour = hour;
        this.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setBackground(background);
        this.setVisible(true);
        events();
    }

    private void events() {
        JLabel label = this;
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                if (e.isPopupTrigger()) {
                    switch (type) {
                        case Tile.COURSE:
                            popupMenuCourse.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            break;
                        default:
                            break;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    switch (type) {
                        case Tile.COURSE:
                            popupMenuCourse.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
                            componentClicked = e.getComponent();
                            break;
                        default:
                            break;
                    }
                }
                if (e.getClickCount() == 2) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException ex) {
                    } catch (URISyntaxException ex) {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar abrir el enlace de reunión, intenta verificar la información", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setBorder(null);
            }
        });

        changeName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre", "Cambio de nombre", JOptionPane.INFORMATION_MESSAGE);
                if (name.trim().length() > 0) {
                    JLabel label = (JLabel) componentClicked;
                    label.setText(name.trim());
                    courseName = name;
                }
            }
        });

        changeLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String link = JOptionPane.showInputDialog(null, "Ingrese el nuevo enlace", "Cambio de enlace", JOptionPane.INFORMATION_MESSAGE);
                if (link.trim().length() > 0) {
                    url = link;
                    JOptionPane.showMessageDialog(null, "Se guardo el enlace correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        changeHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newHour = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre", "Cambio de nombre", JOptionPane.INFORMATION_MESSAGE);
                if (newHour.trim().length() > 0) {
                    JLabel label = (JLabel) componentClicked;
                    label.setText(newHour.trim());
                    hour = newHour;
                }
            }
        });

        changeBackground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "Escoga un color", Color.WHITE);
                if (background != null) {
                    JLabel label = (JLabel) componentClicked;
                    label.setBackground(background);
                }
            }
        });

        changeBackground2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color background = JColorChooser.showDialog(null, "Escoga un color", Color.WHITE);
                if (background != null) {
                    JLabel label = (JLabel) componentClicked;
                    label.setBackground(background);
                }
            }
        });
    }

    private void initComponents() {
        popupMenuCourse = new JPopupMenu();
        changeName = new JMenuItem();
        separator1 = new JSeparator();
        changeLink = new JMenuItem();
        separator2 = new JSeparator();
        changeBackground = new JMenuItem();
        popupMenuHour = new JPopupMenu();
        changeHour = new JMenuItem();
        separator3 = new JSeparator();
        changeBackground2 = new JMenuItem();
        changeName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        changeName.setText("Cambiar nombre");
        popupMenuCourse.add(changeName);
        popupMenuCourse.add(separator1);

        changeLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png")));
        changeLink.setText("Cambiar enlace");

        popupMenuCourse.add(changeLink);
        popupMenuCourse.add(separator2);

        changeBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/color.png")));
        changeBackground.setText("Cambiar color");
        popupMenuCourse.add(changeBackground);

        changeHour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png")));
        changeHour.setText("Cambiar hora");
        changeHour.setToolTipText("");
        popupMenuHour.add(changeHour);
        popupMenuHour.add(separator3);

        changeBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/color.png")));
        changeBackground2.setText("Cambiar color");
        popupMenuHour.add(changeBackground2);

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

}
