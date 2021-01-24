/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.awt.Color;

/**
 *
 * @author angelponce
 */
public class Theme {

    public static final String DARK = "dark";
    public static final String BLUE_GRAY = "blue_gray";
    public static final String GRAY = "gray";
    public static final String LIGHT = "light";
    public static final String PINK = "pink";
    public static final String PURPLE = "purple";
    public static final String LIGHT_BLUE = "light_blue";
    public static final String ORANGE = "orange";

    public Color hoursColor;
    public Color coursesColor;
    public Color daysColor;
    public Color containerColor;
    public Color menuBarColor;
    public Color fontColor;
    public Color fontColor2;

    public Theme(String theme) {
        switch (theme) {
            case LIGHT:
                hoursColor = Color.decode("#babdbe");
                daysColor = Color.decode("#babdbe");
                coursesColor = Color.decode("#ffffff");
                containerColor = Color.decode("#eceff1");
                menuBarColor = Color.decode("#eceff1");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
            case BLUE_GRAY:
                hoursColor = Color.decode("#000a12");
                daysColor = Color.decode("#000a12");
                coursesColor = Color.decode("#4f5b62");
                containerColor = Color.decode("#263238");
                menuBarColor = Color.decode("#263238");
                fontColor = Color.WHITE;
                fontColor2 = Color.WHITE;
                break;
            case GRAY:
                hoursColor = Color.decode("#494949");
                daysColor = Color.decode("#494949");
                coursesColor = Color.decode("#a4a4a4");
                containerColor = Color.decode("#757575");
                menuBarColor = Color.decode("#757575");
                fontColor = Color.BLACK;
                fontColor2 = Color.WHITE;
                break;
            case DARK:
                hoursColor = Color.decode("#000000");
                daysColor = Color.decode("#000000");
                coursesColor = Color.decode("#484848");
                containerColor = Color.decode("#212121");
                menuBarColor = Color.decode("#212121");
                fontColor = Color.WHITE;
                fontColor2 = Color.WHITE;
                break;
            case PINK:
                hoursColor = Color.decode("#c48b9f");
                daysColor = Color.decode("#c48b9f");
                coursesColor = Color.decode("#ffeeff");
                containerColor = Color.decode("#f8bbd0");
                menuBarColor = Color.decode("#f8bbd0");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
            case PURPLE:
                hoursColor = Color.decode("#af8eb5");
                daysColor = Color.decode("#af8eb5");
                coursesColor = Color.decode("#fff1ff");
                containerColor = Color.decode("#e1bee7");
                menuBarColor = Color.decode("#e1bee7");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
            case LIGHT_BLUE:
                hoursColor = Color.decode("#82b3c9");
                daysColor = Color.decode("#82b3c9");
                coursesColor = Color.decode("#e6ffff");
                containerColor = Color.decode("#b3e5fc");
                menuBarColor = Color.decode("#b3e5fc");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
            case ORANGE:
                hoursColor = Color.decode("#c88719");
                daysColor = Color.decode("#c88719");
                coursesColor = Color.decode("#ffe97d");
                containerColor = Color.decode("#ffb74d");
                menuBarColor = Color.decode("#ffb74d");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
            default:
                hoursColor = Color.decode("#babdbe");
                daysColor = Color.decode("#babdbe");
                coursesColor = Color.decode("#ffffff");
                containerColor = Color.decode("#eceff1");
                menuBarColor = Color.decode("#eceff1");
                fontColor = Color.BLACK;
                fontColor2 = Color.BLACK;
                break;
        }
    }
}
