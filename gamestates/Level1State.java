/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import mindquest.entities.BlueSnake;
import mindquest.entities.Player;
import mindquest.entities.PurpleGoblin;
import mindquest.entities.RedSnake;
import mindquest.entities.Wizard;
import mindquest.objects.Background;
import mindquest.objects.Block;
import mindquest.objects.Brick;
import mindquest.sounds.Sounds;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class Level1State extends GameState {
    
    // Declares objects, arrays and variables
    
    private ImageIcon backgroundImageIcon;
    private Image backgroundImage;
    
    private Sounds level1Music;
    
    private Background[] background;
    
    // Declares an array of Block objects
    
    private Block[] block;
    
    // Declares an array of Brick objects
    
    private Brick[] brick;
    
    // Declares a Player object named player
    
    private Player player;
    
    //Declares an integer variable called playerLives
    
    private int playerLives;
    
    // Declares a Wizard object named wizard
    
    private Wizard wizard;
    
    // Declares a Purplegoblin object named purpleGoblin
    
    private PurpleGoblin purpleGoblin;
    
    // Declares an ArrayList of RedSnake objects
    
    public ArrayList<RedSnake> redSnakes;
    
    // Declares an ArrayList of BlueSnake objects
    
    public ArrayList<BlueSnake> blueSnakes;
    
    // Declares x and y positions of the various objects in the level
    
    private int backgroundXPosition;
    private int backgroundYPosition;
    
    private int blockXPosition;
    private int blockYPosition;
    
    private int brickXPosition;
    private int brickYPosition;
    
    private double purpleGoblinXPosition;
    private double purpleGoblinYPosition;
    
    private double redSnakeXPosition;
    private double redSnakeYPosition;
    
    private double blueSnakeXPosition;
    private double blueSnakeYPosition;
    
    // Level1State Constructor
    
    public Level1State(GameStateManager gameStateManager) {
        
        super(gameStateManager);
        
        backgroundImageIcon = new ImageIcon("src/mindquest/images/background.png");
        backgroundImage = backgroundImageIcon.getImage();
        
        level1Music = new Sounds("Level1Music");
        level1Music.loop();
    
    }

    public void init() {
        
        // Creates an array of Background objects
        
        background = new Background[6];
        
        backgroundXPosition = 0;
        backgroundYPosition = 0;
        
        // This for loop iterates through the ArrayList of Background objects and updates the x position by 1024
        
        for(int i = 0; i < background.length; i++) {
            
            background[i] = new Background(backgroundXPosition, backgroundYPosition);
            backgroundXPosition = backgroundXPosition + 1024;
            
        }
        
        // Creates an array of Block objects
        
        block = new Block[96];
        
        blockXPosition = 0;
        blockYPosition = 704;
        
        // This for loop iterates through the ArrayList of Block objects and updates the x position by 64
        
        for(int i = 0; i < block.length; i++) {
            
            block[i] = new Block(blockXPosition, blockYPosition);
            blockXPosition = blockXPosition + 64;
            
        }
        
        // Creates an array of Brick objects
        
        brick = new Brick[16];
        
        brickXPosition = 1152;
        brickYPosition = 448;
        
        // This for loop iterates through the ArrayList of Brick objects and updates the x position by 256
        
        for(int i = 0; i < brick.length; i++) {
            
            brick[i] = new Brick(brickXPosition, brickYPosition);
            brickXPosition = brickXPosition + 256;
            
        }
        
        // Creates a new Player object
        
        player = new Player();
        
        // Creates a new Wizard object
        
        wizard = new Wizard();
        
        // Creates a new Purplegoblin object and passes in 2 parameters to the constructor setting the x and y positions of the object
        
        purpleGoblin = new PurpleGoblin(5952, 576);
        
        // Creates an ArrayList of RedSnake objects
        
        redSnakes = new ArrayList<RedSnake>();
        
        // Sets the x and y positions of the redSnake objects
        
        redSnakeXPosition = 500;
        redSnakeYPosition = 640;
        
        // This for loop iterates through the ArrayList of RedSnake objects and updates the x position by 500
        
        for(int i = 0; i < 5; i++) {
            
            redSnakeXPosition = redSnakeXPosition + 500;
            
            redSnakes.add(new RedSnake(redSnakeXPosition, redSnakeYPosition));
            
        }
        
        // Creates an ArrayList of BlueSnake objects
        
        blueSnakes = new ArrayList<BlueSnake>();
        
        // Sets the x and y positions of the blueSnake objects
        
        blueSnakeXPosition = 1000;
        blueSnakeYPosition = 640;
        
        // This for loop iterates through the ArrayList of BlueSnake objects and updates the x position by 750
        
        for(int i = 0; i < 5; i++) {
            
            blueSnakeXPosition = blueSnakeXPosition + 750;
            
            blueSnakes.add(new BlueSnake(blueSnakeXPosition, blueSnakeYPosition));
            
        }
        
    }
    
    public void update() {
        
        for(int i = 0; i < block.length; i++) {
            
            block[i].update();
        
        }
        
        for(int i = 0; i < brick.length; i++) {
            
            brick[i].update();
        
        }
        
        for(int i = 0; i < redSnakes.size(); i++) {
            
            redSnakes.get(i).update();
            
        }
        
        for(int i = 0; i < blueSnakes.size(); i++) {
            
            blueSnakes.get(i).update();
            
        }
        
        player.update(block);
        
        // If statement checks if the player's y position is greater than 768
        
        if(player.getPlayerYPosition() > 768) {
            
            // If this condition is true the player object calls the deductPlayerLives() and setPlayerPosition() methods
            // This would apply when we create a level that there are holes that the player could fall into resulting in them dying, deducting 1 of their lives and then resetting their position on the screen
            
            player.deductPlayerLives();
            player.setPlayerPosition();
            
        }
        
        // The code in the for loop below iterates through the ArrayList of BlueSnake objects and calls the update() method passing in the x and y positions of the player object
        // This is used as a form of simple AI to allow the enemy objects to follow the player object
        // It is not implemented yet
        
        /**for(int i = 0; i < blueSnakes.size(); i++) {
            
            blueSnakes.get(i).update(player.getPlayerXPosition(), player.getPlayerYPosition());
            
        }**/
        
        // If statement checks if the player has no lives left
        
        if(player.getPlayerLives() == 0) {
            
            // When the player has no lives remaining this code creates a new instance of the GameOverState class, passes in "this" GameStateManager object named gameStateManager and then adds it to the top of the Stack named states.
            
            gameStateManager.states.pop();
            level1Music.stop();
            gameStateManager.states.push(new GameOverState(gameStateManager));
            
        }
        
    }

    public void draw(Graphics g) {
        
        for(int i = 0; i < background.length; i++) {
            
            background[i].draw(g);
            
        }
        
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        playerLives = player.getPlayerLives();
        g.setColor(Color.white);
        g.drawString("Lives: " + playerLives, 25, 40);
        
        // This for loop iterates through the Arraylist of Block objects and calls the draw() method for each of them
        
        for(int i = 0; i < block.length; i++) {
            
            block[i].draw(g);
            
        }
        
        // This for loop iterates through the Arraylist of Brick objects and calls the draw() method for each of them
        
        for(int i = 0; i < brick.length; i++) {
            
            brick[i].draw(g);
            
        }
        
        // Calls the draw method in the Player class
        
        player.draw(g);
        
        // Calls the draw method in the Wizard class
        
        wizard.draw(g);
        
        // Calls the draw method in the PurpleGoblin class
        
        purpleGoblin.draw(g);
        
        // This for loop iterates through the Arraylist of RedSnake objects and calls the draw() method for each of them
        
        for(int i = 0; i < redSnakes.size(); i++) {
            
            redSnakes.get(i).draw(g);
            
        }
        
        // This for loop iterates through the Arraylist of BlueSnake objects and calls the draw() method for each of them
        
        for(int i = 0; i < blueSnakes.size(); i++) {
            
            blueSnakes.get(i).draw(g);
            
        }
        
    }

    public void keyPressed(int keyCode) {
        
        //System.out.println("Level1State Key Pressed");
        
        // Calls the keyPressed method in the Player class and passes in 1 int parameter named keyCode
        
        player.keyPressed(keyCode);
        
        if(keyCode == KeyEvent.VK_P) {
            
            level1Music.stop();
            
            // Creates a new instance of the PauseState class, passes in "this" GameStateManager object named gameStateManager and then adds it to the top of the Stack named states
            
            gameStateManager.states.push(new PauseState(gameStateManager));
            
        }
        
        if(keyCode == KeyEvent.VK_D) {
        
            player.deductPlayerLives();
        
        }
        
    }
    
    public void keyReleased(int keyCode) {
        
        //System.out.println("Level1State Key Released");
    
        // Calls the keyReleased method in the Player class and passes in 1 int parameter named keyCode
        
        player.keyReleased(keyCode);
        
    }
    
    // This method is not used in this class but has to be implemented as part of the KeyListener class
    
    public void keyTyped(int keyCode) {
    
        //No code required
    
    }
    
}
