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
import game.Type;

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
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.CLUBS, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(4, 2), 2, Type.CLUBS));
        
        return new Level(map, blocks);
    }

    private static Level getLevel2(){
        return null;
    }
}
