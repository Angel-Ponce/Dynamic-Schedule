package ScheduleStructure;

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
    
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }
    
    public void init(){
        //Default code before
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
    
    
}
