import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Counter extends Actor
{
    //keeps track of the player's score
    private int score = 0;
    
    public Counter()
    {
        GreenfootImage image = new GreenfootImage(100,40);
        image.drawString("Score: " + score, 5, 25);
        setImage(image);
    }
    
    /**
     * update
     * Updates the score
     */
    public void update()
    {
        //adds to score
        score++;
        //clears display and draws a new scoreboard with the updated score
        GreenfootImage img = getImage();
        img.clear();
        img.drawString("Score: " + score, 5, 25);
    }
    
    public int returnScore()
    {
        return score;
    }
}
