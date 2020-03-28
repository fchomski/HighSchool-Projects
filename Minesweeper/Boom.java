import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class Boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boom  extends Actor
{
    public Boom()
    {
        GreenfootImage tile = new GreenfootImage(20,20);
        GreenfootImage boom = new GreenfootImage("mine.png");

        tile.setColor(Color.RED);
        tile.fill();
        
        tile.setColor(Color.GRAY);
        tile.drawRect(0, 0, 20, 20);

        tile.drawImage(boom,0,0);
        setImage(tile);
    }

    /**
     * Act - do whatever the Boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
