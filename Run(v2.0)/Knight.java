import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Knight extends Actor
{
    //image files
    private GreenfootImage knight = new GreenfootImage("knight1.png");
    private GreenfootImage knightflip = new GreenfootImage("knightflipped.png");
    
    //the speed at which the knight travels
    private int speed = 3;
    //counts the iterations of the act method
    private int counter;
    
    public Knight()
    {
        counter = 0;
        
        //scale images
        knight.scale(50,50);
        knightflip.scale(50,50);
        //set the image to the first knight image
        setImage(knight);
    }
    
    public void act() 
    {
        //count every time the act method is run
        counter++;
        //every 50 iterations, the knght will turn around, the counter is set back to 0
        if(counter == 50) {
            speed = -speed;
            counter = 0;
        }
        //if speed is negative, switch image so it's facing the direction it travels in, otherwise, if moving right; face right
        if(speed < 0) {
            setImage(knightflip);
        } else {
            setImage(knight);
        }
        //move in the direction specified
        setLocation(getX()+speed, getY());
    }    
    
    /**
     * die
     * Used by other classes to remove the knight from the world
     */
    public void die()
    {
        getWorld().removeObject(this);
    }
}
