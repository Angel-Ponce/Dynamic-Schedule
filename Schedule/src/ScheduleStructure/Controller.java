package ScheduleStructure;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angelponce
 */
public class Controller {

    View view;
    Model model;
    public static Theme theme = new Theme(Theme.LIGHT);
    private Txt properties = new Txt("properties");
    private Txt courses = new Txt("courses");
    private GridLayout hoursLayout;
    private GridLayout centerLayout;
    private CustomFont font;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        hoursLayout = (GridLayout) view.hoursPanel.getLayout();
        centerLayout = (GridLayout) view.centerPanel.getLayout();
        events();
    }

    public void init() {
        //Default code before
        ArrayList<String> props = model.getProperties();
        if (props.size() == 0) {
            model.saveProperties(0, Theme.LIGHT, CustomFont.VERDANA);
        }
        props = model.getProperties();
        theme = new Theme(props.get(1));
        font = new CustomFont(props.get(2));
        readCourses();
        chooseFont(font.customFont);
        chooseTheme();
        view.groupThemes.add(view.lightTheme);
        view.groupThemes.add(view.blueGrayTheme);
        view.groupThemes.add(view.grayTheme);
        view.groupThemes.add(view.pinkTheme);
        view.groupThemes.add(view.purpleTheme);
        view.groupThemes.add(view.darkTheme);
        view.groupThemes.add(view.lightBlueTheme);
        view.groupThemes.add(view.orangeTheme);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void events() {

        view.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                ArrayList<Row> rows = new ArrayList();
                int fin = 5;
                int in = 0;
                for (int i = 0; i < view.hoursPanel.getComponents().length; i++) {
                    Tile tileHour = (Tile) view.hoursPanel.getComponents()[i];
                    ArrayList<Tile> days = new ArrayList();
                    days.add(tileHour);
                    for (int j = in; j < fin; j++) {
                        Tile tileDay = (Tile) view.centerPanel.getComponents()[j];
                        days.add(tileDay);
                    }
                    Row row = new Row(days.get(0), days.get(1), days.get(2), days.get(3), days.get(4), days.get(5));
                    rows.add(row);
                    fin += 5;
                    in += 5;
                }
                model.saveCourses(rows);
                model.saveProperties(rows.size(), theme.theme, font.fontString);
                System.exit(0);
            }
        });

        view.exitOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Row> rows = new ArrayList();
                int fin = 5;
                int in = 0;
                for (int i = 0; i < view.hoursPanel.getComponents().length; i++) {
                    Tile tileHour = (Tile) view.hoursPanel.getComponents()[i];
                    ArrayList<Tile> days = new ArrayList();
                    days.add(tileHour);
                    for (int j = in; j < fin; j++) {
                        Tile tileDay = (Tile) view.centerPanel.getComponents()[j];
                        days.add(tileDay);
                    }
                    Row row = new Row(days.get(0), days.get(1), days.get(2), days.get(3), days.get(4), days.get(5));
                    rows.add(row);
                    fin += 5;
                    in += 5;
                }
                model.saveCourses(rows);
                model.saveProperties(rows.size(), theme.theme, font.fontString);
                System.exit(0);
            }
        });

        view.addRowOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                Row row = new Row(theme);
