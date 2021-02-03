/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

/**
 *
 * @author angelponce
 */
public class Properties {
    private String rowCount;
    private String theme;
    private String font;
    private String grid;

    public Properties(String rowCount, String theme, String font, String grid) {
        this.rowCount = rowCount;
        this.theme = theme;
        this.font = font;
        this.grid = grid;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }
    
}
