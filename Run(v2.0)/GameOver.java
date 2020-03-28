import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Font;

public class GameOver extends Actor
{
    public GameOver()
    {
        //adds text that says Game Over in the centre of the screen
        GreenfootImage img = new GreenfootImage(250,100);
        img.setFont(new Font("Verdana", 36));
        //img.setColor(Color.WHITE);
        img.drawString("GAME OVER",5,50);
        setImage(img);
    } 
}
