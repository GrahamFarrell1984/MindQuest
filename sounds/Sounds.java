/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.sounds;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class Sounds {
    
    Clip clip;
    
    String state;
    
    public Sounds(String state) {
        
        this.state = state;
        
        // The String that is passed to the Sounds class constructor from the class that is calling it will determine what music gets played
        
        if(state.equals("MenuMusic")) {
            
            try {
            
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/mindquest/sounds/menu.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            
            }
            
            catch(Exception e) {
                
                e.printStackTrace();
            
            }
            
        }
        
        else if(state.equals("Level1Music")) {
            
            try {
            
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/mindquest/sounds/level1.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            
            }
            
            catch(Exception e) {
                
                e.printStackTrace();
            
            }
            
        }
        
        else if(state.equals("PauseMusic")) {
            
            try {
            
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/mindquest/sounds/gameover.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            
            }
            
            catch(Exception e) {
                
                e.printStackTrace();
            
            }
            
        }
        
        else if(state.equals("GameOverMusic")) {
            
            try {
            
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/mindquest/sounds/gameover.wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            
            }
            
            catch(Exception e) {
                
                e.printStackTrace();
            
            }
            
        }
    
    }
    
    public void play() {
        
        clip.start();
        
    }
    
    public void stop() {
        
        clip.stop();
        
    }
    
    public void loop() {
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        
    }
    
}
