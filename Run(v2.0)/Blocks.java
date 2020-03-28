import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Blocks extends Actor
{
    //create a new GreenfootImage that is a 25 by 25 square
    GreenfootImage image = new GreenfootImage(25,25);
    
    public Blocks(int size)
    {
        //creates blocks of different lengths depending on the parameter in the method
        GreenfootImage img = new GreenfootImage(25*size, 25);
        //sets the colour and fills the image white
        img.setColor(Color.WHITE);
        img.fill();
        //draws the row of bricks
        int x = 0;
        for(int w = 0; w < size; w++){
            img.drawImage(image,x,0);
            x += 20;
        }
        //sets the image to the row of bricks
        setImage(img);
    }
}
