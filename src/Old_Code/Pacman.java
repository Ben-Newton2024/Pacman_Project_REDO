package Old_Code;
/*
import Old_Code.Actor;

import java.awt.Color;
import java.awt.Graphics2D;

public class Pacman extends Actor
{
	private int animationPhase = 0;
	
	public void draw(Graphics2D g, int x, int y, int width, int height) 
	{
		if (getFace() == RIGHT)
		{
			if( animationPhase == 0)
			{
				g.setColor(Color.YELLOW);
				//g.fillOval(x,y,width,height);
				//make small and center dont like it being blocmk sixe
				g.fillArc(x, y, width, height, 45,270);
				animationPhase ++;
			}
			else if (animationPhase == 1)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,300);
				animationPhase ++;
			}
			else if (animationPhase == 2)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,345);
				animationPhase ++;
			}
			else if (animationPhase == 3)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,360);
				animationPhase ++;
			}
			else if (animationPhase == 4)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,345);
				animationPhase ++;
			}
			else if (animationPhase == 5)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,300);
				animationPhase ++;
			}
			else if (animationPhase == 6)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,270);
				animationPhase ++;
			}		
			else if (animationPhase == 7)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 45,270);
				animationPhase =0;
			}
		}
		if (getFace() == DOWN)
		{
			if( animationPhase == 0)
			{
				g.setColor(Color.YELLOW);
				//g.fillOval(x,y,width,height);
				//make small and center dont like it being blocmk sixe
				g.fillArc(x, y, width, height,315,270);
				animationPhase ++;
			}
			else if (animationPhase == 1)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,300);
				animationPhase ++;
			}
			else if (animationPhase == 2)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,345);
				animationPhase ++;
			}
			else if (animationPhase == 3)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,360);
				animationPhase ++;
			}
			else if (animationPhase == 4)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,345);
				animationPhase ++;
			}
			else if (animationPhase == 5)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,300);
				animationPhase ++;
			}
			else if (animationPhase == 6)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 315,270);
				animationPhase ++;
			}		
			else if (animationPhase == 7)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height,315,270);
				animationPhase =0;
			}
			
		}
		if (getFace() == LEFT)
		{
			if( animationPhase == 0)
			{
				g.setColor(Color.YELLOW);
				//g.fillOval(x,y,width,height);
				//make small and center dont like it being blocmk sixe
				g.fillArc(x, y, width, height, 225,270);
				animationPhase ++;
			}
			else if (animationPhase == 1)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,300);
				animationPhase ++;
			}
			else if (animationPhase == 2)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,345);
				animationPhase ++;
			}
			else if (animationPhase == 3)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,360);
				animationPhase ++;
			}
			else if (animationPhase == 4)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,345);
				animationPhase ++;
			}
			else if (animationPhase == 5)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,300);
				animationPhase ++;
			}
			else if (animationPhase == 6)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,270);
				animationPhase ++;
			}		
			else if (animationPhase == 7)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 225,270);
				animationPhase =0;
			}
		}
		if (getFace() == UP)
		{
			if( animationPhase == 0)
			{
				g.setColor(Color.YELLOW);
				//g.fillOval(x,y,width,height);
				//make small and center dont like it being blocmk sixe
				g.fillArc(x, y, width, height,135,270);
				animationPhase ++;
			}
			else if (animationPhase == 1)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 135,300);
				animationPhase ++;
			}
			else if (animationPhase == 2)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 135,345);
				animationPhase ++;
			}
			else if (animationPhase == 3)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 135,360);
				animationPhase ++;
			}
			else if (animationPhase == 4)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height,135,345);
				animationPhase ++;
			}
			else if (animationPhase == 5)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 135,300);
				animationPhase ++;
			}
			else if (animationPhase == 6)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height, 135,270);
				animationPhase ++;
			}		
			else if (animationPhase == 7)
			{
				g.setColor(Color.YELLOW);
				g.fillArc(x, y, width, height,135,270);
				animationPhase =0;
			}
			
		}
		
	}


}

 */
