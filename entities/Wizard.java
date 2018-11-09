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
public class Wizard {
    
    private ImageIcon wizardImageIcon;
    
    private Image wizardImage;
    
    private int wizardXPosition, wizardYPosition;
    
    // Wizard Constructor
    
    public Wizard(){
        
        wizardImageIcon = new ImageIcon("src/mindquest/entities/entity_images/wizard.gif");
        wizardImage = wizardImageIcon.getImage();
        
        wizardXPosition = 0;
        wizardYPosition = 576;
    
    }
    
    public void draw(Graphics g) {
        
        g.drawImage(wizardImage, wizardXPosition - GameState.xOffset, wizardYPosition - GameState.yOffset, null);
    
    }
    
}
