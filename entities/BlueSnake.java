/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.entities;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import mindquest.gamestates.GameState;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class BlueSnake {
    
    // Declare variables
    
    private ImageIcon blueSnakeImageIcon;
    
    private Image blueSnakeImage;
    
    private double blueSnakeXPosition, blueSnakeYPosition;
    
    // BlueSnake Constructor
    // Takes 2 double parameters determining the x and y positions of the BlueSnake object
    
    public BlueSnake(double blueSnakeXPosition, double blueSnakeYPosition) {
        
        this.blueSnakeXPosition = blueSnakeXPosition;
        this.blueSnakeYPosition = blueSnakeYPosition;
        
        blueSnakeImageIcon = new ImageIcon("src/mindquest/entities/entity_images/blue_snake_left_17x22px.png");
        blueSnakeImage = blueSnakeImageIcon.getImage();
        
    }
    
    // Methods
    
    public void update() {
        
        blueSnakeXPosition = blueSnakeXPosition - 1;
        
    }
    
    // This method takes the x and y positions of the player object and allows the enemy object to follow the player object
    // It is a form of simple AI
    // The method is not actually implemented at the moment
    
    public void update(double playerXPosition, double playerYPosition) {
        
        if(blueSnakeXPosition > playerXPosition + GameState.xOffset - 100) {
            
            blueSnakeXPosition = blueSnakeXPosition - 1;
            
        }
        
        if(blueSnakeXPosition < playerXPosition + GameState.xOffset - 100) {
            
            blueSnakeXPosition = blueSnakeXPosition + 1;
            
        }
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(blueSnakeImage, (int)blueSnakeXPosition - GameState.xOffset, (int)blueSnakeYPosition - GameState.yOffset, 64, 64, null);
    
    }
    
}
