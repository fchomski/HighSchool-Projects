import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Level2 extends World
{
    //background image file
    private GreenfootImage background = new GreenfootImage("winterblue.jpg");
    //name of background
    private static final String bgImageName = "winterblue.jpg";
    //the speed at which the screen scrolls, MAKE PUBLIC? SEE BLOCKS CLASS
    private static final double scrollSpeed = 2.5;
    //holds the width of the background image
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();

    //bgImage holds the image of the background, bgBase holds the dimensions of the background
    private GreenfootImage bgImage, bgBase;
    //the scroll position starts at 0
    private int scrollPosition = 0;

    //hold the value of the width of one block
    public static final int WIDTH_OF_BLOCK = 25;

    //creates a scoreboard
    public Counter scoreboard;

    //the amount of lives the pig has left
    private int countLives;
    
    private Pig p;

    //creates lives
    public Lives lives;
    
    //keeps track whether we have already added the pig or not
    private boolean haveAddedPig;

    public Lives l = new Lives(1);
    public Lives l2 = new Lives(2);
    public Lives l3 = new Lives(3);
    public Lives l4 = new Lives(4);
    public Lives l5 = new Lives(5);

    public Level2(Pig pig)
    {
        super(1000,600,1);
        
        haveAddedPig = false;
        
        p = pig;
        
        //tells the levels what objects go in front of others
        setPaintOrder(Pig.class, GameOver.class, Blocks.class);

        //scales the background image to the size of the world
        background.scale(getWidth(),getHeight());
        //sets the bacground to the scaled image
        setBackground(background);
        //sets bgImage to the background
        bgImage = new GreenfootImage(getBackground());
        //sets bgBase to the dimenions of the background
        bgBase = new GreenfootImage(picWidth, getHeight());
        //draws the background onto bgBase
        bgBase.drawImage(bgImage, 0, 0);

        //starts with five lives
        countLives = 5;
        
        //adds hearts to world
        update();

        prepare();
    }

    /**
     * removeLives
     * Takes away from countLives and calls the update method (updates the heart images)
     * If lives get to 0 then add text saying Game Over and stop the game
     */
    public void removeLives()
    {
        //takes away a life
        countLives--;
        //removes the life
        update();
        //if lives gets to 0, game is over and displays gameover text in the middle of screen
        if(countLives == 0) {
            addObject(new GameOver(), getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }

    public void act()
    {
        if (haveAddedPig == false)
        {
             addObject(p, getWidth()/2, 520);
             scoreboard = new Counter();
             addObject(scoreboard, getWidth()-25, 20);
            
             haveAddedPig = true;
        }
        scrollPosition -= scrollSpeed;
        while(scrollSpeed>0 && scrollPosition < -picWidth) {
            scrollPosition += picWidth;
        }
        while(scrollSpeed<0 && scrollPosition>0) {
            scrollPosition -= picWidth;
        }
        //updates the background image
        paint(scrollPosition);
    }

    /**
     * paint
     * Sets the background image
     */
    private void paint(int position)
    {
        //paints the background of screen with the updated image
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }

    /**
     * addScore
     * Used by pig to add to the score
     */
    public void addScore()
    {
        //this method is used by the pig to add to the score
        scoreboard.update();
    }

    /**
     * getScore
     * Used to return the current score
     */
    public Counter getScore()
    {
        return scoreboard;
    }

    /**
     * update
     * Updates the heart images in top left corner of screen
     */
    public void update()
    {
        //creates a list of the Lives added to world
        List <Lives> lives = getObjects(Lives.class);
        //removes the hearts from the world
        removeObjects(lives);
        //add lives (hearts) to the top left hand corner of screen
        for(int i = 0; i < countLives; i++) {
            int x = 20 + (i*30);
            int y = 20;
            addObject(new Lives(i), x, y);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Blocks blocks = new Blocks(40);
        addObject(blocks, 757, 483);
        blocks.setLocation(501, 587);
        blocks.setLocation(500, 587);
        Blocks blocks2 = new Blocks(20);
        addObject(blocks2, 766, 497);
        blocks2.setLocation(525, 459);
        blocks2.setLocation(521, 461);
        Blocks blocks3 = new Blocks(10);
        addObject(blocks3, 789, 345);
        blocks3.setLocation(876, 328);
        Blocks blocks4 = new Blocks(10);
        addObject(blocks4, 595, 328);
        blocks4.setLocation(124, 330);
        blocks2.setLocation(499, 452);
        Ladder ladder = new Ladder(6);
        addObject(ladder, 601, 394);
        ladder.setLocation(739, 390);
        Ladder ladder2 = new Ladder(6);
        addObject(ladder2, 620, 253);
        ladder2.setLocation(261, 390);
        blocks4.setLocation(125, 327);
        blocks4.setLocation(124, 327);
        Blocks blocks5 = new Blocks(5);
        addObject(blocks5, 123, 520);
        blocks5.setLocation(183, 481);
        blocks5.setLocation(185, 478);
        Ladder ladder3 = new Ladder(1);
        addObject(ladder3, 637, 226);
        ladder3.setLocation(237, 450);
        blocks2.setLocation(499, 434);
        blocks4.setLocation(126, 301);
        blocks3.setLocation(874, 302);
        ladder.setLocation(737, 367);
        ladder2.setLocation(261, 366);
        blocks2.setLocation(499, 427);
        ladder3.setLocation(71, 511);
        removeObject(ladder3);
        blocks5.setLocation(62, 428);
        Ladder ladder4 = new Ladder(7);
        addObject(ladder4, 238, 482);
        ladder4.setLocation(136, 504);
        removeObject(ladder4);
        Ladder ladder5 = new Ladder(8);
        addObject(ladder5, 256, 491);
        ladder5.setLocation(138, 515);
        Blocks blocks6 = new Blocks(6);
        addObject(blocks6, 209, 432);
        removeObject(blocks6);
        Blocks blocks7 = new Blocks(5);
        addObject(blocks7, 409, 488);
        blocks7.setLocation(213, 428);
        blocks7.setLocation(211, 427);
        blocks7.setLocation(213, 427);
        Blocks blocks8 = new Blocks(30);
        addObject(blocks8, 523, 189);
        blocks8.setLocation(508, 120);
        Portal2 portal2 = new Portal2();
        addObject(portal2, 485, 59);
        portal2.setLocation(185, 59);
        Ladder ladder6 = new Ladder(12);
        addObject(ladder6, 822, 267);
        ladder6.setLocation(896, 194);
        removeObject(ladder6);
        Ladder ladder7 = new Ladder(9);
        addObject(ladder7, 918, 171);
        ladder7.setLocation(896, 220);
        Blocks blocks9 = new Blocks(30);
        addObject(blocks9, 547, 231);
        blocks9.setLocation(507, 213);
        blocks9.setLocation(507, 193);
        blocks9.setLocation(508, 181);
        blocks8.setLocation(508, 75);
        blocks8.setLocation(508, 79);
        blocks9.setLocation(508, 187);
        removeObject(blocks9);
        blocks8.setLocation(508, 120);
        portal2.setLocation(189, 62);
        Magnet magnet = new Magnet();
        addObject(magnet, 484, 337);
        Coins coins = new Coins();
        addObject(coins, 491, 251);
        Coins coins2 = new Coins();
        addObject(coins2, 546, 265);
        Coins coins3 = new Coins();
        addObject(coins3, 586, 298);
        Coins coins4 = new Coins();
        addObject(coins4, 433, 259);
        Coins coins5 = new Coins();
        addObject(coins5, 383, 298);
        Coins coins6 = new Coins();
        addObject(coins6, 39, 250);
        Coins coins7 = new Coins();
        addObject(coins7, 964, 247);
        Coins coins8 = new Coins();
        addObject(coins8, 57, 370);
        Coins coins9 = new Coins();
        addObject(coins9, 60, 513);
        Magnet magnet2 = new Magnet();
        addObject(magnet2, 869, 501);
        Coins coins10 = new Coins();
        addObject(coins10, 873, 398);
        Coins coins11 = new Coins();
        addObject(coins11, 985, 508);
        Coins coins12 = new Coins();
        addObject(coins12, 756, 500);
        Coins coins13 = new Coins();
        addObject(coins13, 399, 78);
        Coins coins14 = new Coins();
        addObject(coins14, 575, 77);
        Coins coins15 = new Coins();
        addObject(coins15, 765, 78);
        coins6.setLocation(48, 250);
        coins8.setLocation(51, 371);
        coins9.setLocation(58, 513);
        coins11.setLocation(980, 500);
        coins12.setLocation(796, 398);
        coins11.setLocation(958, 407);
        coins10.setLocation(873, 407);
        coins12.setLocation(798, 405);
        coins11.setLocation(958, 408);
        coins10.setLocation(873, 406);
        coins12.setLocation(799, 407);
        coins10.setLocation(873, 407);
        coins7.setLocation(959, 247);
        coins15.setLocation(765, 69);
        coins14.setLocation(576, 67);
        coins13.setLocation(395, 66);
        coins14.setLocation(574, 64);
        coins15.setLocation(766, 64);
        coins15.setLocation(766, 65);
        coins6.setLocation(51, 250);
        Knight knight3 = new Knight();
        addObject(knight3, 484, 391);
        knight3.setLocation(485, 394);
    }
}
