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
public class Brick extends Rectangle {
    
    private double brickXPosition, brickYPosition;
    
    private ImageIcon greyBrickImageIcon;
    private Image greyBrickImage;
    
    private Rectangle greybrickRectangle;
    
    public static final double BRICK_SIZE = 64;
    
    // Brick Constructor
    
    public Brick(double brickXPosition, double brickYPosition) {
        
        this.brickXPosition = brickXPosition;
        this.brickYPosition = brickYPosition;
        
        greyBrickImageIcon = new ImageIcon("src/mindquest/images/flashing_question_mark_block_32x32px.gif");
        greyBrickImage = greyBrickImageIcon.getImage();
        
        //greybrickRectangle = new Rectangle((int)brickXPosition, (int)brickYPosition, (int)BRICK_SIZE, (int)BRICK_SIZE);
        //System.out.println("Constructing Block Rectangle Coordinates: " + blockXPosition + "," + blockYPosition + "," + BLOCK_SIZE + "," + BLOCK_SIZE);
        
    }
    
    public void update() {
        
        //blockRectangle = new Rectangle((int)blockXPosition, (int)blockYPosition, (int)BLOCK_SIZE, (int)BLOCK_SIZE);
        //System.out.println("Updating Block Rectangle Coordinates: " + blockXPosition + "," + blockYPosition + "," + BLOCK_SIZE + 1 + "," + BLOCK_SIZE + 1);
        
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(greyBrickImage, (int)brickXPosition - GameState.xOffset, (int)brickYPosition - GameState.yOffset, (int)BRICK_SIZE, (int)BRICK_SIZE, null);
        
    }
    
}
