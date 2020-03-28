import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Water extends Actor
{
    //the speed the dot travels at
    private int shoot;
    
    public Water(int xSpeed)
    {
        //stores the speed in shoot
        shoot = xSpeed;
        
        if(shoot<0) {
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
        }
        //create water image
        GreenfootImage img = new GreenfootImage(10,10);
        img.setColor(Color.CYAN);
        img.fill();
        setImage(img);
    }
    
    public void act() 
    {
        //moves across the screen in the direction the pig is facing
        move(shoot);
        //removes the dot once at edge
        if(isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            //if touching knight remove it from the world
            Knight k = (Knight)getOneIntersectingObject(Knight.class);
            if(k != null) {
                k.die();
                getWorld().removeObject(this);
            }
        }
    }    
}
