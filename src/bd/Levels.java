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
            case 3: return getLevel3();
            case 4: return getLevel4();
            case 5: return getLevel5();
            case 6: return getLevel6();
            case 7: return getLevel7();
            case 8: return getLevel8();
            case 9: return getLevel9();
            case 10: return getLevel10();
        }
        
        return null;
    }
    
    private static Level getLevel1(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.NONE, Type.NONE, Type.CLUBS, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.WALL, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.WALL, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.WALL, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.WALL, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.WALL, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        
        return new Level(1, map, blocks, 22);
    }

    private static Level getLevel2(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.CLUBS, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.DIAMONDS, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.HEARTS, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.SPIDES, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(1, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 1), 2, Type.DIAMONDS));
        blocks.add(new Block(new Point(3, 1), 3, Type.HEARTS));
        blocks.add(new Block(new Point(4, 1), 4, Type.SPIDES));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel3(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel4(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel5(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel6(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel7(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel8(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel9(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
    
    
    private static Level getLevel10(){
        ArrayList<Block> blocks = new ArrayList<>();
        Type[][] map = new Type[][]{{Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }, 
                                   { Type.WALL, Type.CLUBS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.NONE, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.DIAMONDS, Type.NONE, Type.NONE, Type.NONE, Type.WALL },
                                   { Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL, Type.WALL }};
        blocks.add(new Block(new Point(2, 1), 1, Type.CLUBS));
        blocks.add(new Block(new Point(2, 4), 2, Type.DIAMONDS));
        
        return new Level(2, map, blocks, 10);
    }
}
