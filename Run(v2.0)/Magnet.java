import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Magnet extends Actor
{
    //magnet image file
    private GreenfootImage magnet = new GreenfootImage("magnet.png");
    
    public Magnet()
    {
        //scales the image and sets it
        magnet.scale(25,25);
        setImage(magnet);
    }
}
