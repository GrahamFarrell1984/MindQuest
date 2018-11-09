/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.gamestates;

import java.awt.Graphics;
import java.util.Stack;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class GameStateManager {
    
    // Declares a Stack named states.
    
    public Stack<GameState> states;
    
    // GamesStateManager Constructor.
    
    public GameStateManager() {
        
        // Creates a new Stack.
        
        states = new Stack<GameState>();
        
        // Creates a new instance of the MenuState class, passes in "this" GameStateManager object named gameStateManager and then adds it to the top of the Stack named states.
        
        states.push(new MenuState(this));
        
    }
    
    public void update() {
        
        // Updates whatever game state is on the top of the Stack
        states.peek().update();
        
    }
    
    public void draw(Graphics g) {
        
        // Draws whatever game state is on the top of the Stack
        states.peek().draw(g);
        
    }
    
    public void keyPressed(int keyCode) {
        
        // Checks for keys being pressed from whatever game state is on the top of the Stack
        states.peek().keyPressed(keyCode);
        //System.out.println("GameStateManager Key Pressed");
        
    }
    
    public void keyReleased(int keyCode) {
        
        // Checks for keys being released from whatever game state is on the top of the Stack
        states.peek().keyReleased(keyCode);
        //System.out.println("GameStateManager Key Released");
        
    }
    
    // This method is not used in this class but has to be implemented as part of the KeyListener class
    
    public void keyTyped(int keyCode) {
        
        // No code required
        
    }
    
}
