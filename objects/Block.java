/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import mindquest.gamestates.GameState;


/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class Block extends Rectangle {
    
    private double blockXPosition, blockYPosition;
    
    private ImageIcon brownRockImageIcon;
    private Image brownRockImage;
    
    private Rectangle blockRectangle;
    
    public static final double BLOCK_SIZE = 64;
    
    // Block Constructor
    
    public Block(double blockXPosition, double blockYPosition) {
        
        this.blockXPosition = blockXPosition;
        this.blockYPosition = blockYPosition;
        
        brownRockImageIcon = new ImageIcon("src/mindquest/images/zombie_block_grass_64px.png");
        brownRockImage = brownRockImageIcon.getImage();
        
        //blockRectangle = new Rectangle((int)blockXPosition, (int)blockYPosition, (int)BLOCK_SIZE, (int)BLOCK_SIZE);
        //System.out.println("Constructing Block Rectangle Coordinates: " + blockXPosition + "," + blockYPosition + "," + BLOCK_SIZE + "," + BLOCK_SIZE);
        
    }
    
    public void update() {
        
        //blockRectangle = new Rectangle((int)blockXPosition, (int)blockYPosition, (int)BLOCK_SIZE, (int)BLOCK_SIZE);
        //System.out.println("Updating Block Rectangle Coordinates: " + blockXPosition + "," + blockYPosition + "," + BLOCK_SIZE + 1 + "," + BLOCK_SIZE + 1);
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(brownRockImage, (int)blockXPosition - GameState.xOffset, (int)blockYPosition - GameState.yOffset, (int)BLOCK_SIZE, (int)BLOCK_SIZE, null);
        
    }
    
}
