package ScheduleStructure;

import com.google.gson.Gson;
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

    private Json properties = new Json("properties");
    private Json courses = new Json("courses");
    private Gson gson = new Gson();

    public Model() {
        if (properties.getJsons().isEmpty()) {
            ArrayList<String> objects = new ArrayList();
            Properties props = new Properties("0", Theme.LIGHT, CustomFont.VERDANA, Controller.NO_SEE_GRID);
            objects.add(gson.toJson(props));
            properties.saveJsons(objects);
        }
        Properties props = (Properties) gson.fromJson(this.properties.getJsons().get(0), Properties.class);
        if (props.getGrid() == null) {
            ArrayList<String> objects = new ArrayList();
            props.setGrid(Controller.NO_SEE_GRID);
            objects.add(gson.toJson(props));
            properties.saveJsons(objects);
        }
    }

    public void saveProperties(int rowCount, String theme, String font, String margins) {
        Properties props = new Properties(String.valueOf(rowCount), theme, font, margins);
        ArrayList<String> objects = new ArrayList();
        objects.add(gson.toJson(props));
        properties.saveJsons(objects);
    }

    public ArrayList<String> getProperties() {
        ArrayList<String> properties = new ArrayList();
        Properties props = (Properties) gson.fromJson(this.properties.getJsons().get(0), Properties.class);
        properties.add(props.getRowCount());
        properties.add(props.getTheme());
        properties.add(props.getFont());
        properties.add(props.getGrid());
        return properties;
    }

    public void saveCourses(ArrayList<Row> rows) {
        ArrayList<String> rowsJson = new ArrayList();
        for (Row row : rows) {
            GroupCell rowJson = new GroupCell();
            Cell cellHour = new Cell(row.hour.getHour(), "", "", String.valueOf(row.hour.getBackground().getRGB()), row.hour.getColorChanged());
            rowJson.setCellHour(gson.toJson(cellHour, Cell.class));
            for (Tile day : row.days) {
                Cell cellDay = new Cell("", day.getCourseName(), day.getUrl(), String.valueOf(day.getBackground().getRGB()), day.getColorChanged());
                rowJson.cellDays.add(gson.toJson(cellDay, Cell.class));
            }
            rowsJson.add(gson.toJson(rowJson, GroupCell.class));
        }
        courses.saveJsons(rowsJson);
    }

    public ArrayList<Row> getRows() {
        ArrayList<Row> rows = new ArrayList();
        ArrayList<String> rowsString = courses.getJsons();
        for (String row : rowsString) {
            ArrayList<Tile> tiles = new ArrayList();
            GroupCell groupCell = (GroupCell) gson.fromJson(row, GroupCell.class);
            Cell cellHour = gson.fromJson(groupCell.getCellHour(), Cell.class);
            Tile hourTile = new Tile(Tile.HOUR, "", "", cellHour.getHour(), new Color(Integer.parseInt(cellHour.getColor())), null);
            hourTile.setColorChanged(cellHour.getColorChanged());
            tiles.add(hourTile);
            for (String day : groupCell.getCellDays()) {
                Cell cellDay = gson.fromJson(day, Cell.class);
                Tile dayTile = new Tile(Tile.COURSE, cellDay.getCourseName(), cellDay.getUrl(), "", new Color(Integer.parseInt(cellDay.getColor())), null);
                dayTile.setColorChanged(cellDay.getColorChanged());
                tiles.add(dayTile);
            }
            rows.add(new Row(tiles.get(0), tiles.get(1), tiles.get(2), tiles.get(3), tiles.get(4), tiles.get(5)));
        }
        return rows;
    }

    //<editor-fold defaultstate="collapsed" desc="Class GroupCell">
    class GroupCell {

        private String cellHour;
        private ArrayList<String> cellDays = new ArrayList();

        public GroupCell() {

        }

        public GroupCell(String cellHour) {
            this.cellHour = cellHour;
        }

        public ArrayList<String> getCellDays() {
            return cellDays;
        }

        public void setCellDays(ArrayList<String> cellDays) {
            this.cellDays = cellDays;
        }

        public String getCellHour() {
            return cellHour;
        }

        public void setCellHour(String cellHour) {
            this.cellHour = cellHour;
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Class Cell">
    class Cell {

        private String hour;
        private String courseName;
        private String url;
        private String color;
        private String colorChanged;

        public Cell(String hour, String courseName, String url, String color, String colorChanged) {
            this.hour = hour;
            this.courseName = courseName;
            this.url = url;
            this.color = color;
            this.colorChanged = colorChanged;
        }

        public String getColorChanged() {
            return colorChanged;
        }

        public void setColorChanged(String colorChanged) {
            this.colorChanged = colorChanged;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
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

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }
//</editor-fold>

}
