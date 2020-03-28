import java.util.*;

import greenfoot.*;

/**
 * @author Florencia Chomski
 * @version August 5, 2017
 */
public class Food extends Actor
{
    private static final Random randomizer = new Random();
    private static final Color color1 = new Color(160, 200, 60);
    private static final Color color2 = new Color(80, 100, 30);
    private static final Color color3 = new Color(10, 50, 0);
    private final int SIZE = 30; //sets the size of the food image
   
    private int foodCrumbs = 100;
    
    public Food()
    {
        updateImage();
    }
    
    public void act() 
    {
        
    }    
    
    public void removeFoodCrumbs()
    {
        //removecrumbs from th "pile"
        foodCrumbs = foodCrumbs - 5;
        
        if(foodCrumbs <= 0) {
            getWorld().removeObject(this);   
        } else {
            updateImage(); //update what this looks like
        }
    }
    
    /*
     * Draws food based on the variable food crumbs
     */
    public void updateImage()
    {
        GreenfootImage newImage = new GreenfootImage(SIZE,SIZE);
        
        for(int i=0; i<foodCrumbs; i++){
            int x = randomCoordinate();
            int y = randomCoordinate();
        
            newImage.setColorAt(x,y,color1);
            newImage.setColorAt(x + 1,y,color2);
            newImage.setColorAt(x, y + 1, color2);
            newImage.setColorAt(x + 1, y + 1,color3);
        }
        setImage(newImage);
    }
    
    /**
    * Returns a random number relative to the size of the food pile.
    */
    private int randomCoordinate()
    {
        int val = SIZE/2 + (int) (randomizer.nextGaussian() * (SIZE / 4));
    
        if (val < 0)
            return 0;
    
        if (val > SIZE - 2)
            return SIZE - 2;
        else
            return val;
    }
}
