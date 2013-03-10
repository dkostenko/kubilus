/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import game.Direction;
import java.awt.Color;
import java.awt.Point;
import game.Settings;
import game.State;
import java.awt.Graphics;
import game.Type;

/**
 *
 * @author macbook
 */
public class Block {
    private Type type;
    private Point point;
    private Point futurePoint;
    private int id;
    private Color color;
    private Direction direction;
    private int haveToPassPixels;
    private int passedPixels;
    
    public Block(Point point, int id, Type type){
        this.point = point;
        this.id = id;
        this.color = Color.BLUE;
        this.type = type;
        this.direction = Direction.NONE;
        this.haveToPassPixels = 0;
        this.passedPixels = 0;
    }

    void draw(Graphics g, boolean selected, int xOffset, int yOffset) {
        
        if(selected){
            g.setColor(Color.RED);
        } else {
            g.setColor(color);
        }
        
        switch(this.direction){
            case NONE:
                g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset, 
                           point.y * Settings.getBLOCK_SIZE() + 1 + yOffset, 
                           Settings.getBLOCK_SIZE() - 2, 
                           Settings.getBLOCK_SIZE() - 2);
                break;
            case TOP:
                passedPixels += Settings.getBLOCK_SPEED();
                g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset, 
                           point.y * Settings.getBLOCK_SIZE() + 1 + yOffset - passedPixels, 
                           Settings.getBLOCK_SIZE() - 2, 
                           Settings.getBLOCK_SIZE() - 2);
                tryToFinishMoving();
                break;
            case RIGHT:
                passedPixels += Settings.getBLOCK_SPEED();
                g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset + passedPixels, 
                           point.y * Settings.getBLOCK_SIZE() + 1 + yOffset, 
                           Settings.getBLOCK_SIZE() - 2, 
                           Settings.getBLOCK_SIZE() - 2);
                tryToFinishMoving();
                break;
            case BOTTOM:
                passedPixels += Settings.getBLOCK_SPEED();
                g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset, 
                           point.y * Settings.getBLOCK_SIZE() + 1 + yOffset + passedPixels, 
                           Settings.getBLOCK_SIZE() - 2, 
                           Settings.getBLOCK_SIZE() - 2);
                tryToFinishMoving();
                break;
            case LEFT:
                passedPixels += Settings.getBLOCK_SPEED();
                g.drawRect(point.x * Settings.getBLOCK_SIZE() + 1 + xOffset - passedPixels, 
                           point.y * Settings.getBLOCK_SIZE() + 1 + yOffset, 
                           Settings.getBLOCK_SIZE() - 2, 
                           Settings.getBLOCK_SIZE() - 2);
                tryToFinishMoving();
                break;
        }
    }
    
    private void tryToFinishMoving(){
        if(direction != Direction.NONE && passedPixels == haveToPassPixels){
            direction = Direction.NONE;
            passedPixels = 0;
            haveToPassPixels = 0;
            this.point = futurePoint;
            game.Main.state = State.gaming;
        }
    }
    
    public boolean move(Direction direction, int steps){
        this.direction = direction;
        this.haveToPassPixels = steps * Settings.getBLOCK_SIZE();
        switch(direction){
            case NONE:
                this.futurePoint = this.point;
                break;
            case TOP:
                this.futurePoint = new Point(this.point.x, this.point.y - steps);
                break;
            case RIGHT:
                this.futurePoint = new Point(this.point.x + steps, this.point.y);
                break;
            case BOTTOM:
                this.futurePoint = new Point(this.point.x, this.point.y + steps);
                break;
            case LEFT:
                this.futurePoint = new Point(this.point.x - steps, this.point.y);
                break;
        }
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

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }
}
