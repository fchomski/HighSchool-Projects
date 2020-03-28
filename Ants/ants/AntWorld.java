import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class AntWorld extends World
{
    public static final int SIZE = 600;

    public AntWorld()
    {
        super(SIZE, SIZE, 1);
        setPaintOrder(Ant.class, AntHill.class);

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        AntHill anthill = new AntHill();
        addObject(anthill, 117, 104);
        AntHill anthill2 = new AntHill();
        addObject(anthill2, 419, 394);
        Food food = new Food();
        addObject(food, 460, 101);
        Food food2 = new Food();
        addObject(food2, 141, 252);
        Food food3 = new Food();
        addObject(food3, 305, 499);
    }
}
