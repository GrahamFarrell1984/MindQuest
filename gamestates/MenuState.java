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
import mindquest.sounds.Sounds;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class MenuState extends GameState {
    
    // Declares objects, arrays and variables
    
    private ImageIcon startMenuBackgroundImageIcon;
    private Image startMenuBackgroundImage;
    
    private Sounds menuMusic;
    
    private String[] options = {"Start New Game", "Credits", "Help", "Quit"};
    
    private int currentSelection = 0;
    
    int stringWidth;
    int stringXCoordinate;
    
    // MenuState Constructor
    
    public MenuState(GameStateManager gameStateManager) {
        
        super(gameStateManager);
        
        startMenuBackgroundImageIcon = new ImageIcon("src/mindquest/images/mindquest_pyramid_background.png");
        startMenuBackgroundImage = startMenuBackgroundImageIcon.getImage();
        
        menuMusic = new Sounds("MenuMusic");
        menuMusic.loop();
        
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
        
        g.drawImage(startMenuBackgroundImage, 0, 0, null);
    
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
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        FontMetrics fontMetrics2 = g.getFontMetrics();
        
        String copyrightString = "Copyright RetroBit Games Ltd 2018";
        g.setColor(Color.BLACK);
        stringWidth = fontMetrics2.stringWidth(copyrightString);
        stringXCoordinate = 1024 / 2 - stringWidth / 2;
        g.drawString(copyrightString, stringXCoordinate, 750);
        
    }
    
    public void keyPressed(int keyCode) {
        
        //System.out.println("MenuState Key Pressed"); 
   
        if(keyCode == KeyEvent.VK_DOWN) {
            
            currentSelection++;
            
            if(currentSelection >= options.length) {
                
                currentSelection = 0;
                
            }
            
        }
        
        else if(keyCode == KeyEvent.VK_UP) {
            
            currentSelection--;
            
            if(currentSelection < 0) {
                
                currentSelection = options.length - 1;
                
            }
            
        }
        
        if(keyCode == KeyEvent.VK_ENTER) {
            
            if(currentSelection == 0) {
                
                menuMusic.stop();
                gameStateManager.states.push(new Level1State(gameStateManager));
                
            }
            
            else if(currentSelection == 1) {
                
                gameStateManager.states.push(new CreditsState(gameStateManager));
                
            }
            
            else if(currentSelection == 2) {
                
                gameStateManager.states.push(new HelpState(gameStateManager));
                
            }
            
            else if(currentSelection == 3) {
                
                System.exit(0);
                
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
