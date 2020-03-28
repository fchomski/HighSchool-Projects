import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import greenfoot.Font;

public class Win extends Actor
{
    public Win()
    {
        GreenfootImage image = new GreenfootImage(250,100);
        image.setFont(new Font("Verdana", 36));
        image.drawString("YOU WIN!", 5, 50);
        setImage(image);
    }
}
