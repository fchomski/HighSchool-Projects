import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Field extends World
{

    public Field()
    {    
        super(40, 30, 20); 
        
        GreenfootImage img = new GreenfootImage(20,20);
        img.drawRect(0,0,19,19);
        setBackground(img);
        

        addObject(new Snake(), getWidth()/2, getHeight()/2);
        addFood();
    }
    
    public void addFood()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(new Food(),x,y);
    }
}
