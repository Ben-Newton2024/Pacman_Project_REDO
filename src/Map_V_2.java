import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.*;

public class Map_V_2 extends JPanel implements ActionListener, KeyListener
{
    private int[][] myMap;

    // Create instances of pacman and other characters,
    // that will be drawn on the map, which extend the characteristics of actor
    private final Pacman_V_2 myPacman = new Pacman_V_2();
    private final Ghosts_V_2 Blinky = new Ghosts_V_2(Color.RED);
    private final Ghosts_V_2 Clyde 	= new Ghosts_V_2(Color.ORANGE);
    private final Ghosts_V_2 Pinky 	= new Ghosts_V_2(Color.PINK);
    private final Ghosts_V_2 Inky 	= new Ghosts_V_2(Color.CYAN);

    private int myScore = 0;

    // delay at 16, gives 60fps
    private final Timer myAnimationTimer = new Timer(16,this);

    // Constructor to make sure the Map_V_2 class all items have a Key Listener added to its 'extends' 'JPanel'
    // and to be shown.
    public Map_V_2()
    {
        this.setFocusable(true);
        this.addKeyListener(this);
    }
    
    
    /*
            Method to load the map,
            this is done via reading the text files that the maps are saved to
            the maps are saved as digits from 0-9 to show each block individually.
     */

    public void loadMap(String filename) {
        try {
            // Creating instance of a reader to read text files.
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // As the maps are stored in text files, we cannot confirm or assume how big the file is.
            // as such we need to count the column as rows to then recreate this image in a 2D array for later methods
            int row_length_original;
            int num_rows = 0;
            int num_column = 0;

            // Read the first line
            String line = reader.readLine();
            // text file maps should be square/ rectangular, as such the length should be the same throughout
            // as such we are saving the first rows length to check that all the following rows are the same later.
            row_length_original = line.length();

            // Check to ensure that the line isn't empty,
            //
            while (line != null) {
                // if row isn't empty, we can increase the number of rows
                num_rows++;
                // check length of the row aka counting how many columns there are
                num_column = line.length();
                line = reader.readLine();

                /*
                    if statement to check if the num_columns isn't equal,
                    this is to ensure that each line read is the same length
                    (same amount of columns) to make a 2D array with no gaps or errors
                */
                if (num_column != row_length_original) {
                    System.err.println(
                            """
                    
                                    =================
                                    +++===ERROR===+++
                                    +++LEVEL=FILE=+++
                                    +INCORRECT=SIZE++
                                    +++FOR=THE=MAP+++
                                    +++===ERROR===+++
                                    =================
                                    """
                    );
                    System.exit(0);
                }
            }

            // A lines have been read, and no error was caught,
            // we can now close the reader.
            reader.close();
            // Need to set up the 2D array and map.
            setupMap(num_rows, num_column, filename);

        } catch(IOException ioe)
        {
            // If an IOException is thrown while closing the BufferedReader, print an error message
            System.err.format("IOException: %s%n", ioe);
            System.exit(0);
        }
    }

    /*
            setupMap method is to follow after load map was completed.
            all checks within load map have been done and any problems should be caught and dealt with.

            here we can re-read the map again, passing the data read from each line into an 2D array
            allowing for the walls of the map, the playable space for pacman and the ghosts to be added.
            once they are added they can later be drawn.
     */
    public void setupMap(int rows, int column, String filename){
        try{
            // Make a new map the 'size' of the text file
            // 2D array is made for game
            myMap = new int[rows][column];

            // Read the file again
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int rowNum = 0;
            // If the row is null then problem.
            // else we keep looping till the end.
            while(line != null)
            {
                // loop for the length of the line, passing the data from row ('read line')
                // data gets saved onto the 2D array here, by setting each position
                // any special characters such as 6, 7, 4, 8, 9
                // are saved to the array, along with their instance being set to that position within the array
                // this is done by calling the attributes of set Pos within their
                // individual Actor class of each individual Ghost or Pacman class
                for (int i = 0; i < column; i ++)
                {
                    myMap[rowNum][i] = Integer.parseInt(""+line.charAt(i));
                    if(myMap[rowNum][i] == 6)
                    {
                        myPacman.setPos(i, rowNum);
                    }
                    if(myMap[rowNum][i] == 7)
                    {
                        Blinky.setPos(i, rowNum);
                    }
                    if(myMap[rowNum][i] == 4)
                    {
                        Clyde.setPos(i, rowNum);
                    }
                    if(myMap[rowNum][i] == 8)
                    {
                        Pinky.setPos(i, rowNum);
                    }
                    if(myMap[rowNum][i] == 9)
                    {
                        Inky.setPos(i, rowNum);
                    }
                }
                // Loop around and move the next line to read.
                rowNum++;
                line  =reader.readLine();
            }
            // close the reader as we are done with it.
            reader.close();
            // Print the map out entirely in console to ensure nothing goes wrong for debug.
            // System.out.println(Arrays.deepToString(myMap)+"\n");
        } catch(IOException ioe)
        {
            // If an IOException is thrown while closing the BufferedReader, print an error message
            System.err.format("IOException: %s%n", ioe);
            System.exit(0);
        }
        // File is read, all loops end,
        // start the timer, to get the gaming ticking,
        // TODO, MAKE HOME SCREEN SO ANIMATION TIMER DOESNT NEED TO START TILL IN MAP LEVELS
        //  aka not in the home screen, unless there is some animation in there.
        myAnimationTimer.start();
    }

