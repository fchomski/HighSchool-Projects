import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;
import greenfoot.Color;

/**
 * Write a description of class Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Four  extends Actor
{

    public Four()
    {
        // create a 20x20 empty image
        GreenfootImage tile = new GreenfootImage(20,20);

        Font myFont = new Font("Courier",20);
        tile.setFont(myFont);
        // fill the tile with color
        tile.setColor(Color.GRAY);
        tile.fill();
        // frame the tile with a square
        tile.setColor(new Color(184,52,26));
        tile.drawRect(0, 0, 20, 20);
        // display the number one (in bold)
        tile.setColor(Color.BLUE);
        tile.drawString("4",5,16);
        
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
