import java.awt.Color;
import java.awt.Graphics2D;

public class Pacman_V_2 extends Actor_V_2
{
    /*
    Extends Actor, therefore takes all attributes that are set in Actor and extends then to itself.
    therefore Pacman here, only draws itself.
    However since it extends Actor, we can take it as a 'object' of sorts that it can be moved (via actor)
    and places and drawn all the map in any current state.

    how its drawn is down to this class.
    but how it acts moves, speed, direction, is down to the Actor.
     */
    private int animationPhase = 0;

    public void draw(Graphics2D g, int x, int y, int width, int height)
    {
        // SET THE COLOUR TO YELLOW FOR PACMAN.
        // OLD CODE, HAD IT ON EVERY ANIMATION PHASE, THIS CAN BE EXTRAPOLATED OUT
        // AS SEEN HERE
        g.setColor(Color.YELLOW);

        /*
            ANIMATION FOR MOVEMENT OF PACMAN WHEN FACING THE RIGHT

            THIS DRAWS AN ARC, WITH VARYING DEGREES TO SHOW A MOUTH OPENING AND CLOSING

            AN OVAL JUST DRAWS A CIRCLE AS SUCH CAN DRAW 'ALMOST' A FULL CIRCLE AKA AN ARC THAT FILLS


            With each If, it will draw the arc in different angles to correspond with the face of pacman,
            if pacman moves up then its face should move with it so now his mouth
            opens and closes on the northern face of the 'circle'

         */
        if (getFace() == RIGHT)
        {
            if( animationPhase == 0)
            {
                //g.fillOval(x,y,width,height);
                //make small and center don't like it being block six
                g.fillArc(x, y, width, height, 45,270);
                animationPhase ++;
            }
            else if (animationPhase == 1)
            {
                g.fillArc(x, y, width, height, 45,300);
                animationPhase ++;
            }
            else if (animationPhase == 2)
            {
                g.fillArc(x, y, width, height, 45,345);
                animationPhase ++;
            }
            else if (animationPhase == 3)
            {
                g.fillArc(x, y, width, height, 45,360);
                animationPhase ++;
            }
            else if (animationPhase == 4)
            {
                g.fillArc(x, y, width, height, 45,345);
                animationPhase ++;
            }
            else if (animationPhase == 5)
            {
                g.fillArc(x, y, width, height, 45,300);
                animationPhase ++;
            }
            else if (animationPhase == 6)
            {
                g.fillArc(x, y, width, height, 45,270);
                animationPhase ++;
            }
            else {
                if (animationPhase == 7) {
                    g.fillArc(x, y, width, height, 45, 270);
                    animationPhase = 0;
                }
            }
        }
        if (getFace() == DOWN)
        {
            if( animationPhase == 0)
            {
                //g.fillOval(x,y,width,height);
                g.fillArc(x, y, width, height,315,270);
                animationPhase ++;
            }
            else if (animationPhase == 1)
            {
                g.fillArc(x, y, width, height, 315,300);
                animationPhase ++;
            }
            else if (animationPhase == 2)
            {
                g.fillArc(x, y, width, height, 315,345);
                animationPhase ++;
            }
            else if (animationPhase == 3)
            {
                g.fillArc(x, y, width, height, 315,360);
                animationPhase ++;
            }
            else if (animationPhase == 4)
            {
                g.fillArc(x, y, width, height, 315,345);
                animationPhase ++;
            }
            else if (animationPhase == 5)
            {
                g.fillArc(x, y, width, height, 315,300);
                animationPhase ++;
            }
            else if (animationPhase == 6)
            {
                g.fillArc(x, y, width, height, 315,270);
                animationPhase ++;
            }
            else if (animationPhase == 7)
            {
                g.fillArc(x, y, width, height,315,270);
                animationPhase =0;
            }

        }
        if (getFace() == LEFT)
        {
            if( animationPhase == 0)
            {
                //g.fillOval(x,y,width,height);
                g.fillArc(x, y, width, height, 225,270);
                animationPhase ++;
            }
            else if (animationPhase == 1)
            {
                g.fillArc(x, y, width, height, 225,300);
                animationPhase ++;
            }
            else if (animationPhase == 2)
            {
                g.fillArc(x, y, width, height, 225,345);
                animationPhase ++;
            }
            else if (animationPhase == 3)
            {
                g.fillArc(x, y, width, height, 225,360);
                animationPhase ++;
            }
            else if (animationPhase == 4)
            {
                g.fillArc(x, y, width, height, 225,345);
                animationPhase ++;
            }
            else if (animationPhase == 5)
            {
                g.fillArc(x, y, width, height, 225,300);
                animationPhase ++;
            }
            else if (animationPhase == 6)
            {
                g.fillArc(x, y, width, height, 225,270);
                animationPhase ++;
            }
            else if (animationPhase == 7)
            {
                g.fillArc(x, y, width, height, 225,270);
                animationPhase =0;
            }
        }
        if (getFace() == UP)
        {
            if( animationPhase == 0)
            {
                //g.fillOval(x,y,width,height);
                g.fillArc(x, y, width, height,135,270);
                animationPhase ++;
            }
            else if (animationPhase == 1)
            {
                g.fillArc(x, y, width, height, 135,300);
                animationPhase ++;
            }
            else if (animationPhase == 2)
            {
                g.fillArc(x, y, width, height, 135,345);
                animationPhase ++;
            }
            else if (animationPhase == 3)
            {
                g.fillArc(x, y, width, height, 135,360);
                animationPhase ++;
            }
            else if (animationPhase == 4)
            {
                g.fillArc(x, y, width, height,135,345);
                animationPhase ++;
            }
            else if (animationPhase == 5)
            {
                g.fillArc(x, y, width, height, 135,300);
                animationPhase ++;
            }
            else if (animationPhase == 6)
            {
                g.fillArc(x, y, width, height, 135,270);
                animationPhase ++;
            }
            else if (animationPhase == 7)
            {
                g.fillArc(x, y, width, height,135,270);
                animationPhase =0;
            }

        }

    }
}