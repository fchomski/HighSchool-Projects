import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Space extends World
{
    
    public Space()
    {    
        super(800, 600, 1); 
        
        setBackground("blackbackground.jpg");
        addObject(new Light(), getWidth()/2, getHeight()/2);
        
        for(int i = 0; i < 200; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Particles(), x, y);
        }
    }
}
