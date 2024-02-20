package Old_Code;
/*
import java.awt.Graphics2D;

public abstract class Actor 
{
	public static final int UP = 270;
	public static final int DOWN = 90;
	public static final int LEFT = 180;
	public static final int RIGHT = 0;
	
	public static boolean boost = false;

	private double myYpos;
	private double myXpos;
	private int myFace = RIGHT;
	private int myNextFace = RIGHT;
	private double mySpeed = 0.1;
	
	public abstract void draw(Graphics2D g, int x, int y, int width, int height);
	
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
	public void BoostSpeed()
	{
		mySpeed = 0.15;
		boost = true;
	}
	public void normSpeed()
	{
		mySpeed = 0.1;
		boost = false;
	}
	public static double round (double value, int precision)
	{
		int scale = (int)Math.pow(10,  precision);
		return (double)Math.round(value * scale) / scale;
	}
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

 */
