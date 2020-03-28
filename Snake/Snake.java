import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snake extends Actor
{
    private int counter = 0;
    private int foodEaten = 0;
    
    public Snake()
    {
        GreenfootImage img = new GreenfootImage(20, 20);
        img.fill();
        setImage(img);
        
        int direction = Greenfoot.getRandomNumber(4);
        setRotation(direction*90);
    }
    
    public void act() 
    {
        counter++;
        if(counter == 7) {
            if(foodEaten>0) {
                getWorld().addObject(new Tail(foodEaten*5), getX(), getY());
            }
            move(1);
            counter = 0;
        }
        if(Greenfoot.isKeyDown("right")) {
            setRotation(0);
        }
        if(Greenfoot.isKeyDown("left")) {
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("up")) {
            setRotation(270);
        }
        if(Greenfoot.isKeyDown("down")) {
            setRotation(90);
        }
        if(isTouching(Food.class)) {
            removeTouching(Food.class);
            foodEaten++;
            Field f = (Field)getWorld();
            f.addFood();
        }
    }    
}
