import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TreeWorld  extends World
{
    public TreeWorld()
    {    
        super(500,600, 1); 
        
        addObject(new TreeDraw(270,60), getWidth()/2, getHeight());
    }
}
