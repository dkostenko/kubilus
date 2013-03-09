/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Point;
import game.Settings;
import java.awt.Graphics;

/**
 *
 * @author macbook
 */
public class Block {
    private Point point;
    private int id;
    private Color color;
    
    public Block(Point point, int id, Color color){
        this.point = point;
        this.id = id;
        this.color = color;
    }

    void draw(Graphics g, boolean selected, int xOffset, int yOffset) {
        System.out.println("Block.draw()");
        
        if(selected){
            g.setColor(Color.RED);
        } else {
            g.setColor(color);
        }
        
        g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset, 
                   point.y * Settings.getBLOCK_SIZE() + 1 + yOffset, 
                   Settings.getBLOCK_SIZE() - 2, 
                   Settings.getBLOCK_SIZE() - 2);
    }
    
    public boolean isInRectangle(){
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the point
     */
    public Point getPoint() {
        return point;
    }
}
