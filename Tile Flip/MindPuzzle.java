import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

public class MindPuzzle extends World
{
    private static final int CELL_SIZE = 75;// the size of the tiles

    private Tile[][] puzzle;// 2D array holds the puzzle

    private int size;// the size of the world

    private int correct; //holds onto the number of correct clicks.

    /**
     * Overloaded constructors:
     * 
     * Default constructor creates a 3 by 3 puzzle
     */
    public MindPuzzle()
    {
        this(3);
    }

    /**
     * Second constructor creates a world of given size.
     * It should do all jobs required to start the game.
     * 
     */
    public MindPuzzle(int size)
    {    
        //make this world size by size, based on the cell size given
        super(size, size, CELL_SIZE); 
        this.size = size;
        //make grid for squares
        GreenfootImage img = new GreenfootImage(CELL_SIZE, CELL_SIZE);
        img.drawRect(0,0,CELL_SIZE, CELL_SIZE);
        setBackground(img);
        //initialize the array of squares that you are about to fill
        puzzle = new Tile[size][size];
        //set up a for loop that will fill your array with squares
        for(int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                puzzle[i][j] = new Tile(CELL_SIZE);
                addObject(puzzle[i][j],i,j);
            }
        }
        //make it so that there are no correct clicks in the beginning
        correct = 0;
        //select the squares you will be using as the black squares for the game by calling the select method
        select(size);
    }

    /**
     * Call this method from the Tile class if that tile is a selected tile
     */
    public void correctClick()
    {
        //add to our total correct clicks. 
        correct++;
        //if we have got all the clicks correct...
        if(correct == size) {
            //add a new result showing that the user got the puzzle right. 
            Result r = new Result(true);
            addObject(r, getWidth()/2, getHeight()/2); 
            //reveal the puzzle completely and have the program show this for a few moments
            showPuzzle();
            Greenfoot.delay(100);
            //then remove the result and start a new game, one square bigger
            removeObject(r);
            Greenfoot.setWorld(new MindPuzzle(size+1));
        }
    }

    /**
     * Call this method from the Tile class if that is a not a selected tile
     */
    public void wrongClick()
    {
        //in wrongClick(), add a new result showing that the user got the puzzle wrong
        Result r = new Result(false);
        addObject(r, getWidth()/2, getHeight()/2); 
        //reveal the puzzle completely
        showPuzzle();
        //have the program show this for a few moments
        Greenfoot.delay(100);
        //then remove the result and start a new game of the same size
        removeObject(r);
        Greenfoot.setWorld(new MindPuzzle(size-1));
    }

    /**
     * This method selected 'howMany' tiles
     */
    private void select(int howMany)
    {
        int num = howMany;
        //while we still don't have 3 selected
        while (num > 0){
            //choose a random place in the grid
            int i = Greenfoot.getRandomNumber(size);
            int j = Greenfoot.getRandomNumber(size);
            //if this square is not already black
            if (puzzle[i][j].isBlack() == false){
                puzzle[i][j].select();
                num--;
            }
            //make it so, and decrease the number we still need to select
        }
    }

    /**
     * This method reveals the puzzle at the end of the game
     */
    private void showPuzzle()
    {
        //go through the matrix and reveal all squares
        for(int a = 0; a < size; a++) {
            for(int b = 0; b < size; b++) {
                puzzle[a][b].reveal();
            }
        }
    }
}
