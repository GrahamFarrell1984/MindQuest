/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class HelpState extends GameState {
    
    // Declares objects, arrays and variables
    
    private ImageIcon helpBackgroundImageIcon;
    private Image helpBackgroundImage;
    
    private String[] options = {"Back To Main Menu"};
    private String[] instructions = {"Move Right - Right Arrow. Move Left - Left Arrow", "Move Up - Up Arrow. Move Down - Down Arrow", "Jump - Space Bar. T - Talk", "Pause - P"};
    
    private int currentSelection = 0;
    
    int stringWidth;
    int stringXCoordinate;
    
    // HelpState Constructor
    
    public HelpState(GameStateManager gameStateManager) {
        
        super(gameStateManager);
        
        helpBackgroundImageIcon = new ImageIcon("src/mindquest/images/mindquest_pyramid_background.png");
        helpBackgroundImage = helpBackgroundImageIcon.getImage();
        
    }

    // This method is not used in this class but has to be implemented as part of the GameState class.

    public void init() {
    
        // No code required
    
    }
    
    // This method is not used in this class but has to be implemented as part of the GameState class.

    public void update() {

        // No code required
    
    }

    public void draw(Graphics g) {
        
        // Draws the background image
        // Draws the Strings in the options array
        // Sets their font, size, colours and their positioning on the screen
        // Loops through String array to see what string is currently selected
        // Sets currently selected String to white and all unselected Strings to black
        
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        
        FontMetrics fontMetrics = g.getFontMetrics();
        
        g.drawImage(helpBackgroundImage, 0, 0, null);
    
        for(int i = 0; i < options.length; i++) {
            
            if(i == currentSelection) {
                
                g.setColor(Color.WHITE);
                
            }
            
            else {
                
                g.setColor(Color.BLACK);
                
            }
            
            stringWidth = fontMetrics.stringWidth(options[i]);
            stringXCoordinate = 1024 / 2 - stringWidth / 2;
            g.drawString(options[i], stringXCoordinate, 575 + i * 40);
            
        }
        
        String helpString = "Help";
        g.setColor(Color.BLACK);
        stringWidth = fontMetrics.stringWidth(helpString);
        stringXCoordinate = 1024 / 2 - stringWidth / 2;
        g.drawString(helpString, stringXCoordinate, 575 + 1 * 40);
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        FontMetrics fontMetrics2 = g.getFontMetrics();
        
        for(int i = 0; i < instructions.length; i++) {
            
            stringWidth = fontMetrics2.stringWidth(instructions[i]);
            stringXCoordinate = 1024 / 2 - stringWidth / 2;
            g.drawString(instructions[i], stringXCoordinate, 650 + i * 25);
            
        }
        
        String copyrightString = "Copyright RetroBit Games Ltd 2018";
        g.setColor(Color.BLACK);
        stringWidth = fontMetrics2.stringWidth(copyrightString);
        stringXCoordinate = 1024 / 2 - stringWidth / 2;
        g.drawString(copyrightString, stringXCoordinate, 750);
    
    }
    
    public void keyPressed(int keyCode) {
    
        if(keyCode == KeyEvent.VK_ENTER) {
            
            if(currentSelection == 0) {
                
                gameStateManager.states.pop();
                
            }
            
        }
    
    }

    // This method is not used in this class but has to be implemented as part of the KeyListener class.

    public void keyReleased(int keyCode) {
    
        // No code required
    
    }
    
    // This method is not used in this class but has to be implemented as part of the KeyListener class.
    
    public void keyTyped(int keyCode) {
    
        // No code required
    
    }
    
}
