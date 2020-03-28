import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Pig extends Actor
{
    //all the image files (only necassary because they have to be scaled)
    private GreenfootImage pig1 = new GreenfootImage("pig1.png");
    private GreenfootImage pigflip = new GreenfootImage("pig1flipped.png");

    //the speed at which the pig moves at
    private int speed = 3;
    //used so pig doesnt shoot continuous water
    private int countWater = 0;
    //keeps track of the current level
    private int levelCount;

    //used to make the pig fall when not touching a block
    private static final int GRAVITY = 5;

    //keeps track of the direction the pig is facing for image purposes
    private boolean facingRight;

    //create a counter called myScore
    private Counter myScore;

    public Pig(String s, Counter c)
    {
        myScore = c;
        
        //scales the pig images
        pig1.scale(100,100);
        pigflip.scale(100,100);

        levelCount = 1;
        
        setImage(pig1);
        facingRight = true;
    }

    public Counter getScore()
    {
        return myScore;
    }

    public void act() 
    {
        movement();
        coins();
        magnets();
        ladders();
        switchLevels();
        die();
    }    

    /**
     * movement
     * When left arrow is pressed, move left
     * When right arrow is pressed, move right
     * When space is pressed, shoot blue dots used to kill Knights
     */
    private void movement()
    {
        //allows character to move left, right, up, and down
        if(Greenfoot.isKeyDown("left")) {
            setImage(pigflip);
            setLocation(getX()-speed, getY());
        }
        if(Greenfoot.isKeyDown("right")) {
            setImage(pig1);
            setLocation(getX()+speed, getY());
        }
        //shoots blue dots if the space key is down
        if(Greenfoot.isKeyDown("space")) {
            if(countWater == 0) {
                if(getImage() == pig1) {
                    Actor dot = new Water(5);
                    getWorld().addObject(dot, getX(), getY());
                } 
                if(getImage() == pigflip){
                    Actor dot = new Water(-5);
                    getWorld().addObject(dot, getX(), getY());
                }
            }
            countWater++;
            if(countWater == 10) {
                countWater = 0;
            }
        } else {
            countWater = 0;
        }
    }

    /**
     * coins
     * Collects coins and adds to score
     */
    private void coins()
    {
        //if touching a coin, add to score and remove coin from world
        Coins c = (Coins)getOneIntersectingObject(Coins.class);
        if(c != null) {
            if(levelCount == 1) {
                Level1 world = (Level1)getWorld();
                world.addScore();
                world.removeObject(c);
            } else if(levelCount == 2) {
                Level2 world2 = (Level2)getWorld();
                world2.addScore();
                world2.removeObject(c);
            } else if(levelCount == 3) {
                Level3 world3 = (Level3)getWorld();
                world3.addScore();
                world3.removeObject(c);
            }
        }
    }

    /**
     * magnets
     * Picks up magnets
     * If picks up magnet starts a counter so the magnet lasts for 1000 iterations
     * During these 1000 iterations picks up coins in 200 pixel radius of pig
     */
    private void magnets()
    {
        Magnet m = (Magnet)getOneIntersectingObject(Magnet.class);
        if(m != null) {
            //creates a list of the coins in a 200 pixel radius of pig after picking up magnet
            List <Coins> coinsInRange = getObjectsInRange(200,Coins.class);
            //for each coins in the list, add to score and remove it from the world
            for(Coins coin : coinsInRange) {
                //makes coins move towards center of magnet (see coin class)
                coin.activateMagnet();
            }
        }
    }

    private void fall()
    {
        //if not touching block, fall (aka add gravity)
        Blocks b = (Blocks)getOneObjectAtOffset(0,40, Blocks.class);
        if(b != null) {

        } else {
            setLocation(getX(), getY() + GRAVITY);
        }
    }

    /**
     * ladders
     * If up key is pressed AND at a ladder then climb it
     */
    private void ladders()
    {
        //if up key is pressed, and at a ladder, climb the ladder
        Ladder l = (Ladder)getOneIntersectingObject(Ladder.class);
        if(Greenfoot.isKeyDown("up") && l != null) {
            setLocation(getX(), getY()-speed);
        } else {
            fall();
        }
    }
    
    /**
     * switchLevels
     * If pig gets to portal, switch to the next level
     */
    private void switchLevels()
    {
        //if at portal on first level, switch to second level
        if(isTouching(Portal.class)) {
            levelCount = 2;
            Greenfoot.setWorld(new Level2(this));
        }
        //if at a portal on the second level, switch to third level
        if(isTouching(Portal2.class)) {
            levelCount = 3;
            Greenfoot.setWorld(new Level3(this));
        }
        //if at a portal in level 3, diplay "You Win" and the final score
        if(isTouching(Portal3.class) && levelCount == 3) {
            getWorld().addObject(new Win(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }

    /**
     * die
     * If touches a knight, bounces back 100 pixels
     * Removes hearts from the top of screen (removes from countLives too!)
     * If lives get to 0 then display game over
     */
    private void die()
    {
        //if touching a knight...
        Knight k = (Knight)getOneIntersectingObject(Knight.class);
        if(k != null) {
            //moves pig back 100 pixels if hit by knight
            //if facing right: moves it back 100 pixels to the right, if facing left: moves it back 100 pixels left
            if(facingRight) {
                setLocation(getX()-100, getY());
            } else {
                setLocation(getX()+100, getY());
            }
            //take away lives everytime it touches a knight
            if(levelCount == 1) {
                Level1 w = (Level1)getWorld();
                w.removeLives();
            } else if(levelCount == 2) {
                Level2 w2 = (Level2)getWorld();
                w2.removeLives();
            } else if(levelCount == 3) {
                Level3 w3 = (Level3)getWorld();
                w3.removeLives();
            }
        }       
    }
}