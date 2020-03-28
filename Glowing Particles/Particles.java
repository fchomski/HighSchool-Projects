import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Particles extends Actor
{
    private GreenfootImage img = new GreenfootImage(5,5);
    private int trans = 255;
    
    public Particles()
    {
        img.drawOval(0,0,5,5);
        int r = Greenfoot.getRandomNumber(255);
        int g = Greenfoot.getRandomNumber(255);
        int b = Greenfoot.getRandomNumber(255);
        img.setColor(new Color(r,g,b));
        img.fillOval(0,0,5,5);
        setImage(img);
    }
    
    public void act()
    {
        if(trans!= 0) {
            trans = trans-5;
            getImage().setTransparency(trans);
        }
    }
    
    public void glow()
    {
        trans = 255;
    }
}
