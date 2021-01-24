/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.util.ArrayList;
import javax.swing.JPopupMenu;

/**
 *
 * @author angelponce
 */
public class Row {

    Tile hour;
    Tile monday;
    Tile tuesday;
    Tile wednesday;
    Tile thursday;
    Tile friday;

    ArrayList<Tile> days = new ArrayList();

    public Row(Theme th, JPopupMenu menuCourse, JPopupMenu menuHour) {
        hour = new Tile(Tile.HOUR, null, null, "Hora", th.hoursColor, menuCourse, menuHour);
        monday = new Tile(Tile.COURSE, "Curso", "url", null, th.coursesColor, menuCourse, menuHour);
        tuesday = new Tile(Tile.COURSE, "Curso", "url", null, th.coursesColor, menuCourse, menuHour);
        wednesday = new Tile(Tile.COURSE, "Curso", "url", null, th.coursesColor, menuCourse, menuHour);
        thursday = new Tile(Tile.COURSE, "Curso", "url", null, th.coursesColor, menuCourse, menuHour);
        friday = new Tile(Tile.COURSE, "Curso", "url", null, th.coursesColor, menuCourse, menuHour);
        days.add(monday);
        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);
    }
}
