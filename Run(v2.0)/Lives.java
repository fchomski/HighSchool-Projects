import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lives extends Actor
{
    //heart image file
    GreenfootImage heart = new GreenfootImage("heart.png");
    
    public Lives(int i)
    {
        //scales image to 20 by 20 pixels and sets the image to new, scaled image
        heart.scale(20,20);
        //sets the image to the heart png file
        setImage(heart);
    }
}
