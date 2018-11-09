/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class MindQuest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // The line of code below declares and creates a new JFrame object named gameFrame and sets the title to MindQuest
        JFrame gameFrame = new JFrame("MindQuest");
        // The lines of code below set various properties of the JFrame object
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.add(new GamePanel(), BorderLayout.CENTER);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        
    }
    
}
