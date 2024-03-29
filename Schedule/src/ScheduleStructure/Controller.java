package ScheduleStructure;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

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
    public static final String SEE_GRID = "YesM";
    public static final String NO_SEE_GRID = "NoM";
    public static Theme theme = new Theme(Theme.LIGHT);
    private final Json courses = new Json("courses");
    private final GridLayout hoursLayout;
    private final GridLayout centerLayout;
    private CustomFont font;
    private String seeGrid = "NoM";
    public static boolean gridSelected = false;
    public static boolean accept = false;
    public static Color colorCourse = theme.coursesColor;

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
        theme = new Theme(props.get(1));
        font = new CustomFont(props.get(2));
        seeGrid = props.get(3);
        view.popupCharge.setLocationRelativeTo(null);
        view.popupQuestion.setLocationRelativeTo(null);
        view.popupAddCourse.setLocationRelativeTo(null);
        selectRadioButtons(theme.theme, font.fontString, seeGrid);
        readCourses();
        chooseFont(font.customFont, font.customFontBold);
        chooseTheme();
        listenerOnCells();
        if (props.get(4).equals("true")) {
            System.out.println("true");
            Process process = new Process(view.popupCharge, view.progressBar);
            process.run();
            view.lazyLoadOption.setSelected(true);
        } else {
            view.lazyLoadOption.setSelected(false);
        }
        view.setIconImage(new ImageIcon(getClass().getResource("/Images/calendar.png")).getImage());
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
                model.saveProperties(rows.size(), theme.theme, font.fontString, seeGrid, view.lazyLoadOption.isSelected());
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
                model.saveProperties(rows.size(), theme.theme, font.fontString, seeGrid, view.lazyLoadOption.isSelected());
                System.exit(0);
            }
        });

        view.addRowOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Row row = new Row(theme);
                row.hour.setText(row.hour.getHour());
                addListenerOnTile(row.hour);
                if (gridSelected) {
                    row.hour.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                }
                view.hoursPanel.add(row.hour, -1);
                for (Tile day : row.days) {
                    day.setText(day.getCourseName());
                    addListenerOnTile(day);
                    if (gridSelected) {
                        day.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                    }
                    view.centerPanel.add(day, -1);
                }
                hoursLayout.setRows(hoursLayout.getRows() + 1);
                centerLayout.setRows(centerLayout.getRows() + 1);
                view.hoursPanel.repaint();
                view.centerPanel.repaint();
                view.pack();
                chooseTheme();
                chooseFont(font.customFont, font.customFontBold);
                model.saveProperties(hoursLayout.getRows(), theme.theme, font.fontString, seeGrid, view.lazyLoadOption.isSelected());
            }
        });

        view.deleteRowOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (view.hoursPanel.getComponentCount() != 0) {
                    view.hoursPanel.remove(view.hoursPanel.getComponentCount() - 1);
                    hoursLayout.setRows(hoursLayout.getRows() - 1);
                    int limit = view.centerPanel.getComponentCount() - 6;
                    for (int i = view.centerPanel.getComponentCount() - 1; i > limit; i--) {
                        System.out.println(i);
                        view.centerPanel.remove(i);
                    }
                    centerLayout.setRows(centerLayout.getRows() - 1);
                    view.hoursPanel.repaint();
                    view.centerPanel.repaint();
                    view.pack();
                }
            }
        });

        view.createSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.hoursPanel.getComponents().length == 0) {
                    accept = false;
                    view.responseQuestion.setText("");
                    view.popupQuestion.setVisible(true);
                    String res = view.responseQuestion.getText();
                    if (!res.isEmpty() && accept) {
                        while (!res.matches("^\\d+$")) {
                            accept = false;
                            view.responseQuestion.setText("");
                            view.popupQuestion.setVisible(true);
                            res = view.responseQuestion.getText();
                            if (!accept) {
                                break;
                            }
                        }
                        if (!res.isEmpty() && accept) {
                            int rows = Integer.parseInt(res);
                            insertRows(rows);
                            accept = false;
                        }
                    }
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
                    model.saveProperties(0, theme.theme, font.fontString, seeGrid, view.lazyLoadOption.isSelected());
                    hoursLayout.setRows(0);
                    centerLayout.setRows(0);
                    courses.clear();
                    view.pack();
                }
            }
        });

        view.acceptQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accept = true;
                view.popupQuestion.setVisible(false);
            }
        });

        view.responseQuestion.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    accept = true;
                    view.popupQuestion.setVisible(false);
                }
            }

        });

        view.gridOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!gridSelected) {
                    seeGrid = Controller.SEE_GRID;
                    view.hourLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                    for (int i = 0; i < view.daysPanel.getComponents().length; i++) {
                        JLabel label = (JLabel) view.daysPanel.getComponents()[i];
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                    }
                    for (int i = 0; i < view.hoursPanel.getComponents().length; i++) {
                        Tile tile = (Tile) view.hoursPanel.getComponents()[i];
                        tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                    }
                    for (int i = 0; i < view.centerPanel.getComponents().length; i++) {
                        Tile tile = (Tile) view.centerPanel.getComponents()[i];
                        tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                    }
                    gridSelected = true;
                } else {
                    seeGrid = Controller.NO_SEE_GRID;
                    view.hourLabel.setBorder(null);
                    for (int i = 0; i < view.daysPanel.getComponents().length; i++) {
                        JLabel label = (JLabel) view.daysPanel.getComponents()[i];
                        label.setBorder(null);
                    }
                    for (int i = 0; i < view.hoursPanel.getComponents().length; i++) {
                        Tile tile = (Tile) view.hoursPanel.getComponents()[i];
                        tile.setBorder(null);
                    }
                    for (int i = 0; i < view.centerPanel.getComponents().length; i++) {
                        Tile tile = (Tile) view.centerPanel.getComponents()[i];
                        tile.setBorder(null);
                    }
                    gridSelected = false;
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
                chooseFont(font.customFont, font.customFontBold);
            }
        });

        view.blackHighlightFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.BLACKHIGHLIGHT);
                chooseFont(font.customFont, font.customFontBold);
            }
        });

        view.verdanaFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.VERDANA);
                chooseFont(font.customFont, font.customFontBold);
            }
        });

        view.lettersFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.LETTERS);
                chooseFont(font.customFont, font.customFontBold);
            }
        });

        view.josephSophiaFontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = new CustomFont(CustomFont.JOSEPHSOPHIA);
                chooseFont(font.customFont, font.customFontBold);
            }
        });

        view.btnChoseColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorCourse = JColorChooser.showDialog(null, "Escoja un color", Color.WHITE);
            }
        });

        view.popupAddCourse.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                view.popupAddCourse.setVisible(false);
                for (int i = 0; i < view.centerPanel1.getComponentCount(); i++) {
                    Tile tileComponent = (Tile) view.centerPanel1.getComponent(i);
                    if (!tileComponent.getText().isEmpty()) {
                        Tile tileOriginal = (Tile) view.centerPanel.getComponent(view.centerPanel1.getComponentZOrder(tileComponent));
                        tileOriginal.setCourseName(tileComponent.getCourseName(), false);
                        tileOriginal.setUrl(tileComponent.getUrl(), false);
                        tileOriginal.setBackground(tileComponent.getBackground());
                        tileOriginal.setColorChanged(tileComponent.getColorChanged(), false);
                        tileOriginal.setText(tileComponent.getCourseName());
                    }
                }
                view.popupAddCourse.setVisible(false);
                view.setVisible(true);
            }

        });

        view.addCourseOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.hoursPanel1.removeAll();
                view.centerPanel1.removeAll();
                GridLayout gl1 = (GridLayout) view.hoursPanel1.getLayout();
                gl1.setColumns(1);
                gl1.setRows(hoursLayout.getRows());
                for (int i = 0; i < view.hoursPanel.getComponentCount(); i++) {
                    Tile tileOriginal = (Tile) view.hoursPanel.getComponent(i);
                    Tile tileCopied = new Tile(Tile.HOUR, "", "", tileOriginal.getHour(), tileOriginal.getBackground(), Tile.THEME);
                    tileCopied.setText(tileCopied.getHour());
                    tileCopied.setForeground(Tile.THEME.fontColor2);
                    tileCopied.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                    for (MouseListener ml : tileCopied.getMouseListeners()) {
                        tileCopied.removeMouseListener(ml);
                    }
                    tileCopied.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent me) {
                            tileCopied.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3, false));
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            tileCopied.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                        }
                    });
                    view.hoursPanel1.add(tileCopied, -1);
                }
                GridLayout gl2 = (GridLayout) view.centerPanel.getLayout();
                gl2.setColumns(5);
                gl2.setRows(centerLayout.getRows());
                for (int i = 0; i < view.centerPanel.getComponentCount(); i++) {
                    Tile tileOriginal = (Tile) view.centerPanel.getComponent(i);
                    Tile tileCopied = new Tile("", tileOriginal.getCourseName(), tileOriginal.getUrl(), "", tileOriginal.getBackground(), Tile.THEME);
                    tileCopied.setColorChanged(tileOriginal.getColorChanged(), false);
                    tileCopied.setText(tileCopied.getCourseName());
                    tileCopied.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                    for (MouseListener ml : tileCopied.getMouseListeners()) {
                        tileCopied.removeMouseListener(ml);
                    }
                    if (tileCopied.getCourseName().equals("Curso")) {
                        tileCopied.setText("");
                    }
                    tileCopied.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            if (tileCopied.getText().isEmpty()) {
                                tileCopied.setText(view.areaCourseName.getText());
                                tileCopied.setCourseName(view.areaCourseName.getText(), false);
                                tileCopied.setUrl(view.areaUrlCourse.getText(), false);
                                tileCopied.setBackground(colorCourse);
                                if (colorCourse != theme.coursesColor) {
                                    tileCopied.setColorChanged("v", false);
                                } else {
                                    tileCopied.setColorChanged("f", false);
                                }
                            } else {
                                tileCopied.setText("");
                                tileCopied.setBackground(theme.coursesColor);
                            }
                        }

                        @Override
                        public void mouseEntered(MouseEvent me) {
                            tileCopied.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3, false));
                        }

                        @Override
                        public void mouseExited(MouseEvent me) {
                            tileCopied.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                        }
                    });
                    tileCopied.setForeground(Tile.THEME.fontColor);
                    view.centerPanel1.add(tileCopied, -1);
                }
                colorCourse = theme.coursesColor;
                view.areaCourseName.setText("");
                view.areaUrlCourse.setText("");
                view.setVisible(false);
                view.popupAddCourse.setVisible(true);
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

        view.crossPanel1.setBackground(theme.containerColor);
        view.container1.setBackground(theme.containerColor);
        view.daysPanel1.setBackground(theme.daysColor);
        view.hoursPanel1.setBackground(theme.containerColor);
        view.centerPanel1.setBackground(theme.containerColor);

        view.hourLabel1.setForeground(theme.fontColor2);
        view.mondayLabel1.setForeground(theme.fontColor2);
        view.tuesdayLabel1.setForeground(theme.fontColor2);
        view.wednesdayLabel1.setForeground(theme.fontColor2);
        view.thursdayLabel1.setForeground(theme.fontColor2);
        view.fridayLabel1.setForeground(theme.fontColor2);

        view.informationPanel.setBackground(theme.coursesColor);
        view.labelNameCourse.setForeground(theme.fontColor);
        view.labelUrlCourse.setForeground(theme.fontColor);

        view.containerQuestion.setBackground(theme.daysColor);
        view.questionLabel.setForeground(theme.fontColor2);
        view.acceptQuestion.setBackground(theme.containerColor);
        view.acceptQuestion.setForeground(theme.fontColor);
        view.btnChoseColor.setBackground(theme.coursesColor);

        Tile.THEME = theme;

        if (view.hoursPanel.getComponents().length > 0) {
            Tile.containerInformation.setBackground(theme.daysColor);
            Tile.messageInformation.setForeground(theme.fontColor2);
            Tile.aceptButton.setBackground(theme.containerColor);
            Tile.aceptButton.setForeground(theme.fontColor);
            Tile.checkBoxContainer.setBackground(theme.daysColor);
            Tile.checkBoxInformation.setBackground(theme.daysColor);
            Tile.checkBoxInformation.setForeground(theme.fontColor2);
        }

        for (int i = 0; i < view.hoursPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.hoursPanel.getComponents()[i];
            tile.setTheme(theme);
            tile.setForeground(theme.fontColor2);
            if ("f".equals(tile.getColorChanged())) {
                tile.setBackground(theme.hoursColor);
            }
        }

        for (int i = 0; i < view.centerPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.centerPanel.getComponents()[i];
            tile.setTheme(theme);
            tile.setForeground(theme.fontColor);
            if ("f".equals(tile.getColorChanged())) {
                tile.setBackground(theme.coursesColor);
            }
        }

        view.hoursPanel.repaint();
        view.centerPanel.repaint();
        view.pack();
    }

    private void chooseFont(Font font, Font fontBold) {
        view.setFont(font);
        view.hourLabel.setFont(font);
        view.mondayLabel.setFont(fontBold);
        view.tuesdayLabel.setFont(fontBold);
        view.wednesdayLabel.setFont(fontBold);
        view.thursdayLabel.setFont(fontBold);
        view.fridayLabel.setFont(fontBold);

        for (int i = 0; i < view.hoursPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.hoursPanel.getComponents()[i];
            tile.setFont(fontBold);
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
            if (gridSelected) {
                row.hour.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
            }
            view.hoursPanel.add(row.hour, -1);
            for (Tile day : row.days) {
                day.setText(day.getCourseName());
                if (gridSelected) {
                    day.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                }
                view.centerPanel.add(day, -1);
            }
            view.hoursPanel.repaint();
            view.centerPanel.repaint();
            view.pack();
        }
    }

    private void listenerOnCells() {
        for (int i = 0; i < view.centerPanel.getComponentCount(); i++) {
            Tile tile = (Tile) view.centerPanel.getComponent(i);
            tile.addTileListener(new TileListener() {
                @Override
                public void nameChanged(Tile tile) {
                    if (Tile.checkBoxInformation.isSelected()) {
                        for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                            Tile tileI = (Tile) view.centerPanel.getComponent(j);
                            if (tileI.getCourseName().equals(tile.getOldCourseName())) {
                                tileI.setCourseName(tile.getCourseName(), false);
                                tileI.setText(tile.getCourseName());
                                tile.setText(tile.getCourseName());
                            }
                        }
                    } else {
                        tile.setText(tile.getCourseName());
                    }
                }

                @Override
                public void urlChanged(Tile tile) {
                    if (Tile.checkBoxInformation.isSelected()) {
                        for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                            Tile tileI = (Tile) view.centerPanel.getComponent(j);
                            if (tileI.getCourseName().equals(tile.getCourseName())) {
                                tileI.setUrl(tile.getUrl(), false);
                            }
                        }
                    } else {

                    }
                }

                @Override
                public void backgroundChanged(Tile tile) {
                    if (Tile.checkBoxInformation.isSelected()) {
                        for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                            Tile tileI = (Tile) view.centerPanel.getComponent(j);
                            if (tileI.getCourseName().equals(tile.getCourseName())) {
                                tileI.setColorChanged(tile.getColorChanged(), false);
                                tileI.setBackground(tile.getBackground());
                            }
                        }
                    } else {

                    }
                }
            });
        }
    }

    private void addListenerOnTile(Tile tile) {
        tile.addTileListener(new TileListener() {
            @Override
            public void nameChanged(Tile tile) {
                if (Tile.checkBoxInformation.isSelected()) {
                    for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                        Tile tileI = (Tile) view.centerPanel.getComponent(j);
                        if (tileI.getCourseName().equals(tile.getOldCourseName())) {
                            tileI.setCourseName(tile.getCourseName(), false);
                            tileI.setText(tile.getCourseName());
                            tile.setText(tile.getCourseName());
                        }
                    }
                } else {
                    tile.setText(tile.getCourseName());
                }
            }

            @Override
            public void urlChanged(Tile tile) {
                if (Tile.checkBoxInformation.isSelected()) {
                    for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                        Tile tileI = (Tile) view.centerPanel.getComponent(j);
                        if (tileI.getCourseName().equals(tile.getCourseName())) {
                            tileI.setUrl(tile.getUrl(), false);
                        }
                    }
                } else {

                }
            }

            @Override
            public void backgroundChanged(Tile tile) {
                if (Tile.checkBoxInformation.isSelected()) {
                    for (int j = 0; j < view.centerPanel.getComponentCount(); j++) {
                        Tile tileI = (Tile) view.centerPanel.getComponent(j);
                        if (tileI.getCourseName().equals(tile.getCourseName())) {
                            tileI.setColorChanged(tile.getColorChanged(), false);
                            tileI.setBackground(tile.getBackground());
                        }
                    }
                } else {

                }
            }
        });
    }

    private void insertRows(int rows) {
        hoursLayout.setRows(rows);
        centerLayout.setRows(rows);
        for (int i = 0; i < rows; i++) {
            Row row = new Row(theme);
            row.hour.setText(row.hour.getHour());
            addListenerOnTile(row.hour);
            if (gridSelected) {
                row.hour.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
            }
            view.hoursPanel.add(row.hour, -1);
            for (Tile day : row.days) {
                day.setText(day.getCourseName());
                addListenerOnTile(day);
                if (gridSelected) {
                    day.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                }
                view.centerPanel.add(day, -1);
            }
            view.hoursPanel.repaint();
            view.centerPanel.repaint();
            view.pack();
        }
        chooseTheme();
        chooseFont(font.customFont, font.customFontBold);
    }

    private void selectRadioButtons(String theme, String font, String seeGrid) {
        switch (theme) {
            case Theme.BLUE_GRAY:
                view.blueGrayTheme.setSelected(true);
                break;
            case Theme.DARK:
                view.darkTheme.setSelected(true);
                break;
            case Theme.GRAY:
                view.grayTheme.setSelected(true);
                break;
            case Theme.LIGHT:
                view.lightTheme.setSelected(true);
                break;
            case Theme.LIGHT_BLUE:
                view.lightBlueTheme.setSelected(true);
                break;
            case Theme.ORANGE:
                view.orangeTheme.setSelected(true);
                break;
            case Theme.PINK:
                view.pinkTheme.setSelected(true);
                break;
            case Theme.PURPLE:
                view.purpleTheme.setSelected(true);
                break;
            default:
                view.lightTheme.setSelected(true);
                break;
        }
        switch (font) {
            case CustomFont.BLACKHIGHLIGHT:
                view.blackHighlightFontOption.setSelected(true);
                break;
            case CustomFont.JOSEPHSOPHIA:
                view.josephSophiaFontOption.setSelected(true);
                break;
            case CustomFont.LETTERS:
                view.lettersFontOption.setSelected(true);
                break;
            case CustomFont.TIMESNEWROMAN:
                view.timesNewRomanFontOption.setSelected(true);
                break;
            case CustomFont.VERDANA:
                view.verdanaFontOption.setSelected(true);
                break;
            default:
                view.verdanaFontOption.setSelected(true);
                break;
        }
        if (seeGrid.equals(Controller.SEE_GRID)) {
            view.gridOption.setSelected(true);
            view.hourLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
            for (int i = 0; i < view.daysPanel.getComponents().length; i++) {
                JLabel label = (JLabel) view.daysPanel.getComponents()[i];
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
            }
            gridSelected = true;
        } else {
            view.gridOption.setSelected(false);
            gridSelected = false;
        }
    }
    //<editor-fold defaultstate="collapsed" desc="Class Process">

    class Process extends Thread {

        JDialog dialog;
        JProgressBar progress;

        public Process(JDialog dialog, JProgressBar progress) {
            this.dialog = dialog;
            this.progress = progress;
        }

        @Override
        public void run() {
            try {
                dialog.setVisible(true);
                for (int i = 1; i <= 100; i++) {
                    progress.setValue(i);
                    Process.sleep(7);
                }
                dialog.setVisible(false);
                this.interrupt();
            } catch (InterruptedException ex) {
            } catch (Throwable ex) {
            }
        }

    }
//</editor-fold>

}
