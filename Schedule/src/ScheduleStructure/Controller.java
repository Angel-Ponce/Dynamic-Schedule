package ScheduleStructure;

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

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        hoursLayout = (GridLayout) view.hoursPanel.getLayout();
        centerLayout = (GridLayout) view.centerPanel.getLayout();
        events();
    }

    public void init() {
        //Default code before
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void events() {

        view.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        view.exitOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                if (properties.getLines().size() == 0) {
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

                            ArrayList<String> lines = new ArrayList();
                            lines.add("hours_rows = " + rows);
                            properties.setLines(lines);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede crear un horario nuevo porque actualmente ya existe uno.\nPara crear uno nuevo reinicie el horario porfavor","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
