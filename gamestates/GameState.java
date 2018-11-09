/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.gamestates;

import java.awt.Graphics;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public abstract class GameState {
    
    // Declares GameStateManager object
    
    protected GameStateManager gameStateManager;
    
    // Declares variables
    
    public static int xOffset, yOffset;
    
    // GameState Constructor
    
    public GameState(GameStateManager gameStateManager) {
        
        this.gameStateManager = gameStateManager;
        
        GameState.xOffset = 0;
        GameState.yOffset = 0;
        
        init();
        
    }
    
    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int keyCode);
    public abstract void keyReleased(int keyCode);
    public abstract void keyTyped(int keyCode);
    
}
