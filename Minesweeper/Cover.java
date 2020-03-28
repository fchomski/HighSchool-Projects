import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cover  extends Actor
{

    public Cover()
    {
        GreenfootImage tile = new GreenfootImage(20,20);        
        tile.setColor(Color.GRAY);
        tile.fill(); 
        tile.setColor(Color.GREEN);
        tile.drawRect(0, 0, 20, 20);
        setImage(tile);
    }

    /**
     * Act - do whatever the Two wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
