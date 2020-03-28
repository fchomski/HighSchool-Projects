import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

public class Light extends Actor
{
    GreenfootImage img = new GreenfootImage(10,10);
    
    public Light()
    {
        img.drawOval(0,0,10,10);
        img.setColor(Color.WHITE);
        img.fillOval(0,0,10,10);
        setImage(img);
    }
    
    public void act() 
    {
        movement();
        lightUp();
    }    
    
    private void movement()
    {
        if(Greenfoot.isKeyDown("left")) {
            setLocation(getX()-5, getY());
        }
        if(Greenfoot.isKeyDown("right")) {
            setLocation(getX()+5, getY());
        }
        if(Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-5);
        }
        if(Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+5);
        }
    }
    
    private void lightUp()
    {
        List<Particles> pList = getObjectsInRange(100,Particles.class);
        for(Particles p : pList) {
            p.glow();
        }
    }
}
