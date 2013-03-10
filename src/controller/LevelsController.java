/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Point;
import model.Level;
import view.LevelView;
import game.Direction;
import game.Settings;
import bd.Levels;
import game.State;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
            draw();
            
            if(this.currentLevel == null){
                game.Main.state = State.downtime;
                System.out.println("ИГРА ЗАКОНЧЕНА");
                return 0;
            }
            
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
    
    
    public void saveResult(){ 
        PrintWriter printWriter = null;
        try{
            switch(Settings.getAvailableControl()){
                case MOUSE_ON_FIELD:
                    printWriter = new PrintWriter(new FileOutputStream("MOUSE_ON_FIELD.txt", true));
                    break;
                case PANEL_BUTTONS:
                    printWriter = new PrintWriter(new FileOutputStream("PANEL_BUTTONS.txt", true));
                    break;
                case KEYBOARD:
                    printWriter = new PrintWriter(new FileOutputStream("KEYBOARD.txt", true));
                    break;
            }
            
            if(this.currentLevel != null){
                printWriter.println(this.currentLevel.getId() - 1);
            } else {
                printWriter.println(999999);
            }
            
            printWriter.close();
        }
        catch(FileNotFoundException e)
        {
            System.exit(0);
        }
    }

    /**
     * @return the levelView
     */
    public LevelView getLevelView() {
        return levelView;
    }
}