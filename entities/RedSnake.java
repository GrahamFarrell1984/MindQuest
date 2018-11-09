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
public class RedSnake {
    
    // Declare variables
    
    private ImageIcon redSnakeImageIcon;
    
    private Image redSnakeImage;
    
    private double redSnakeXPosition, redSnakeYPosition;
    
    // RedSnake Constructor
    // Takes 2 double parameters determining the x and y positions of the RedSnake object
    
    public RedSnake(double redSnakeXPosition, double redSnakeYPosition) {
        
        this.redSnakeXPosition = redSnakeXPosition;
        this.redSnakeYPosition = redSnakeYPosition;
        
        redSnakeImageIcon = new ImageIcon("src/mindquest/entities/entity_images/red_snake_left_17x22px.png");
        redSnakeImage = redSnakeImageIcon.getImage();
        
    }
    
    // Methods
    
    public void update() {
        
        redSnakeXPosition = redSnakeXPosition - 1;
        
    }
    
    // This method takes the x and y positions of the player object and allows the enemy object to follow the player object
    // It is a form of simple AI
    // The method is not actually implemented at the moment
    
    public void update(double playerXPosition, double playerYPosition) {
        
        if(redSnakeXPosition > playerXPosition) {
            
            redSnakeXPosition = redSnakeXPosition - 1;
            
        }
        
        if(redSnakeXPosition < playerXPosition) {
            
            redSnakeXPosition = redSnakeXPosition + 1;
            
        }
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(redSnakeImage, (int)redSnakeXPosition - GameState.xOffset, (int)redSnakeYPosition - GameState.yOffset, 64, 64, null);
    
    }
    
}
