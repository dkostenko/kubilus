/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import model.Block;
import model.Level;
import view.LevelView;
import game.Direction;
import game.Settings;
import bd.Levels;
import game.State;

/**
 *
 * @author macbook
 */
public class LevelsController {
    private Level currentLevel;
    private LevelView levelView;
    
    
    public LevelsController(){
        this.currentLevel = Levels.getLevel(1);
        this.levelView = new LevelView(this.currentLevel);
    }
    
    
    public void selectBlock(Point point){
        currentLevel.tryToSelectBlock(point);
    }
    
    
    public void selectBlock(){
        currentLevel.selectNextBlock();
    }
    
    
    public void moveBlock(Point upPoint){
        Point downPoint = this.currentLevel.getLastPointDown();
        if(downPoint != null){
            this.currentLevel.startMoving(getDirection(downPoint, upPoint));
        }
    }
    
    
    public int update(){
        if(this.currentLevel.isFinished()){
            this.currentLevel = Levels.getLevel(this.currentLevel.getId() + 1);
            this.levelView.setLevel(currentLevel);
        }
        
        int leftTime = this.currentLevel.updateTimeLeft();
        if(leftTime == 0){
            game.Main.state = State.downtime;
        }
        return leftTime;
    }
    
    
    public void draw(){
        this.levelView.repaint();
    }
    
    
    public void moveBlock(Direction direction){
        this.currentLevel.startMoving(direction);
    }
    
    
    private Direction getDirection(Point down, Point up){        
        up.x -= down.x;
        up.y -= down.y;
        
        if(up.x * up.x + up.y * up.y < Settings.getBLOCK_SIZE() * Settings.getBLOCK_SIZE()){
            return Direction.NONE;
        }
        
        if(up.x > up.y){
            if(up.x + up.y > 0){
                return Direction.RIGHT;
            } else {
                return Direction.TOP;
            }
        } else {
            if(up.x + up.y > 0){
                return Direction.BOTTOM;
            } else {
                return Direction.LEFT;
            }
        }
    }

    /**
     * @return the levelView
     */
    public LevelView getLevelView() {
        return levelView;
    }
}