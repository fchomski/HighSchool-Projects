import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * An ant that collects food.
 * 
 * @author Michael Kolling
 * @version 0.1
 */
public class Ant extends Creature
{
    private boolean carryingFood;
    
    private int countCycles;
    
    private int foundPheromone;
    
    private int recentlyFoundPH = 0;
    
    /**
     * Create an ant with a given home hill. The initial speed is zero (not moving).
     */
    public Ant(AntHill home)
    {
        setHomeHill(home);
        carryingFood = false;
        countCycles = 0;
        foundPheromone = 30;
    }

    /**
     * Do what an ant's gotta do.
     */
    public void act()
    {
        if(carryingFood) {
            walkTowardsHome();
            addPheromone();
            lookForHome();
        } else {
            searchForFood();
        }
        foundPheromone--;
        if(foundPheromone < 0) {
            walkAwayFromHome();
        }
        if(foundPheromone == 0) {
            foundPheromone = 30;
        }
    }
    
    private void searchForFood() 
    {
        Pheromone ph = (Pheromone)getOneIntersectingObject(Pheromone.class);
        if(recentlyFoundPH > 0) {
            recentlyFoundPH--;
            walkAwayFromHome();
        } else if (ph != null) {
            walkTowardsPheromone(ph);
        } else {
            randomWalk();
        }
        Food f = (Food)getOneIntersectingObject(Food.class);
        if(f != null) {
            f.removeFoodCrumbs();
            setImage("ant-with-food.gif");
            carryingFood = true;
        }
    }
    
    private void addPheromone()
    {
        countCycles++;
        if(countCycles == 18) {
            getWorld().addObject(new Pheromone(), getX(), getY());
            countCycles = 0;
        }
    }
    
    private void lookForHome()
    {
        AntHill home = (AntHill)getOneIntersectingObject(AntHill.class);
        if(home != null) {
            setImage("ant.gif");
            carryingFood = false;
            home.countFood();
        }
    }
    
    private void walkTowardsPheromone(Pheromone ph) 
    {
        headTowards(ph);
        walk();
        if(ph.getX() == getX() && ph.getY() == getY()) {
            //recentlyFoundPH = 
        }
    }
}