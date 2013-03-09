/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import model.Block;
import model.Level;

/**
 *
 * @author macbook
 */
public class Levels {
    public static Level getLevel(int id){
        switch(id){
            case 1: return getLevel1();
            case 2: return getLevel2();
        }
        
        return null;
    }
    
    private static Level getLevel1(){
        ArrayList<Block> blocks = new ArrayList<>();
        int[][] map = new int[][] {{ 1, 1, 1, 1, 1, 1 }, 
                                   { 1, 0, 2, 0, 0, 1 },
                                   { 1, 0, 0, 0, 3, 1 },
                                   { 1, 0, 0, 0, 0, 1 },
                                   { 1, 0, 0, 0, 0, 1 },
                                   { 1, 1, 1, 1, 1, 1 }};
        blocks.add(new Block(new Point(2, 1), 2, Color.BLUE));
        blocks.add(new Block(new Point(4, 2), 3, Color.GREEN));
        
        return new Level(map, blocks);
    }

    private static Level getLevel2(){
        ArrayList<Block> blocks = new ArrayList<>();
        int[][] map = new int[][] {{ 1, 1, 1, 1, 1, 1 }, 
                                   { 1, 0, 2, 0, 0, 1 },
                                   { 1, 0, 0, 0, 3, 1 },
                                   { 1, 0, 0, 0, 0, 1 },
                                   { 1, 0, 0, 0, 0, 1 },
                                   { 1, 1, 1, 1, 1, 1 }};
        blocks.add(new Block(new Point(2, 1), 2, Color.BLUE));
        blocks.add(new Block(new Point(4, 2), 3, Color.GREEN));
        
        return new Level(map, blocks);
    }
}
