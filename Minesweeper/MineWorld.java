import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MineWorld  extends World
{
    private final int mines = 40;
    private final int rows = 16;
    private final int cols = 16;
    private int all_cells;
    public int [][] cell = new int [rows][cols];

    private final int COVER_FOR_CELL = 10;
    private final int MARK_FOR_CELL = 10;
    private final int EMPTY_CELL = 0;
    private final int MINE_CELL = 9;
    private final int COVERED_MINE_CELL = MINE_CELL + COVER_FOR_CELL;
    private final int MARKED_MINE_CELL = COVERED_MINE_CELL + MARK_FOR_CELL;

    private final int RIGHT_BUTTON = 3;
    private final int LEFT_BUTTON = 1;

    private final int MINES = 40;

    /**
     * Constructor for objects of class MineWorld.
     */
    public MineWorld()
    {   
        super(16*20, 16*20, 1); 
        populate();
    }

    private void populate()
    {
        // WRITE YOUR CODE FOR TASK 1 HERE
        int mineSoFar = 0;
        while(mineSoFar < MINES) {
            int j = Greenfoot.getRandomNumber(256);
            int r = j/rows;
            int c = j%cols;
            if(cell[r][c] != MINE_CELL) {
                //addObject(new Mine(), r, c);
                cell[r][c] = MINE_CELL;
                //check the cells around the mine and add to them in order to populate the numbers
                mineSoFar++;
                //For each cell that has a mine at row r and column c
                //Loop for all rows r-1, r, r+1
                for(int adjR = -1; adjR < 2; adjR++) {
                    //Loop for all columns c-1, c, c+1 
                    for(int adjC= -1; adjC < 2; adjC++) {
                        if(r + adjR >= 0 && r + adjR < rows && c+adjC >= 0 && c+adjC <cols) {
                            //If the cell has no mine
                            if(cell[r +adjR][c + adjC] != MINE_CELL) {
                                //Add 1 to the contents of the cell 
                                cell[r +adjR][c + adjC]++;
                            }
                        }
                    }
                }
            } 
        }
        //FOR TASK 3, MODIFY YOUR CODE IN TASK 1 ABOVE.

        //The call to the revealAll() method is included below.
        //Leave these method calls at the end:
        coverAll();
        revealAll();
    }

    public void revealAll()
    {        
        // COMPLETE THIS METHOD IN TASK 2
        //loop through each row and column and reveal r and c using the reveal method
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) { 
                reveal(i, j);
            }
        }
    }

    public void reveal(int r, int c)
    {        
        // COMPLETE THIS METHOD IN TASK 2
        if (cell[r][c] == MINE_CELL ) {
            addObject(new Mine(), c*20+10, r*20+10); 
        } else if (cell[r][c] == EMPTY_CELL) {
            addObject(new Empty(), c*20+10, r*20+10); 
        } else if(cell[r][c] == 1) {
            addObject(new One(), c*20+10, r*20+10);
        } else if(cell[r][c] == 2) {
            addObject(new Two(), c*20+10, r*20+10);
        } else if(cell[r][c] == 3) {
            addObject(new Three(), c*20+10, r*20+10);
        } else if(cell[r][c] == 4) {
            addObject(new Four(), c*20+10, r*20+10);
        } else if(cell[r][c] == 5) {
            addObject(new Five(), c*20+10, r*20+10);
        } else if(cell[r][c] == 6) {
            addObject(new Six(), c*20+10, r*20+10);
        } else if(cell[r][c] == 7) {
            addObject(new Seven(), c*20+10, r*20+10);
        } else if(cell[r][c] == 8) {
            addObject(new Eight(), c*20+10, r*20+10);
        } else if(cell[r][c] == EMPTY_CELL) {
            revealEmptyCells(c,r);
        }
        //once we start dealing with clicks, we will also add to our cells so that the proper images show up,
        //so we will also have to deal with the following scenarios:
        // a flag could be wrongly placed on an empty covered cell (20), one (21), two (22)
        // three (23), four (24), five (25), six (26), seven (27), eight (28), 
        //or correctly on a mine (29).
        else if(cell[r][c] >= 20 && cell[r][c] <= 29) {
            addObject(new Flag(), c*20+10, r*20+10);
        }
        //if none of these other scenarios fit, add a Cover object in place
        else {
            addObject(new Cover(), c*20+10, r*20+10);
        }
    }

    public void coverAll()
    {        
        // COMPLETE THIS METHOD IN TASK 4
        for(int k = 0; k < rows; k++) {
            for(int l=0; l < cols; l++) {
                cell[k][l] = cell[k][l] + COVER_FOR_CELL;
            }
        }
    }

    public void act()
    {        
        // COMPLETE THIS METHOD IN TASK 5
        if(Greenfoot.mouseClicked(null)){
            //get the mouse information in int variables as described: 
            MouseInfo mouse = Greenfoot.getMouseInfo();
            //store where the mouse is on the x-axis
            int x = mouse.getX();
            //store where it is on the y-axis
            int y = mouse.getY();
            //and store which button has been pressed (left or right)
            int click = mouse.getButton();
            //in order to figure out which cell is being pressed:
            //create a column int value that divides the x value by 20
            int column = x/20;
            //create a row int value that divides the y value by 20
            int row = y/20;

            //if the user has clicked the left button
            if(click == 1) {
                //if what is in that cell is equal to a covered mine cell
                if(cell[row][column] == COVERED_MINE_CELL) {
                    //add a new boom object in its place
                    addObject(new Boom(), column*20 + 10, row*20 + 10);
                    //call the uncoverMines() method
                    uncoverMines();
                }
                //if this isn't a mine cell
                else if(cell[row][column] > MINE_CELL) {
                    //remove its cover
                    cell[row][column] = cell[row][column] - COVER_FOR_CELL;
                } else if(cell[row][column] == EMPTY_CELL) {
                    //call the reveal empty cell method
                    revealEmptyCells(row,column);
                }
                reveal(row,column);
            }
            //if the user has right clicked
            if(click == 3) {
                //if the cell is a covered unmarked cell
                Flag f = new Flag();
                if(cell[row][column] <= 19 && cell[row][column] >=10) {
                    //mark it
                    cell[row][column] = cell[row][column] + MARK_FOR_CELL;
                } //if the cell is a marked cell
                else {
                    //unmark it
                    removeObject(f);
                    cell[row][column] = cell[row][column]-10;
                }
                //refresh the current cell (aka reveal)
                reveal(row,column);
            }
        }
        //AND MODIFY IT IN TASK ^
    }

    public void revealEmptyCells(int r,int c)
    {
        // COMPLETE THIS METHOD IN TASK 6

        //for all the cells adjacent to this one...
        for (int nr=r-1;nr<=r+1;nr++){
            for (int nc=c-1;nc<=c+1;nc++){
                //|  |   |  |
                //|  | x |  |
                //|  |   |  |
                if ( nr>=0 && nc>=0 && nr<rows && nc<cols){ //if this cell is not past the edge of the board
                    if (cell[nr][nc]== COVER_FOR_CELL){  //if this cell is simply an empty covered cell
                        cell[nr][nc]-= COVER_FOR_CELL; //”remove” the cover
                        reveal(nr,nc); //add the object that displays this cell
                        revealNumberCells(nr,nc); //call the method that reveals number cells
                        revealEmptyCells(nr,nc); //recursively call this method
                    }
                }    
            }
        }
    }

    public void revealNumberCells(int r,int c)
    {
        // COMPLETE THIS METHOD IN TASK 7
        int j = Greenfoot.getRandomNumber(256);
        int row = j/rows;
        int col = j%cols;
        
        for(int w = r-1; w <= r+1; w++) {
            for(int h = c-1; h <= c+1; c++) {
                if(w >= 0 && w < rows && h >= 0 && h < cols) {
                    if(cell[w][h] > COVER_FOR_CELL && cell[w][h] < COVERED_MINE_CELL) {
                        cell[w][h] -= COVER_FOR_CELL;
                        reveal(w,h);
                    }
                }
            }
        }
    }

    /**
     * Uncover and reveal all the cells containing mines.
     */
    public void uncoverMines()
    {
        for (int r=0;r<rows;r++)
        {
            for (int c=0;c<cols;c++)
            {
                //|  |   |  |
                //|  | x |  |
                //|  |   |  |
                if (cell[r][c] == COVERED_MINE_CELL)
                {  
                    cell[r][c]-= COVER_FOR_CELL;
                    reveal(r,c);                        
                }
            }
        }
    }
}
