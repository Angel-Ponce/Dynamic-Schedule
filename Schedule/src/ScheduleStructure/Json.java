/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joans
 */
public class Json {

    public File file;
    private ArrayList<String> objects = new ArrayList();

    public Json(String fileName) {
        try {
            file = new File(fileName + ".json");
            if (file.createNewFile()) {
                System.out.println("file created successfully");
            } else {
                System.out.println("file already exists");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo de información" + fileName, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public ArrayList<String> getJsons() {
        objects.clear();
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(file);
            bf = new BufferedReader(fr);
            String linea;
            while ((linea = bf.readLine()) != null) {
                objects.add(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo de información", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return objects;
    }

    public void saveJsons(ArrayList<String> objects) {
        FileWriter fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileWriter(file, true);
            pw = new PrintWriter(fr);
            clear();
            for (String obj : objects) {
                pw.println(obj);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo de información", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (null != pw) {
                    pw.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo de información", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void clear() {
        FileWriter fr = null;
        PrintWriter pw = null;
        try {
            fr = new FileWriter(file);
            pw = new PrintWriter(fr);
            fr.write("");
        } catch (IOException e) {
        } finally {
            try {
                if (null != pw) {
                    pw.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, no se encontro el archivo de información", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
