import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends World
{
    //background image for the instructions screen
    private GreenfootImage intro = new GreenfootImage("intro.jpg");

    public Instructions()
    {    
        super(1000, 600, 1); 

        //scales image to the size of the world
        intro.scale(getWidth(), getHeight());
        //sets the background to the intro image
        setBackground(intro);
        //adds stuff to world
        prepare();
    }

    public void act()
    {
        //switch worlds to the first level if space is pressed
        if(Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level1());
        }
    }
    
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        getHeight();
        Label label = new Label("Runner?", 70);
        addObject(label, 669, 366);
        label.setLocation(506, 48);
        Label label2 = new Label("by Florencia", 30);
        addObject(label2, 671, 418);
        label2.setLocation(500, 94);
        Label label3 = new Label("HOW TO PLAY", 40);
        addObject(label3, 708, 460);
        label3.setLocation(156, 165);
        Label label4 = new Label("Press the right arrow key to move right", 30);
        addObject(label4, 661, 400);
        label4.setLocation(263, 213);
        Label label5 = new Label("Press the left arrow key to move left", 30);
        addObject(label5, 677, 391);
        label5.setLocation(245, 249);
        Label label6 = new Label("Press the up arrow key to climb ladders", 30);
        addObject(label6, 788, 479);
        label6.setLocation(266, 286);
        Label label7 = new Label("Press space to shoot", 30);
        addObject(label7, 616, 463);
        label7.setLocation(164, 322);
        label5.setLocation(246, 247);
        label6.setLocation(267, 285);
        label7.setLocation(164, 322);
        label7.setLocation(165, 321);
        Label label8 = new Label("OBJECTIVE", 40);
        addObject(label8, 753, 424);
        label8.setLocation(137, 393);
        Label label9 = new Label("Reach a portal like this", 30);
        addObject(label9, 786, 414);
        label9.setLocation(182, 437);
        Portal portal = new Portal();
        addObject(portal, 596, 514);
        portal.setLocation(166, 496);
        label8.setLocation(136, 385);
        portal.setLocation(159, 512);
        label9.setLocation(179, 431);
        portal.setLocation(157, 495);
        Label label10 = new Label("to move on to the next level", 30);
        addObject(label10, 699, 480);
        label10.setLocation(200, 555);
        portal.setLocation(175, 491);
        Label label11 = new Label("Stay away from knights like this", 30);
        addObject(label11, 685, 319);
        label11.setLocation(773, 208);
        Knight knight = new Knight();
        addObject(knight, 801, 302);
        knight.setLocation(762, 254);
        Label label12 = new Label("Touch them and you lose life", 30);
        addObject(label12, 799, 423);
        label12.setLocation(758, 298);
        Label label13 = new Label("Lose five lives and the game is over", 30);
        addObject(label13, 806, 433);
        label13.setLocation(783, 342);
        label12.setLocation(742, 299);
        label11.setLocation(759, 207);
        label12.setLocation(742, 310);
        label12.setLocation(743, 310);
        label11.setLocation(761, 209);
        knight.setLocation(762, 260);
        label12.setValue("Touch them and you lose a life");
        label12.setLocation(752, 310);
        label12.setLocation(754, 310);
        label12.setLocation(752, 310);
        label12.setLocation(755, 310);
        label12.setLocation(754, 310);
        Label label14 = new Label("Magnets like this", 30);
        addObject(label14, 755, 450);
        label14.setLocation(681, 415);
        Magnet magnet = new Magnet();
        addObject(magnet, 714, 462);
        magnet.setLocation(680, 454);
        Label label15 = new Label("Pick up coins in a 200 pixel radius", 30);
        addObject(label15, 729, 518);
        label15.setLocation(774, 556);
        magnet.setLocation(680, 519);
        label14.setLocation(678, 476);
        label15.setLocation(770, 557);
        label15.setLocation(770, 558);
        label14.setLocation(674, 478);
        label14.setLocation(680, 478);
        label15.setLocation(775, 557);
        magnet.setLocation(680, 516);
        label.setValue("RUNNER");
        label.setLocation(138, 32);
        label2.setLocation(93, 81);
        label.setLocation(154, 32);
        label2.setLocation(117, 83);
        label.setLocation(163, 38);
        Label label16 = new Label("PRESS SPACE", 40);
        addObject(label16, 749, 154);
        label16.setLocation(749, 52);
        Label label17 = new Label("TO PLAY", 40);
        addObject(label17, 747, 100);
        label17.setLocation(747, 87);
        label17.setLocation(747, 94);
        label16.setLocation(750, 61);
        knight.setLocation(730, 261);
        label.setValue("Run");
        label.setLocation(100, 39);
    }
}
