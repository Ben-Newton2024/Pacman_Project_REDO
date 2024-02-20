import java.awt.Graphics2D;

public abstract class Actor_V_2
{
    // Ints Used for designating the direction, the 'Actor' could be moving, as such
    // Pacman, will inherit the traits of Actor, to be able to move the character around the map
    // thus if pacman is ever needed to face up, we can just repaint, with the orientation changed
    // according to these set digits already
    public static final int UP = 270;
    public static final int DOWN = 90;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;
    private double myYpos;
    private double myXpos;
    private int myFace = RIGHT;
    private int myNextFace = RIGHT;
    private double mySpeed = 0.1;

    public abstract void draw(Graphics2D g, int x, int y, int width, int height);


    /*
            Methods used to get the positions and set the positions of the 'Actor'

                    AKA, set and get the positions of the characters
                                    in the game


                    Also includes changing the direction the Actor will be facing
                                setting the speed if there is a boost

     */
    public void setPos (double x, double y)
    {
        myYpos = y;
        myXpos = x;
    }
    public double getXpos()
    {
        return myXpos;
    }

    public double getYpos()
    {
        return myYpos;
    }
    public void setFace(int d)
    {
        myFace = d;
    }
    public void setnextFace(int d)
    {
        myNextFace = d;
    }
    public int getnextFace()
    {
        return myNextFace;
    }
    public void stop()
    {
        myFace = -myFace;
    }
    public int getFace()
    {
        return myFace;
    }
    public double getSpeed()
    {
        return mySpeed;
    }


    // to make precise rounding for moving the actor precise 'numbers'
    // takes a double value and an integer precision, and returns the rounded
    // value of the input value with the specified precision.
    public static double round (double value, int precision)
    {
        int scale = (int)Math.pow(10,  precision);
        return (double)Math.round(value * scale) / scale;
    }


    /*
                This is to move the Actor,
                using the face earlier
                using the speed
                as such moves the actor via that position


     */
    public void move()
    {


        if(myFace == RIGHT)
        {
            setPos(round(getXpos()+mySpeed,2),getYpos());
        }
        if(myFace == DOWN)
        {
            setPos(getXpos(),round(getYpos()+mySpeed,2));
        }
        if(myFace == LEFT)
        {
            setPos(round(getXpos()-mySpeed,2),getYpos());
        }
        if(myFace == UP)
        {
            setPos(getXpos(),round(getYpos()-mySpeed,2));
        }



    }
}
