package ScheduleStructure;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        events();
    }

    public void init() {
        //Default code before
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void events() {
        view.exitOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        view.addRowOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
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
        });
    }

}
