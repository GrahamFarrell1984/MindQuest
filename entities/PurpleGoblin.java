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
public class PurpleGoblin {
    
    // Declare variables
    
    private ImageIcon purpleGoblinImageIcon;
    
    private Image purpleGoblinImage;
    
    private double purpleGoblinXPosition, purpleGoblinYPosition;
    
    // PurpleGoblin Constructor.
    // Takes 2 double parameters determining the x and y positions of the PurpleGoblin object.
    
    public PurpleGoblin(double purpleGoblinXPosition, double purpleGoblinYPosition) {
        
        this.purpleGoblinXPosition = purpleGoblinXPosition;
        this.purpleGoblinYPosition = purpleGoblinYPosition;
        
        purpleGoblinImageIcon = new ImageIcon("src/mindquest/entities/entity_images/dark_purple_goblin_left_69x72px.gif");
        purpleGoblinImage = purpleGoblinImageIcon.getImage();
        
    }
    
    // Methods
    
    public void update() {
        
        purpleGoblinXPosition = purpleGoblinXPosition - 1;
        
    }
    
    // This method takes the x and y positions of the player object and allows the enemy object to follow the player object
    // It is a form of simple AI
    // The method is not actually implemented at the moment
    
    public void update(double playerXPosition, double playerYPosition) {
        
        if(purpleGoblinXPosition > playerXPosition) {
            
            purpleGoblinXPosition = purpleGoblinXPosition - 0.1;
            
        }
        
        if(purpleGoblinXPosition < playerXPosition) {
            
            purpleGoblinXPosition = purpleGoblinXPosition + 0.1;
            
        }
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(purpleGoblinImage, (int)purpleGoblinXPosition - GameState.xOffset, (int)purpleGoblinYPosition - GameState.yOffset, 128, 128, null);
    
    }
    
}
