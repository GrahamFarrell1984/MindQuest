/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindquest.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import mindquest.GamePanel;
import mindquest.gamestates.GameState;
import mindquest.objects.Block;

/**
 * @authors
 * @author graham farrell
 * @author dominic dillon
 * @author craig shiels
 * @author enkhbayar dashtseren
 */
public class Player extends Rectangle {
    
    // Declare variables
    private Rectangle playerRectangle;
    
    private ImageIcon playerImageIcon;
    
    private Image playerImage;
    
    private int playerLives;
    
    private boolean up, down, left, right, jumping, falling;
    
    private double playerXPosition, playerYPosition;
    
    private int playerWidth, playerHeight;
    
    private double jumpSpeed;
    private double currentJumpSpeed;
    
    private double maxFallSpeed;
    private double currentFallSpeed;
    
    private double playerXDirection;
    private double playerYDirection;
    
    private boolean bottomCollision;
    
    // Player Constructor that doesn't take in any parameters
    
    public Player() {
        
        playerImageIcon = new ImageIcon("src/mindquest/entities/entity_images/ninja.png");
        playerImage = playerImageIcon.getImage();
        
        playerLives = 3;
        
        up = false;
        down = false;
        left = false;
        right = false;
        jumping = false;
        falling = false;
        
        playerXPosition = 128;
        playerYPosition = 640;
        
        playerXDirection = 0;
        playerYDirection = 0;
        
        playerWidth = 64;
        playerHeight = 64;
        
        jumpSpeed = 8;
        currentJumpSpeed = jumpSpeed;
        
        maxFallSpeed = 6;
        currentFallSpeed = 0.5;
        
        //playerRectangle = new Rectangle((int)playerXPosition, (int)playerYPosition, (int)playerWidth, (int)playerHeight);
        //System.out.println("Constructing Player Rectangle Coordinates: " + playerXPosition + "," + playerYPosition + "," + playerWidth + "," + playerHeight);
        
    }
    
    public void update(Block[] block) {
        
        // If statement checks the y position of the player object so that it can't go any higher than 639 to make the player walk on top of the blocks at the bottom of the level
        // this is a form of collision detection
        
        if(playerYPosition > 639) {
            
            falling = false;
            playerYPosition = 640;
        
        }
        
        // If statements check if the left arrow is pressed and if the player object is in a position that is less than the centre of the screen
        // Then depending on the value of the xOffset it moves the background
        
        if(left) {
            
            if(playerXPosition < GamePanel.WIDTH / 2 - playerWidth / 2) {
                
                if(GameState.xOffset == 0) {
                    
                    GameState.xOffset = 0;
                
                }
                
                if(GameState.xOffset > 0) {
                    
                    GameState.xOffset--;
                
                }
                
            }
            
            if(playerXPosition == GamePanel.WIDTH / 2 - playerWidth / 2) {
                
                playerXPosition--;
                
            }
            
            if(playerXPosition > GamePanel.WIDTH / 2 - playerWidth / 2) {
                
                if(GameState.xOffset == 5120) {
                
                GameState.xOffset = 5120;
                playerXPosition--;
            
            }
                
            }
            
        }
        
        // If statements check if the right arrow is pressed and if the player object is in a position that is less than the centre of the screen or in the centre of the screen
        // Then depending on the value of the xOffset it moves the background
        
        if(right) {
            
            if(playerXPosition < GamePanel.WIDTH / 2 - playerWidth / 2) {
                
                playerXPosition++;
                
            }
            
            if(playerXPosition == GamePanel.WIDTH / 2 - playerWidth / 2) {
                
            
                if(GameState.xOffset < 5120) {
                
                    GameState.xOffset++;
                
                }
                
            }
            
            if(GameState.xOffset == 5120) {
                
                GameState.xOffset = 5120;
                playerXPosition++;
            
            }
            
        }
        
        if(jumping) {
            
            playerYPosition = playerYPosition - currentJumpSpeed;
            currentJumpSpeed = currentJumpSpeed - 0.1;
            
            if(currentJumpSpeed <= 0) {
                
                currentJumpSpeed = jumpSpeed;
                falling = true;
                
            }
            
        }
        
        if(falling) {
            
            jumping = false;
            
            playerYPosition = playerYPosition + currentJumpSpeed;
                
                if(currentFallSpeed < maxFallSpeed) {
                    
                    currentFallSpeed = currentFallSpeed + 6;
                
                }
        
        }
        
        if(!falling) {
            
            currentFallSpeed = 0.1;
            
        }
        
    }

    public void draw(Graphics g) {
    
        g.drawImage(playerImage, (int)playerXPosition, (int)playerYPosition, 64, 64, null);
        
    }
    
    public void keyPressed(int keyCode) {
    
        if(keyCode == KeyEvent.VK_UP) {
        
            up = true;
            //System.out.println("Player Up Key Pressed");
        
        }
        
        if(keyCode == KeyEvent.VK_DOWN) {
        
            down = true;
            //System.out.println("Player Down Key Pressed");
            
        }
        
        if(keyCode == KeyEvent.VK_LEFT) {
        
            left = true;
            //System.out.println("Player Left Key Pressed");
        
        }
        
        if(keyCode == KeyEvent.VK_RIGHT) {
        
            right = true;
            //System.out.println("Player Right Key Pressed");
        
        }
        
        if(keyCode == KeyEvent.VK_SPACE) {
        
            jumping = true;
            //System.out.println("Player Space Key Pressed");
        
        }
    
    }

    public void keyReleased(int keyCode) {
    
        if(keyCode == KeyEvent.VK_UP) {
        
            up = false;
            //System.out.println("Player Up Key Released");
        
        }
        
        if(keyCode == KeyEvent.VK_DOWN) {
        
            down = false;
            //System.out.println("Player Down Key Released");
        
        }
        
        if(keyCode == KeyEvent.VK_LEFT) {
        
            left = false;
            //System.out.println("Player Left Key Released");
        
        }
        
        if(keyCode == KeyEvent.VK_RIGHT) {
        
            right = false;
            //System.out.println("Player Right Key Released");
        
        }
        
        if(keyCode == KeyEvent.VK_SPACE) {
        
            jumping = false;
            falling = true;
            //System.out.println("Player Space Key Released");
        
        }
        
    }
    
    // This method is not used in this class but has to be implemented as part of the KeyListener class
    
    public void keyTyped(int keyCode) {
    
        // No code required
        
    }

    public void setPlayerPosition() {
        
        playerXPosition = 256;
        playerYPosition = 640;
        
    }
    
    public double getPlayerXPosition() {
        
        return playerXPosition;
        
    }
    
    public double getPlayerYPosition() {
        
        return playerYPosition;
        
    }
    
    public int getPlayerLives() {
        
        return playerLives;
        
    }
    
    public void deductPlayerLives() {
        
        playerLives --;
        
    }
    
}
