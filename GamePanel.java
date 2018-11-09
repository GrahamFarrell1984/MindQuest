/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest;

import mindquest.gamestates.GameStateManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    
    // Declares variables
    
    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    
    private Thread thread;
    private boolean gameIsRunning;
    
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    
    // Declares a private GameStateManager object named gameStateManger
    
    private GameStateManager gameStateManager;
    
    // GamePanel Constructor
    
    public GamePanel() {
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        start();
        
    }
    
    private void start() {
        
        gameIsRunning = true;
        addKeyListener(this);
        thread = new Thread(this);
        thread.start();
        
    }
    
    public void run() {
        
        long startTime, elapsedTime, waitTime;
        
        // Creates a new GameStateManager object
        
        gameStateManager = new GameStateManager();
        
        // While loop runs as long as the boolean gameIsRunning is true.
        // This is the game loop.
        // It calls the update() and repaint() methods continuously while the boolean gameIsRunning is true
        // 
        
        while(gameIsRunning) {
            
            startTime = System.nanoTime();
            
            update();
            repaint();
            
            elapsedTime = System.nanoTime() - startTime;
            waitTime = targetTime - elapsedTime / 1000000;
            
            if(waitTime >= 0) {
                
                waitTime = 3;
                
                try {
                    
                    Thread.sleep(waitTime);
                    
                } 
                
                catch (InterruptedException ex) {
                    
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
            }
            
        }
        
    }
    
    public void update() {
        
        gameStateManager.update();
        
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        gameStateManager.draw(g);
        
    }
    
    // Method called in this class whenever a key is pressed
    
    public void keyPressed(KeyEvent keyEvent) {
    
        // Calls the keyPressed method in the GameStateManager class, gets the KeyCode from whatever key was pressed by the user in this class and then passes in 1 KeyEvent parameter named keyEvent
        
        gameStateManager.keyPressed(keyEvent.getKeyCode());
        //System.out.println("GamePanel Key Pressed");
    
    }

    // Method called in this class whenever a key is released
    
    public void keyReleased(KeyEvent keyEvent) {
    
        // Calls the keyReleased method in the GameStateManager class, gets the KeyCode from whatever key was released by the user in this class and then passes in 1 KeyEvent parameter named keyEvent
        
        gameStateManager.keyReleased(keyEvent.getKeyCode());
        //System.out.println("GamePanel Key Released");
    
    }
    
    // This method is not used in this class but has to be implemented as part of the KeyListener class
    
    public void keyTyped(KeyEvent keyEvent) {
    
        // No code required
    
    }

}
