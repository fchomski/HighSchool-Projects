import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Tail extends Actor
{
    private int counter = 0;
    private int lifeSpan;
    
    public Tail(int age)
    {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.setColor(Color.BLUE);
        img.fill();
        setImage(img);
        
        lifeSpan = age;
    }

    public void act() 
    {
        counter++;
        if(counter == lifeSpan) {
            getWorld().removeObject(this);
        }
    }    
}
