import greenfoot.*;

public class Result extends Actor
{
    private GreenfootImage imgCorrect = new GreenfootImage("smiley2.png");
    private GreenfootImage imgWrong = new GreenfootImage("smiley3.png");
    
    public Result(boolean correct)
    {
        if(correct) {
            setImage(imgCorrect);
        } else {
            setImage(imgWrong);
        }
    }
}
