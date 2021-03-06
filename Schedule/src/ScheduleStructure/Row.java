/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.util.ArrayList;

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

    public Row(Theme th) {
        hour = new Tile(Tile.HOUR, "", "", "Hora", th.hoursColor, th);
        monday = new Tile(Tile.COURSE, "Curso", "url", "", th.coursesColor, th);
        tuesday = new Tile(Tile.COURSE, "Curso", "url", "", th.coursesColor, th);
        wednesday = new Tile(Tile.COURSE, "Curso", "url", "", th.coursesColor, th);
        thursday = new Tile(Tile.COURSE, "Curso", "url", "", th.coursesColor, th);
        friday = new Tile(Tile.COURSE, "Curso", "url", "", th.coursesColor, th);
        days.add(monday);
        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);
    }

    public Row(Tile hour, Tile monday, Tile tuesday, Tile wednesday, Tile thursday, Tile friday) {
        this.hour = hour;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        days.add(monday);
        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);
    }
}
