/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.objects;

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
public class Background {
    
    private double backgroundXPosition, backgroundYPosition;
    
    private ImageIcon backgroundImageIcon;
    private Image backgroundImage;
    
    // Background Constructor
    
    public Background(int backgroundXPosition, int backgroundYPosition) {
        
        this.backgroundXPosition = backgroundXPosition;
        this.backgroundYPosition = backgroundYPosition;
        
        backgroundImageIcon = new ImageIcon("src/mindquest/images/background.png");
        backgroundImage = backgroundImageIcon.getImage();
        
    }
    
    public void update() {
        
        //blockRectangle = new Rectangle((int)blockXPosition, (int)blockYPosition, (int)BLOCK_SIZE, (int)BLOCK_SIZE);
        //System.out.println("Updating Block Rectangle Coordinates: " + blockXPosition + "," + blockYPosition + "," + BLOCK_SIZE + 1 + "," + BLOCK_SIZE + 1);
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(backgroundImage, (int)backgroundXPosition - GameState.xOffset, (int)backgroundYPosition - GameState.yOffset, 1024, 768, null);
        
    }
    
}
