package ScheduleStructure;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

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

    public Tile(String type, String courseName, String url, String hour, Color background) {
        this.type = type;
        this.courseName = courseName;
        this.url = url;
        this.hour = hour;
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setBackground(background);
        this.setVisible(true);
        events();
    }

    private void events() {
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    System.out.println("Menu despegable");
                }
            }
        });
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
