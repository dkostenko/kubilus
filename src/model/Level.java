/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import game.Settings;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author macbook
 */
public class Level {
    ArrayList<Block> blocks;
    int[][] map;
    private Point offset;
    private Point lastPointDown;
    private Block selectedBlock;
    
    public Level(int[][] map, ArrayList<Block> blocks){
        this.map = map;
        this.blocks = blocks;
        this.offset = new Point(0, 0);
        this.offset.x = (Settings.getGAME_WIDTH() - 200) / 2 - map[0].length * Settings.getBLOCK_SIZE() / 2;
        this.offset.y = Settings.getGAME_HEIGHT() / 2 - map.length * Settings.getBLOCK_SIZE() / 2;
        this.selectedBlock = this.blocks.get(0);
    }
    
    public boolean tryToSelectBlock(Point point){
        Rectangle rect;
        
        for(Block b : blocks) {
            rect = new Rectangle(Settings.getBLOCK_SIZE() * b.getPoint().x + this.offset.x, 
                                 Settings.getBLOCK_SIZE() * b.getPoint().y + this.offset.y + Settings.getBLOCK_SIZE() / 2, 
                                 Settings.getBLOCK_SIZE(), 
                                 Settings.getBLOCK_SIZE());
            
            if(rect.contains(point)) {
                this.selectedBlock = b;
                this.lastPointDown = point;
                return true;
            }
        }
        
        this.lastPointDown = null;
        return false;
    }
    
    public void selectNextBlock(){
        
        // т.к. id блока всегда на 1 больше, чем необходимо (т.к. у препятствий id=1), поэтому вычитаем 1
        
        if(this.selectedBlock.getId() - 1 >= this.blocks.size()){
            this.selectedBlock = this.blocks.get(0);
        } else {
            this.selectedBlock = this.blocks.get(this.selectedBlock.getId() - 1);
        }
    }
    
    public void draw(Graphics g) {
        System.out.println("Level.draw(Graphics g)");
        
        boolean drawOval = false;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch(map[i][j]){
                    case 1:
                        g.setColor(Color.GRAY);
                        g.fillRect(j * Settings.getBLOCK_SIZE() + offset.x, 
                                   i * Settings.getBLOCK_SIZE() + offset.y,
                                   Settings.getBLOCK_SIZE(), 
                                   Settings.getBLOCK_SIZE());
                        
                        g.setColor(Color.BLACK);
                        g.drawRect(j * Settings.getBLOCK_SIZE() + offset.x, 
                                   i * Settings.getBLOCK_SIZE() + offset.y,
                                   Settings.getBLOCK_SIZE(), 
                                   Settings.getBLOCK_SIZE());
                        
                        drawOval = false;
                        break;
                    case 2:
                        g.setColor(Color.BLUE);
                        drawOval = true;
                        break;
                    case 3:
                        g.setColor(Color.GREEN);
                        drawOval = true;
                        break;
                    case 4:
                        g.setColor(Color.MAGENTA);
                        drawOval = true;
                        break;
                }
                
                if(drawOval){
                    g.fillOval(j * Settings.getBLOCK_SIZE() + 1 + offset.x, 
                               i * Settings.getBLOCK_SIZE() + 1 + offset.y, 
                               Settings.getBLOCK_SIZE() - 1, 
                               Settings.getBLOCK_SIZE() - 1);
                    drawOval = false;
                }                
            }
        }

        for (Block block : blocks) {
            if(selectedBlock != null && block.getId() == selectedBlock.getId()) {                
                block.draw(g, true, this.offset.x, this.offset.y);
            }
            else {
                block.draw(g, false, this.offset.x, this.offset.y);
            }
        }
    }

    /**
     * @return the lastPointDown
     */
    public Point getLastPointDown() {
        return lastPointDown;
    }
}
