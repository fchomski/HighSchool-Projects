import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Coins extends Actor
{
    //coin image
    private GreenfootImage coin = new GreenfootImage("coin.png");
    
    //coin images
    private GreenfootImage coin1 = new GreenfootImage("coin1.png");
    private GreenfootImage coin2 = new GreenfootImage("coin2.png");
    private GreenfootImage coin3 = new GreenfootImage("coin3.png");
    private GreenfootImage coin4 = new GreenfootImage("coin4.png");
    private GreenfootImage coin5 = new GreenfootImage("coin5.png");
    private GreenfootImage coin6 = new GreenfootImage("coin6.png");
    private GreenfootImage coin7 = new GreenfootImage("coin7.png");
    private GreenfootImage coin8 = new GreenfootImage("coin8.png");
    private GreenfootImage coin9 = new GreenfootImage("coin9.png");
    private GreenfootImage coin10 = new GreenfootImage("coin10.png");
    
    private int countImage;
    
    private GreenfootImage[] coins = {coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10};
    
    public Coins()
    {
        coin.scale(25,25);
        setImage(coin);
        
        coin1.scale(25,25);
        coin2.scale(25,25);
        coin3.scale(25,25);
        coin4.scale(25,25);
        coin5.scale(25,25);
        coin6.scale(25,25);
        coin7.scale(25,25);
        coin8.scale(25,25);
        coin9.scale(25,25);
        coin10.scale(25,25);
        
        countImage = 0;
    } 
    
    public void act()
    {
        countImage++;
        if(countImage == 0) {
            setImage(coins[0]);
        } else if(countImage== 10) {    
            setImage(coins[1]);
        } else if(countImage == 20) {
            setImage(coins[2]);
        } else if(countImage == 30) {
            setImage(coins[3]);
        } else if(countImage== 40) {    
            setImage(coins[4]);
        } else if(countImage == 50) {
            setImage(coins[5]);
        } else if(countImage == 60) {
            setImage(coins[6]);
        } else if(countImage== 70) {    
            setImage(coins[7]);
        } else if(countImage == 80) {
            setImage(coins[8]);
        } else if(countImage == 90) {
            setImage(coins[9]);
            countImage = 0;
        }
    }
    
    /**
     * activateMagnet
     * Called by the pig class to make coins move towards center of magnet
     */
    public void activateMagnet()
    {
        //creates a list of the magnets within a 200 pixel radius
        List <Magnet> magnetsNearby = getObjectsInRange(200, Magnet.class);
        //turn and move towards the magnet
        for(Magnet m : magnetsNearby) {
            turnTowards(m.getX(), m.getY());
            move(5);
        }
    }
}
