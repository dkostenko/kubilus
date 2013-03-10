/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import game.Direction;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import game.Settings;
import game.State;
import game.Type;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author macbook
 */
public class Level {
    private ArrayList<Block> blocks;
    private Type[][] map;
    private Point offset;
    private Point lastPointDown;
    private Block selectedBlock;
    private int timeLeft;
    private int id;
    
    public Level(int id, Type[][] map, ArrayList<Block> blocks, int timeLeft){
        this.map = map;
        this.blocks = blocks;
        this.offset = new Point(0, 0);
        this.offset.x = (Settings.getGAME_WIDTH() - 200) / 2 - map[0].length * Settings.getBLOCK_SIZE() / 2;
        this.offset.y = Settings.getGAME_HEIGHT() / 2 - map.length * Settings.getBLOCK_SIZE() / 2;
        this.selectedBlock = this.blocks.get(0);
        this.timeLeft = timeLeft;
        this.id = id;
    }
    
    public void startMoving(Direction direction){
        if(direction == Direction.NONE){
            return;
        }
        
        int steps = getPossibleStepsAmount(direction);
        
        if(steps > 0){
           game.Main.state = State.moving;
           this.selectedBlock.move(direction, steps); 
        }
    }
    
    private int getPossibleStepsAmount(Direction direction){
        int steps = 0;
        
        switch(direction){
            case TOP:
                while(!isCollision(map[selectedBlock.getPoint().x][selectedBlock.getPoint().y - steps])){
                    steps++;
                }
                break;
            case RIGHT:
                while(!isCollision(map[selectedBlock.getPoint().x + steps][selectedBlock.getPoint().y])){
                    steps++;
                }
                break;
            case BOTTOM:
                while(!isCollision(map[selectedBlock.getPoint().x][selectedBlock.getPoint().y + steps])){
                    steps++;
                }
                break;
            case LEFT:
                while(!isCollision(map[selectedBlock.getPoint().x - steps][selectedBlock.getPoint().y])){
                    steps++;
                }
                break;
        }
        
        return steps - 1;
    }
    
    private boolean isCollision(Type type){
        if(type == Type.WALL){
            return true;
        }
        return false;
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
        if(this.selectedBlock.getId() >= this.blocks.size()){
            this.selectedBlock = this.blocks.get(0);
        } else {
            this.selectedBlock = this.blocks.get(this.selectedBlock.getId());
        }
    }
    
    public void draw(Graphics g) {
        boolean drawOval = false;
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch(map[i][j]){
                    case WALL:
                        g.setColor(Color.GRAY);
                        g.fillRect(i * Settings.getBLOCK_SIZE() + offset.x, 
                                   j * Settings.getBLOCK_SIZE() + offset.y,
                                   Settings.getBLOCK_SIZE(), 
                                   Settings.getBLOCK_SIZE());
                        
                        g.setColor(Color.BLACK);
                        g.drawRect(i * Settings.getBLOCK_SIZE() + offset.x, 
                                   j * Settings.getBLOCK_SIZE() + offset.y,
                                   Settings.getBLOCK_SIZE(), 
                                   Settings.getBLOCK_SIZE());
                        
                        drawOval = false;
                        break;
                    case CLUBS:
                        g.setColor(Color.BLUE);
                        drawOval = true;
                        break;
                }
                
                if(drawOval){
                    g.fillOval(i * Settings.getBLOCK_SIZE() + 1 + offset.x, 
                               j * Settings.getBLOCK_SIZE() + 1 + offset.y, 
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
    
    public boolean isFinished(){
        for (Block block : blocks) {
            if(map[block.getPoint().x][block.getPoint().y] != block.getType()){
                return false;
            }
        }
        
        return true;
    }

    /**
     * @return the lastPointDown
     */
    public Point getLastPointDown() {
        return lastPointDown;
    }
    
     /**
     * @return new timeLeft
     */
    public int updateTimeLeft() {
        return --timeLeft;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
