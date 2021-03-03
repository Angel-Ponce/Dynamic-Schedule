/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScheduleStructure;

import java.util.EventListener;

/**
 *
 * @author angelponce
 */
public interface TileListener extends EventListener {

    public void nameChanged(Tile tile);

    public void urlChanged(Tile tile);
    
    public void backgroundChanged(Tile tile);
}
