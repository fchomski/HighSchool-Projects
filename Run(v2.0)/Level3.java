import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Level3 extends World
{
    //background image file
    private GreenfootImage background = new GreenfootImage("background3.jpg");
    //name of background
    private static final String bgImageName = "background3.jpg";
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

    public Level3(Pig pig)
    {
        super(1000,600,1);
        
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
     * Takes away lives and updates the hearts
     */
    public void removeLives()
    {
        //takes away a life
        countLives--;
        //removes the corresponding heart at the top of the screen
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
        Blocks blocks10 = new Blocks(40);
        addObject(blocks10, 581, 442);
        blocks10.setLocation(500, 587);
        Blocks blocks11 = new Blocks(35);
        addObject(blocks11, 649, 374);
        blocks11.setLocation(562, 452);
        blocks11.setLocation(562, 459);
        removeObject(blocks11);
        Blocks blocks12 = new Blocks(20);
        addObject(blocks12, 640, 344);
        blocks12.setLocation(749, 474);
        blocks12.setLocation(750, 472);
        Blocks blocks13 = new Blocks(15);
        addObject(blocks13, 692, 295);
        blocks13.setLocation(242, 472);
        blocks13.setLocation(234, 472);
        Blocks blocks14 = new Blocks(7);
        addObject(blocks14, 476, 383);
        blocks14.setLocation(463, 382);
        blocks14.setLocation(470, 366);
        blocks14.setLocation(470, 358);
        Blocks blocks15 = new Blocks(17);
        addObject(blocks15, 748, 310);
        blocks15.setLocation(786, 359);
        removeObject(blocks15);
        Blocks blocks16 = new Blocks(14);
        addObject(blocks16, 811, 404);
        blocks16.setLocation(825, 357);
        Blocks blocks17 = new Blocks(5);
        addObject(blocks17, 587, 333);
        blocks17.setLocation(255, 357);
        Blocks blocks18 = new Blocks(3);
        addObject(blocks18, 591, 244);
        blocks18.setLocation(52, 360);
        blocks17.setLocation(246, 359);
        blocks16.setLocation(825, 358);
        blocks17.setLocation(246, 356);
        blocks18.setLocation(52, 355);
        blocks18.setLocation(52, 359);
        blocks17.setLocation(246, 358);
        blocks18.setLocation(51, 355);
        blocks18.setLocation(52, 357);
        blocks18.setLocation(52, 359);
        blocks18.setLocation(53, 356);
        blocks18.setLocation(53, 359);
        Ladder ladder8 = new Ladder(5);
        addObject(ladder8, 645, 312);
        ladder8.setLocation(636, 408);
        removeObject(ladder8);
        Ladder ladder9 = new Ladder(6);
        addObject(ladder9, 694, 259);
        ladder9.setLocation(637, 421);
        Ladder ladder10 = new Ladder(6);
        addObject(ladder10, 127, 397);
        ladder10.setLocation(103, 422);
        Ladder ladder11 = new Ladder(5);
        addObject(ladder11, 42, 533);
        ladder11.setLocation(33, 524);
        removeObject(ladder11);
        Ladder ladder12 = new Ladder(6);
        addObject(ladder12, 114, 541);
        removeObject(blocks13);
        Blocks blocks19 = new Blocks(14);
        addObject(blocks19, 270, 471);
        blocks19.setLocation(265, 472);
        ladder12.setLocation(69, 531);
        blocks19.setLocation(232, 471);
        ladder12.setLocation(69, 532);
        ladder12.setLocation(69, 534);
        ladder12.setLocation(44, 535);
        Coins coins16 = new Coins();
        addObject(coins16, 61, 318);
        coins16.setLocation(54, 315);
        Ladder ladder13 = new Ladder(6);
        addObject(ladder13, 514, 515);
        ladder13.setLocation(488, 534);
        Blocks blocks20 = new Blocks(30);
        addObject(blocks20, 595, 288);
        blocks20.setLocation(542, 263);
        blocks20.setLocation(541, 250);
        Ladder ladder14 = new Ladder(5);
        addObject(ladder14, 915, 311);
        ladder14.setLocation(927, 302);
        blocks20.setLocation(489, 257);
        ladder14.setLocation(877, 306);
        blocks20.setLocation(489, 251);
        ladder14.setLocation(876, 300);
        ladder14.setLocation(877, 303);
        blocks20.setLocation(490, 253);
        removeObject(ladder10);
        Ladder ladder15 = new Ladder(11);
        addObject(ladder15, 115, 381);
        ladder15.setLocation(103, 379);
        Coins coins17 = new Coins();
        addObject(coins17, 909, 420);
        Knight knight3 = new Knight();
        addObject(knight3, 762, 437);
        Knight knight4 = new Knight();
        addObject(knight4, 154, 554);
        Ladder ladder16 = new Ladder(6);
        addObject(ladder16, 369, 400);
        ladder16.setLocation(369, 419);
        Coins coins18 = new Coins();
        addObject(coins18, 479, 323);
        coins18.setLocation(469, 309);
        Magnet magnet3 = new Magnet();
        addObject(magnet3, 448, 205);
        magnet3.setLocation(464, 204);
        Coins coins19 = new Coins();
        addObject(coins19, 626, 197);
        coins19.setLocation(631, 168);
        Coins coins20 = new Coins();
        addObject(coins20, 543, 105);
        Coins coins21 = new Coins();
        addObject(coins21, 450, 87);
        Coins coins22 = new Coins();
        addObject(coins22, 383, 106);
        Coins coins23 = new Coins();
        addObject(coins23, 325, 159);
        Coins coins24 = new Coins();
        addObject(coins24, 465, 146);
        coins24.setLocation(463, 146);
        coins21.setLocation(461, 56);
        coins19.setLocation(610, 167);
        coins23.setLocation(332, 161);
        coins19.setLocation(616, 51);
        coins23.setLocation(306, 107);
        coins19.setLocation(633, 104);
        Blocks blocks21 = new Blocks(15);
        addObject(blocks21, 817, 152);
        blocks21.setLocation(810, 105);
        removeObject(blocks21);
        Blocks blocks22 = new Blocks(13);
        addObject(blocks22, 796, 166);
        blocks22.setLocation(837, 104);
        Ladder ladder17 = new Ladder(8);
        addObject(ladder17, 662, 177);
        ladder17.setLocation(661, 190);
        ladder17.setLocation(662, 191);
        Blocks blocks23 = new Blocks(10);
        addObject(blocks23, 114, 139);
        blocks23.setLocation(126, 116);
        Ladder ladder18 = new Ladder(7);
        addObject(ladder18, 299, 213);
        ladder18.setLocation(264, 192);
        Coins coins25 = new Coins();
        addObject(coins25, 48, 66);
        Coins coins26 = new Coins();
        addObject(coins26, 179, 69);
        Coins coins27 = new Coins();
        addObject(coins27, 53, 167);
        Coins coins28 = new Coins();
        addObject(coins28, 968, 164);
        Coins coins29 = new Coins();
        addObject(coins29, 758, 310);
        Coins coins30 = new Coins();
        addObject(coins30, 242, 424);
        Magnet magnet4 = new Magnet();
        addObject(magnet4, 817, 213);
        Magnet magnet5 = new Magnet();
        addObject(magnet5, 156, 213);
        magnet5.setLocation(153, 207);
        coins28.setLocation(945, 161);
        coins28.setLocation(931, 159);
        coins27.setLocation(63, 168);
        knight4.setLocation(602, 550);
        addObject(new Portal3(),getWidth()-165, 50);
    }
}