    /*
                    Paint Component

        This contains the logic to ensure that each block is drawn correctly facing the right way.
        This draws the Map, to make sure that each wall is curved, each playable space for pacman contains a dot of food
        visually for the play, and there are power up food drawn where they need to be.

        TODO Quick Idea, the map stays the same, the entire play through except for the food being eaten
            due to this we could just draw the map walls once
            then every animation tick we draw the characters and any food remaining
            this would decrease the drawing 'time' and resources need to redraw the entire map again and again
            repeating the logic that draws the walls.
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;


        // Get the size of the block, done to the height of the screen display, so can be done to different resolutions.
        int blockWidth = (int)Math.round((double)getWidth()/(double)myMap[0].length);
        int blockHeight = (int)Math.round((double)getHeight()/(double)myMap.length);

        //Set the entire map black.
        g2.setColor(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // set the height of the circles that will be drawn for Pacman food
        int dot_width = blockWidth/4;
        int dot_height = blockHeight/4;


        /*
         This is to check all around the current X, Y position of the Loops below
         to find what needs to be drawn for a wall
         as if there is nothing around the wall, then it can be drawn as a circle
         if there is something to its left and right then the wall needs to be drawn as a horizontal line.
        */
        double top;
        double bottom;
        double left;
        double right;
        double dtopl;
        double dtopr;
        double dbottoml;
        double dbottomr;


