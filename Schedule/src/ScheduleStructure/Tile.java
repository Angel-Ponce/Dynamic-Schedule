package ScheduleStructure;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
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
    JPopupMenu popupMenuCourse;
    JMenuItem changeName;
    JSeparator separator1;
    JMenuItem changeLink;
    JSeparator separator2;
    JMenuItem changeBackground;
    JPopupMenu popupMenuHour;
    JMenuItem changeHour;
    JSeparator separator3;
    JMenuItem changeBackground2;

    public Tile(String type, String courseName, String url, String hour, Color background) {
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
        initComponents();
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
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
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
                            break;
                        case Tile.HOUR:
                            popupMenuHour.show(e.getComponent(), e.getX(), e.getY());
                            break;
                        default:
                            break;
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