//                row.hour.setText(row.hour.getHour());
//                view.hoursPanel.add(row.hour, -1);
//                for (Tile day : row.days) {
//                    day.setText(day.getCourseName());
//                    view.centerPanel.add(day, -1);
//                }
//                hoursLayout.setRows(hoursLayout.getRows() + 1);
//                centerLayout.setRows(centerLayout.getRows() + 1);
//                view.hoursPanel.repaint();
//                view.centerPanel.repaint();
//                view.pack();
                JOptionPane.showMessageDialog(null, "Estamos trabajando en ello!", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        view.createSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(properties.getLines().get(0)) == 0) {
                    String res = JOptionPane.showInputDialog(null, "¿Cuántas filas tendrá su horario?", "Configuarción", JOptionPane.INFORMATION_MESSAGE);
                    if (res != null) {
                        while (!res.matches("^\\d+$")) {
                            res = JOptionPane.showInputDialog(null, "¿Cuántas filas tendrá su horario?", "Configuarción", JOptionPane.INFORMATION_MESSAGE);
                            if (res == null) {
                                break;
                            }
                        }
                        if (res != null) {
                            int rows = Integer.parseInt(res);
                            hoursLayout.setRows(rows);
                            centerLayout.setRows(rows);

                            for (int i = 0; i < rows; i++) {
                                Row row = new Row(theme);
                                row.hour.setText(row.hour.getHour());
                                view.hoursPanel.add(row.hour, -1);
                                for (Tile day : row.days) {
                                    day.setText(day.getCourseName());
                                    view.centerPanel.add(day, -1);
                                }
                                view.hoursPanel.repaint();
                                view.centerPanel.repaint();
                                view.pack();
                            }
                        }
                    }
                    chooseTheme();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede crear un horario nuevo porque actualmente ya existe uno.\nPara crear uno nuevo reinicie el horario porfavor", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.reestartOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro de eliminar el horario actual?", "Atención", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    view.hoursPanel.removeAll();
                    view.centerPanel.removeAll();
                    view.hoursPanel.repaint();
                    view.centerPanel.repaint();
                    model.saveProperties(0, theme.theme, font.fontString);
                    courses.clear();
                    view.pack();
                }
            }
        });

        view.lightTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.LIGHT);
                chooseTheme();
            }
        });

        view.lightBlueTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.LIGHT_BLUE);
                chooseTheme();
            }
        });

        view.blueGrayTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.BLUE_GRAY);
                chooseTheme();
            }
        });

        view.grayTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.GRAY);
                chooseTheme();
            }
        });

        view.orangeTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.ORANGE);
                chooseTheme();
            }
        });

        view.pinkTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.PINK);
                chooseTheme();
            }
        });

        view.purpleTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.PURPLE);
                chooseTheme();
            }
        });

        view.darkTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theme = new Theme(Theme.DARK);
                chooseTheme();
            }
        });

        view.timesNewRomanFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.TIMESNEWROMAN);
                chooseFont(font.customFont);
            }
        });
        
        view.blackHighlightFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.BLACKHIGHLIGHT);
                chooseFont(font.customFont);
            }
        });
        
        view.verdanaFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.VERDANA);
                chooseFont(font.customFont);
            }
        });
        
        view.lettersFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.LETTERS);
                chooseFont(font.customFont);
            }
        });
        
        view.josephSophiaFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.JOSEPHSOPHIA);
                chooseFont(font.customFont);
            }
        });
    }

    private void chooseTheme() {
        view.crossPanel.setBackground(theme.containerColor);
        view.container.setBackground(theme.containerColor);
        view.daysPanel.setBackground(theme.daysColor);
        view.hoursPanel.setBackground(theme.containerColor);
        view.centerPanel.setBackground(theme.containerColor);

        view.hourLabel.setForeground(theme.fontColor2);
        view.mondayLabel.setForeground(theme.fontColor2);
        view.tuesdayLabel.setForeground(theme.fontColor2);
        view.wednesdayLabel.setForeground(theme.fontColor2);
        view.thursdayLabel.setForeground(theme.fontColor2);
        view.fridayLabel.setForeground(theme.fontColor2);

        for (int i = 0; i < view.hoursPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.hoursPanel.getComponents()[i];
            tile.setForeground(theme.fontColor2);
            tile.setTheme(theme);
            if ("f".equals(tile.getColorChanged())) {
                tile.setBackground(theme.hoursColor);
            }
        }

        for (int i = 0; i < view.centerPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.centerPanel.getComponents()[i];
            tile.setForeground(theme.fontColor);
            tile.setTheme(theme);
            if ("f".equals(tile.getColorChanged())) {
                tile.setBackground(theme.coursesColor);
            }
        }

        view.hoursPanel.repaint();
        view.centerPanel.repaint();
        view.pack();
    }

    private void chooseFont(Font font) {
        view.setFont(font);
        view.hourLabel.setFont(font);
        view.mondayLabel.setFont(font);
        view.tuesdayLabel.setFont(font);
        view.wednesdayLabel.setFont(font);
        view.thursdayLabel.setFont(font);
        view.fridayLabel.setFont(font);

        for (int i = 0; i < view.hoursPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.hoursPanel.getComponents()[i];
            tile.setFont(font);
        }

        for (int i = 0; i < view.centerPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.centerPanel.getComponents()[i];
            tile.setFont(font);
        }

        view.hoursPanel.repaint();
        view.centerPanel.repaint();
        view.pack();
    }

    private void readCourses() {
        ArrayList<Row> rows = model.getRows();
        ArrayList<String> props = model.getProperties();
        int rowCount = Integer.parseInt(props.get(0));
        hoursLayout.setRows(rowCount);
        centerLayout.setRows(rowCount);

        for (Row row : rows) {
            row.hour.setText(row.hour.getHour());
            view.hoursPanel.add(row.hour, -1);
            for (Tile day : row.days) {
                day.setText(day.getCourseName());
                view.centerPanel.add(day, -1);
            }
            view.hoursPanel.repaint();
            view.centerPanel.repaint();
            view.pack();
        }
    }

}