        /*
                Loop the entire 2D array.
                This is to draw the walls.

         */
        for(int y=0; y<myMap.length; y++)
        {
            // Used to check if a character is about to move off-screen, to be able to teleport them to the other side,
            // as well as using this to reduce the chances of there being an out-of-bounds error, when trying to extend
            // beyond the limits the 2D array.
            boolean is_teleport_valid = true;
            for(int x=0; x<myMap[y].length; x++)
            {
                /*
                        Logic to draw the walls,
                        Corners done first
                        then horizontal and vertical.

                 */
                g2.setColor(Color.blue);
                if (myMap[y][x] == 1)
                {
                    ////////////////////////corner arcs/////////////////////////////
                    if (x == 0 && y == 0)
                    {
                        g2.drawArc(blockWidth / 2, blockHeight / 2,blockWidth,blockHeight,90,90);
                    }
                    else if (x == 0 && y == myMap.length-1)
                    {
                        g2.drawArc(blockWidth / 2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                    }
                    else if ( x == myMap[y].length-1 && y == 0)
                    {
                        g2.drawArc(x*blockWidth-blockWidth/2, blockHeight / 2, blockWidth, blockHeight, 360 ,90);
                    }
                    else if (x == myMap[y].length-1 && y == myMap.length-1)
                    {
                        g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                    }
                    ///////////////////not corner then everything else lines and arcs//////////////////////////////
                    else
                    {
                        ////////////////////border lines////////////
                        if (x == 0 || x == myMap[y].length-1)
                        {
                            int i = (y * blockHeight + blockHeight) - (blockHeight / 2);
                            if(x == 0 && y < myMap.length - 1)
                            {
                                dtopr 		= myMap[y-1][x+1];
                                dbottomr 	= myMap[y+1][x+1];
                                right 		= myMap[y][x+1];
                                top 		= myMap[y-1][x];
                                bottom 		= myMap[y+1][x];

                                if (dtopr != 1 && top != 1 && right != 1)
                                {
                                    g2.drawArc(blockWidth / 2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
                                }
                                else if (right != 1)
                                {
                                    g2.drawLine((blockWidth / 2), (y*blockHeight), (blockWidth / 2), (y*blockHeight+blockHeight));
                                }
                                else {
                                    if(bottom != 1)
                                    {
                                        g2.drawLine(0, (y*blockHeight)+(blockHeight/2), blockWidth, i);
                                    }
                                    else if(top != 1)
                                    {
                                        g2.drawLine(0, (y*blockHeight)+(blockHeight/2), blockWidth, i);
                                    }
                                    else if (dtopr != 1)
                                    {
                                        g2.drawArc(blockWidth / 2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                                    }
                                    else if (dbottomr != 1)
                                    {
                                        g2.drawArc(blockWidth / 2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
                                    }
                                }
                            }
                            if(x == myMap[y].length-1 && y > 0 && y<myMap.length-1)
                            {
                                left 		= myMap[y][x-1];
                                dtopl 		= myMap[y-1][x-1];
                                dbottoml 	= myMap[y+1][x-1];
                                top 		= myMap[y-1][x];
                                bottom 		= myMap[y+1][x];

                                if (top != 1 && left != 1 && dtopl != 1)
                                {
                                    g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
                                }
                                else if(left != 1)
                                {
                                    g2.drawLine(x*blockWidth+(blockWidth/2), (y*blockHeight),x*blockWidth+(blockWidth/2), (y*blockHeight+blockHeight));
                                }
                                else {
                                    if(bottom != 1)
                                    {
                                        g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, i);
                                    }
                                    else if(top != 1)
                                    {
                                        g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, i);
                                    }
                                    else if (dbottoml != 1)
                                    {
                                        g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
                                    }
                                    else if (dtopl != 1)
                                    {
                                        g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                                    }
                                }


                            }
                        }
                        else {
                            int y2 = (y * blockHeight + blockHeight) - (blockHeight / 2);
                            if (y == 0 || y == myMap.length-1)
                            {
                                if(y == 0 && x < myMap[y].length - 1)
                                {
                                    bottom 		= myMap[y+1][x];
                                    dbottoml 	= myMap[y+1][x-1];
                                    dbottomr 	= myMap[y+1][x+1];
    
                                    if(bottom != 1)
                                    {
                                        g2.drawLine(x*blockWidth, (blockHeight / 2),x*blockWidth+blockWidth, (blockHeight)-(blockHeight/2));
                                    }
                                    else if (dbottoml != 1)
                                    {
                                        g2.drawArc(x*blockWidth-blockWidth/2, blockHeight / 2, blockWidth, blockHeight, 360 ,90);
                                    }
                                    else if (dbottomr != 1)
                                    {
                                        g2.drawArc(x*blockWidth+blockWidth/2, blockHeight / 2,blockWidth,blockHeight,90,90);
                                    }
                                }
                                if(y == myMap.length - 1 && x < myMap[y].length - 1)
                                {
                                    top 	= myMap[y-1][x];
                                    dtopl 	= myMap[y-1][x-1];
                                    dtopr 	= myMap[y-1][x+1];
    
                                    if(top != 1)
                                    {
                                        g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, y2);
                                    }
                                    else if (dtopl != 1)
                                    {
                                        g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                                    }
                                    else if (dtopr != 1)
                                    {
                                        g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                                    }
    
                                }
                            } else{
                                top 	= myMap[y-1][x];
                                bottom 	= myMap[y+1][x];
                                left	= myMap[y][x-1];
                                right 	= myMap[y][x+1];
                                dtopl 	= myMap[y-1][x-1];
                                dtopr 	= myMap[y-1][x+1];
                                dbottoml = myMap[y+1][x-1];
                                dbottomr = myMap[y+1][x+1];
                                //////////outside corner
                                if(top != 1 && right != 1)
                                {
                                    g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
                                }
                                else if (bottom != 1 && left != 1)
                                {
                                    g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                                }
                                else if (bottom != 1 && right != 1)
                                {
                                    g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                                }
                                else if (top != 1 && left != 1)
                                {
                                    g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
                                }
                                //////limes straight
                                else if(top != 1 || bottom != 1)
                                {
                                    g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, y2);
                                }
                                else if (left != 1 || right != 1)
                                {
                                    g2.drawLine(x*blockWidth+(blockWidth/2), (y*blockHeight),x*blockWidth+(blockWidth/2), (y*blockHeight+blockHeight));
                                }
                                ////////////inside corner///
                                else if (dtopl != 1)
                                {
                                    g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                                }
                                else if (dtopr != 1)
                                {
                                    g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                                }
                                else if (dbottoml != 1)
                                {
                                    g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
                                }
                                else if (dbottomr != 1)
                                {
                                    g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
                                }
    
                            }
                        }
                        //////////////////////////////////////////////////////////////////////////////////////////////////////////
                        ////////////////////////////////////////////all drawing types//////////////////////////////////////////////
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                        //left or right etiny
                        //g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));

                        //up down x- 1or x+1
                        //g2.drawLine(x*blockWidth+(blockWidth/2), (y*blockHeight),x*blockWidth+(blockWidth/2), (y*blockHeight+blockHeight));
                        //top left corner
                        //g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
                        //top right
                        //g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
                        //bottom left curve
                        //g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
                        //bottom right
                        //g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
                    }
                }
                g2.setColor(Color.RED);
                if (myMap[y][x] == 3)
                {
                    g2.drawLine(x*blockWidth-(blockWidth/3), (y*blockHeight+blockHeight)-(blockHeight),x*blockWidth+blockWidth+(blockWidth/3), (y*blockHeight+blockHeight)-(blockHeight));
                }


                /*

                        None wall numbers within the 2D array map

                        this is to draw the walkable space within the map and passed the walls.

                        includes food for Pacman and power up food.
                 */
                if (myMap[y][x] == 0)
                {
                    g2.setColor(Color.WHITE);
                    g2.fillOval(x*blockWidth + dot_width, y*blockHeight + dot_height, blockWidth/2, blockHeight/2);
                }
                //power up dots
                else if (myMap[y][x] == 2)
                {
                    g2.setColor(Color.CYAN);
                    g2.fillOval(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
                }

                /*
                    Logic for ensuring that Pacman  as he moves out of bounds when drawing, to reduce the chance of an error
                    or an out-of-bounds error within the map
                    we can set his position to the other side where he will exit the teleport.

                    TODO While teleporting player cannot change direction for .5 of a second or so to ensure they
                        don't try to re-teleport back and get stuck
                        which would lead to an out of bounds error or paint error where they are off screen.
                 */
                if (myPacman.getXpos() == 0)
                {
                    if (is_teleport_valid)
                    {
                        myPacman.setPos(myMap[x].length-1, myPacman.getYpos());
                        is_teleport_valid = false;
                    }

                }

                if (myPacman.getXpos() == myMap[y].length-1)
                {
                    if(is_teleport_valid)
                    {
                        myPacman.setPos(0, myPacman.getYpos());
                        is_teleport_valid = false;
                    }
                }
            }
        }

        /*
                All remains in drawing is the characters themselves.
                calling their own draw methods, allows them to complete their own animation timer
                to let them be animated as the move

                and also they will be drawn on this JPanel now as they are within the main PaintComponent of
                this Class Jpanel
         */


        Blinky.draw(g2, (int)Math.round(blockWidth*(Blinky.getXpos())), (int)Math.round(blockHeight*(Blinky.getYpos())), blockWidth, blockHeight);
        Inky.draw(g2, (int)Math.round(blockWidth*(Inky.getXpos())), (int)Math.round(blockHeight*(Inky.getYpos())), blockWidth, blockHeight);
        Clyde.draw(g2, (int)Math.round(blockWidth*Clyde.getXpos()), (int)Math.round(blockHeight*(Clyde.getYpos())), blockWidth, blockHeight);
        Pinky.draw(g2, (int)Math.round(blockWidth*(Pinky.getXpos())), (int)Math.round(blockHeight*(Pinky.getYpos())), blockWidth, blockHeight);

        // always draw pacman after map to update position and make it look like it move
        myPacman.draw(g2, (int)Math.round(blockWidth*(myPacman.getXpos())), (int)Math.round(blockHeight*(myPacman.getYpos())), blockWidth, blockHeight);

    }




