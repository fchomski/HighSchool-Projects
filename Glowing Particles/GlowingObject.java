import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GlowingObject extends Actor
{
    GreenfootImage img = new GreenfootImage(5,5);
    
    public GlowingObject()
    {
        img.drawOval(0,0,5,5);
        int r = Greenfoot.getRandomNumber(255);
        int g = Greenfoot.getRandomNumber(255);
        int b = Greenfoot.getRandomNumber(255);
        img.setColor(new Color(r,g,b));
        img.fillOval(0,0,5,5);
        img.setTransparency(0);
        setImage(img);
    }
}
