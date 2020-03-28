import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TreeDraw extends SmoothMover
{
    private int counter;
    private int w;
    private int d;
    
    public TreeDraw(int dir, int width)
    {
        w = width;
        d = dir;
        counter = 0;
        GreenfootImage img = new GreenfootImage(w,w);
        img.setColor(Color.BLACK);
        img.fillOval(0,0,w,w);
        setImage(img);
        //create the initial vector for tree draw
        Vector v = new Vector(dir,1.0);
        //add the force
        addForce(v);
    }
    
    public void act() 
    {
        //make it move based on the added force
        move();
        //leave a trail of tree builder objects
        getWorld().addObject(new TreeBuilder(w), getX(), getY());
        counter++;
        
        if(counter == 120) {
            if(w/2 <= 3) {
                Greenfoot.stop();
            }
            int b1Angle = d + Greenfoot.getRandomNumber(20) + 10;
            int b2Angle = d - Greenfoot.getRandomNumber(20)-10;
            int thickness = (int)(w/Math.sqrt(2));
            
            getWorld().addObject(new TreeDraw(b1Angle,thickness), getX(), getY());
            getWorld().addObject(new TreeDraw(b2Angle,thickness), getX(), getY());
            getWorld().removeObject(this);
        }
    }    
}