    /*
            Action listeners

            for the animations timer, running the game is so many ticks/frames

           every event performed by that timer ticking
           we need to repaint the screen as pacman will have likely moved.


           as timer continues Ghosts will have moved as well

           so we can include the logic for them.

           we need them to move within valid means around the map, so we can check to see if their current movement it's
           acceptably using the valid move method
           this allows them to make a choice everytime along with the player to choose they want to go up
           or down and to check if it is a valid move for them to be able to move.
     */
    public void actionPerformed(ActionEvent e)
    {
        // If pacman is over something like a normal food or power up,
        // edit the 2D array map to show that he has eaten it
        // and then leave an empty tile behind him.
        if(myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] == 0)
        {
            myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] = 5;
            myScore+=10;
        }
        if(myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] == 2)
        {
            myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] = 5;
            myScore+=50;
        }

        /*
            TODO, Scan the entire map, with each move made to see if all dots are eaten.
         */

        if(isValidMove(Pinky, Pinky.getnextFace()))
            Pinky.setFace(Pinky.getnextFace());
        if(isValidMove(Pinky, Pinky.getFace()))
            Pinky.move();
        if(isValidMove(Blinky, Blinky.getnextFace()))
            Blinky.setFace(Blinky.getnextFace());
        if(isValidMove(Blinky, Blinky.getFace()))
            Blinky.move();
        if(isValidMove(Clyde, Clyde.getnextFace()))
            Clyde.setFace(Clyde.getnextFace());
        if(isValidMove(Clyde, Clyde.getFace()))
            Clyde.move();
        if(isValidMove(Inky, Inky.getnextFace()))
            Inky.setFace(Inky.getnextFace());
        if(isValidMove(Inky, Inky.getFace()))
            Inky.move();

        if(isValidMove(myPacman, myPacman.getnextFace()))
            myPacman.setFace(myPacman.getnextFace());
        if(isValidMove(myPacman, myPacman.getFace()))
            myPacman.move();

        repaint();

        // Call the logic for the ghosts to choose their pathing per frame of the game to mimic real time
        // decision-making this calls red ghosts logic to always follow Pacman.
        RedFollow();
    }



    /*

            Valid Move is a method to ensure that when passing through an object, like Pacman,
                or 'Blink-y', or any other ghost
                they can move within the confines of the map.
                this is to ensure that if the next direction the player or the ghosts choose is into a wall.
                then it isn't a valid move and will not allow the play to turn into the wall
                if it is a valid move later on in the game when walking down a corridor,
                then the check will be called every frame
                and as such will detect that the player or ghosts tried to go up,
                and can no go up, and will return a boolean value according True.
     */
    private boolean isValidMove(Actor_V_2 a, int direction)
    {

        double speed 		= a.getSpeed();

        double top_left_x 	= a.getXpos();
        double top_left_y 	= a.getYpos();

        double top_right_x 	= a.getXpos()+0.99;
        double top_right_y 	= a.getYpos();

        double bottom_left_x 	= a.getXpos();
        double bottom_left_y 	= a.getYpos()+0.99;

        double bottom_right_x = a.getXpos()+0.99;
        double bottom_right_y = a.getYpos()+0.99;

        if(direction == Actor_V_2.UP)
        {
            top_left_y-=speed;
            top_right_y-=speed;
        }
        if(direction == Actor_V_2.DOWN)
        {
            bottom_left_y+=speed;
            bottom_right_y+=speed;
        }
        if(direction == Actor_V_2.LEFT)
        {
            top_left_x-=speed;
            bottom_left_x-=speed;
        }
        if(direction == Actor_V_2.RIGHT)
        {
            top_right_x+=speed;
            bottom_right_x+=speed;
        }
        return myMap[(int) top_left_y][(int) top_left_x] != 1
                &&
                myMap[(int) top_left_y][(int) top_left_x] != 3
                &&
                myMap[(int) top_right_y][(int) top_right_x] != 1
                &&
                myMap[(int) top_right_y][(int) top_right_x] != 3
                &&
                myMap[(int) bottom_left_y][(int) bottom_left_x] != 1
                &&
                myMap[(int) bottom_left_y][(int) bottom_left_x] != 3
                &&
                myMap[(int) bottom_right_y][(int) bottom_right_x] != 1
                &&
                myMap[(int) bottom_right_y][(int) bottom_right_x] != 3;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*
            Input events for player.

                this is to be able to set the next face of pacman, as such you want pacman moving constantly.
                so if a play tries to move up, and pacman cannot it will keep going left or right,
                once it reaches a point it can go up, it will do so accordingly via the is valid move method allowing it to.
                then it will be drawn doing such as thing.

         */
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyChar() == 'a')
        {
            myPacman.setnextFace(Actor_V_2.LEFT);
        }
        if(e.getKeyChar() == 'w')
        {
            myPacman.setnextFace(Actor_V_2.UP);
        }
        if(e.getKeyChar() == 's')
        {
            myPacman.setnextFace(Actor_V_2.DOWN);
        }
        if(e.getKeyChar() == 'd')
        {
            myPacman.setnextFace(Actor_V_2.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    /*
            TODO
                i believe that this can be done in the Ghosts class and called upon.
                but coding out the ghosts interactions with Pacman.
     */
    public void RedFollow() {

        int blockWidth 		= (int)Math.round((double)getWidth()/(double)myMap[0].length);
        int blockHeight 	= (int)Math.round((double)getHeight()/(double)myMap.length);

        double pacX 		= myPacman.getXpos();
        double pacY 		= myPacman.getYpos();

        double redX 		= Blinky.getXpos();
        double redY 		= Blinky.getYpos();

        int num_y = 0;
        int num_x = 0;

        int direction = Blinky.getFace();


    }
}