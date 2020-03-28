import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ladder extends Actor
{
    private GreenfootImage ladder = new GreenfootImage("ladder.png");
    
    public Ladder(int length)
    {
        //scales the image to 25x25
        ladder.scale(25,25);
        //creates blocks of different lengths
        GreenfootImage img = new GreenfootImage(25, 25*length);
        //draws the column of ladders
        int y = 0;
        for(int i = 0; i < length; i++) {
            img.drawImage(ladder, 0, y);
            y += 20;
        }
        //sets the image
        setImage(img);
    }
}
