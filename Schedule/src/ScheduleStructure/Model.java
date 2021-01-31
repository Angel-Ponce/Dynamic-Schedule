package ScheduleStructure;

import java.awt.Color;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angelponce
 */
public class Model {

    private Txt properties = new Txt("properties");
    private Txt courses = new Txt("courses");

    public void saveProperties(int rowCount, String theme, String font) {
        ArrayList<String> lines = new ArrayList();
        lines.add(String.valueOf(rowCount));
        lines.add(theme);
        lines.add(font);
        properties.setLines(lines);
    }

    public ArrayList<String> getProperties() {
        ArrayList<String> properties = new ArrayList();
        properties = this.properties.getLines();
        return properties;
    }

    public void saveCourses(ArrayList<Row> rows) {
        ArrayList<String> lines = new ArrayList();
        for (Row row : rows) {
            String rowString = row.hour.getHour() + "," + row.hour.getBackground().getRGB() + "," + row.hour.getColorChanged() + ";";
            for (Tile tile : row.days) {
                rowString += tile.getCourseName() + "," + tile.getUrl() + "," + tile.getBackground().getRGB() + "," + tile.getColorChanged() + ";";
            }
            lines.add(rowString);
        }
        courses.setLines(lines);
    }

    public ArrayList<Row> getRows() {
        ArrayList<Row> rows = new ArrayList();
        ArrayList<String> rowsString = this.courses.getLines();
        String[] tilesString = null;
        for (String row : rowsString) {
            ArrayList<Tile> tiles = new ArrayList();
            tilesString = row.split(";");
            String[] tileHour = tilesString[0].split(",");
            Tile hour = new Tile(Tile.HOUR, "", "", tileHour[0], new Color(Integer.parseInt(tileHour[1])), null);
            hour.setColorChanged(tileHour[2]);
            tiles.add(hour);
            for (int i = 1; i < tilesString.length; i++) {
                String[] dayTile = tilesString[i].split(",");
                Tile day = new Tile(Tile.COURSE, dayTile[0], dayTile[1], "", new Color(Integer.parseInt(dayTile[2])), null);
                day.setColorChanged(dayTile[3]);
                tiles.add(day);
            }

            Row newRow = new Row(tiles.get(0), tiles.get(1), tiles.get(2), tiles.get(3), tiles.get(4), tiles.get(5));
            rows.add(newRow);
        }
        return rows;
    }
}
