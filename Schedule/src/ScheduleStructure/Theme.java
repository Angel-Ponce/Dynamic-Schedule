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
public class Theme{
    public static final String DARK = "dark";
    public static final String BLUE_GRAY = "blue_gray";
    public static final String GRAY = "gray";
    public static final String LIGHT = "light";
    public static final String PINK = "pink";
    public static final String PURPLE = "purple";
    
    public Color hoursColor;
    public Color coursesColor;
    public Color daysColor;
    public Color containerColor;
    public Color menuBarColor;
    public Color fontColor;
    
    public Theme(String theme){
        switch(theme){
            case LIGHT:
                break;
        }
    }
}
