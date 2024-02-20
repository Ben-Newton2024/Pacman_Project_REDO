package Old_Code;
/*
import Old_Code.Actor;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ghosts extends Actor
{
	private Color myColor; 
	private int myAnimationPhase = 0;
	
	public Ghosts(Color c)
	{
		myColor = c;
	}
	public void draw(Graphics2D g, int x, int y, int width, int height) 
	{
		if(getFace() == LEFT)
		{
			if (myAnimationPhase ==0 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x,y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==1)
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/5),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/5)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==2 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/7),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/7)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==3 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/10),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/10)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/4)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase = 0;
			}
		}
		if(getFace() == UP)
		{
			if (myAnimationPhase ==0 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x,y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==1)
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/5),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/5)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==2 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/7),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/7)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==3 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/10),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/10)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/4)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/5), y+(height/5),width/8,height/8);
				g.fillOval(x+(width/2), y+(height/5), width/8, height/8);
				myAnimationPhase = 0;
			}
		}
		if(getFace() == RIGHT)
		{
			if (myAnimationPhase ==0 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x,y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/5),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==1)
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/5),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/5)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/5),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==2 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/7),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/7)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/5),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/5), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==3 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/10),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/10)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/4)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/5),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/5), width/8, height/8);
				myAnimationPhase = 0;
			}
		}
		if(getFace() == DOWN)
		{
			if (myAnimationPhase ==0 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x,y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/6),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/6), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==1)
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/5),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/5)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/6),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/6), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==2 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/7),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/7)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/3)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/6),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/6), width/8, height/8);
				myAnimationPhase ++;
			}
			else if (myAnimationPhase ==3 )
			{
				//main body
				g.setColor(myColor);
				g.fillArc(x, y, width, height/2, 0, 180);
				g.fillRect(x, y+(height/4), width, height/2);
				g.fillArc(x+(width/10),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/10)+(width/3),y+(height/3),width/3, height-5, 180,180);
				g.fillArc(x+(width/4)+(width/3),y+(height/3),width/3, height-5, 180,180);
				//eyes
				g.setColor(Color.WHITE);
				g.fillOval(x+(width/5),y+(height/5),width/5,height/5);
				g.fillOval(x+(width/2),y+(height/5),width/5,height/5);
				g.setColor(Color.BLACK);
				g.fillOval(x+(width/3)+width/3, y+(height/6),width/8,height/8);
				g.fillOval(x+(width/3), y+(height/6), width/8, height/8);
				myAnimationPhase = 0;
			}
		}
	}
		
	public void setColor(Color c)
	{
		myColor = c;
	}
		
	//called blinky - the red ghost
	//attributes
	//move
	//chases pacman
	
	//called pinky - pink Ghost
	//attributes
	//move
	//try to position its self infront of pacman
	
	//called inky - cyan ghost
	//attributes
	//move
	//try to position its self infront of pacman
	
	//called clyde - orange ghost
	//attributes
	//move
	//chases or flees from pacman
}


 */