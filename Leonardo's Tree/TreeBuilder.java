import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TreeBuilder extends Actor
{
    public TreeBuilder(int width)
    {
        GreenfootImage img = new GreenfootImage(width,width);
        img.setColor(Color.BLACK);
        img.fillOval(0,0,width,width);
        setImage(img);
    }
}
