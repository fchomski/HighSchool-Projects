import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Florencia Chomski
 * v2.0
 */
public class Level1 extends World
{
    //background image file
    private GreenfootImage background = new GreenfootImage("orange.jpg");
    //name of background
    private static final String bgImageName = "orange.jpg";
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
    
    //holds the pig in the worlds
    private Pig p = new Pig("pig1.png", scoreboard);

    //the amount of lives the pig has left
    private int countLives;
    
    //creates lives
    public Lives lives;

    public Level1()
    {
        super(1000,600,1);
        
        //play background music
        Greenfoot.playSound("achangeofheart.mp3");

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

        //adds stuff to the level
        buildWorld();
        prepare();
        //adds hearts to world
        update();
    }
    
    public Pig getPig()
    {
        return p;
    }

    /**
     * removeLives
     * Takes away lives and updates the hearts
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
     * buildWorld
     * Adds pig, scoreboard, hearts, blocks, coins, and ladders
     */
    private void buildWorld()
    {
        //adds Pig to bottom left hand side of screen
        addObject(p, 50, 420);

        //adds a scoreboard to the world
        scoreboard = new Counter();
        addObject(scoreboard, getWidth()-25, 20);

        //adding blocks
        addObject(new Blocks(80), 40, getHeight()-(WIDTH_OF_BLOCK/2)); //platform @ botom of screen
        addObject(new Blocks(40), 0, getHeight()-(5*WIDTH_OF_BLOCK));  //starting platform
        addObject(new Blocks(15), 815, getHeight()-(9*WIDTH_OF_BLOCK));
        addObject(new Blocks(60), 0, getHeight()-(20*WIDTH_OF_BLOCK));
        addObject(new Blocks(15), 450, getHeight()-(12*WIDTH_OF_BLOCK));
        addObject(new Blocks(9), getWidth() - 115, getHeight()-(20*WIDTH_OF_BLOCK));

        //adding coins
        addObject(new Coins(), 150, getHeight()-70);

        //adding ladders
        addObject(new Ladder(11), 615, 500);
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
        Ladder ladder = new Ladder(4);
        addObject(ladder, 798, 241);
        ladder.setLocation(648, 339);
        ladder.setLocation(649, 339);
        ladder.setLocation(650, 337);
        Blocks blocks = new Blocks(15);
        addObject(blocks, 783, 251);
        blocks.setLocation(188, 189);
        blocks.setLocation(189, 223);
        Ladder ladder3 = new Ladder(4);
        addObject(ladder3, 805, 328);
        ladder3.setLocation(389, 262);
        ladder3.setLocation(389, 261);
        Blocks blocks2 = new Blocks(20);
        addObject(blocks2, 753, 230);
        blocks2.setLocation(749, 215);
        blocks2.setLocation(751, 223);
        Ladder ladder4 = new Ladder(4);
        addObject(ladder4, 842, 275);
        ladder4.setLocation(490, 261);
        Coins coins = new Coins();
        addObject(coins, 662, 475);
        Coins coins2 = new Coins();
        addObject(coins2, 710, 439);
        Coins coins3 = new Coins();
        addObject(coins3, 774, 413);
        Coins coins4 = new Coins();
        addObject(coins4, 838, 415);
        Coins coins5 = new Coins();
        addObject(coins5, 890, 433);
        Coins coins6 = new Coins();
        addObject(coins6, 939, 465);
        Coins coins7 = new Coins();
        addObject(coins7, 981, 497);
        Coins coins8 = new Coins();
        addObject(coins8, 748, 331);
        Coins coins9 = new Coins();
        addObject(coins9, 911, 328);
        Coins coins10 = new Coins();
        addObject(coins10, 34, 186);
        Coins coins11 = new Coins();
        addObject(coins11, 151, 188);
        Coins coins12 = new Coins();
        addObject(coins12, 334, 190);
        Coins coins13 = new Coins();
        addObject(coins13, 92, 65);
        Coins coins14 = new Coins();
        addObject(coins14, 332, 69);
        Ladder ladder6 = new Ladder(6);
        addObject(ladder6, 788, 180);
        ladder6.setLocation(762, 164);
        ladder6.setLocation(762, 162);
        Portal portal = new Portal();
        addObject(portal, 895, 45);
        portal.setLocation(881, 46);
        coins13.setLocation(92, 57);
        coins14.setLocation(332, 56);
        coins10.setLocation(36, 170);
        coins11.setLocation(151, 170);
        coins12.setLocation(334, 170);
        coins11.setLocation(161, 170);
        coins12.setLocation(326, 172);
        coins8.setLocation(748, 314);
        coins9.setLocation(911, 312);
        coins.setLocation(660, 491);
        coins2.setLocation(708, 450);
        coins3.setLocation(761, 417);
        coins4.setLocation(829, 411);
        coins5.setLocation(890, 434);
        coins6.setLocation(934, 463);
        coins7.setLocation(974, 502);
        Magnet magnet = new Magnet();
        addObject(magnet, 825, 539);
        magnet.setLocation(819, 535);
        magnet.setLocation(813, 521);
        ladder.setLocation(648, 336);
        ladder.setLocation(650, 337);
        Knight knight = new Knight();
        addObject(knight, 837, 189);
        knight.setLocation(831, 191);
        Knight knight2 = new Knight();
        addObject(knight2, 199, 62);
        knight2.setLocation(200, 67);
        knight2.setLocation(662, 55);
        portal.setLocation(214, 46);
        coins13.setLocation(546, 56);
        knight2.setLocation(862, 68);
    }
}
