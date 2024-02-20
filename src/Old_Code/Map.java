package Old_Code;

import Old_Code.Actor;
import Old_Code.Ghosts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
public class Map extends JPanel implements ActionListener, KeyListener
{
	private int[][] myMap;
	private Pacman myPacman = new Pacman();
	//////for a trailing pacmna when gets power up//////////private Pacman trailPac = new Pacman();
	private Ghosts Blinky 	= new Ghosts(Color.RED);
	private Ghosts Clyde 	= new Ghosts(Color.ORANGE);
	private Ghosts Pinky 	= new Ghosts(Color.PINK);
	private Ghosts Inky 	= new Ghosts(Color.CYAN);
	
	private int myScore = 0;
	private boolean isteleportValid = true;
	
	private Timer myAnimationTimer = new Timer(40,this);
	
	public Map()
	{
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	public void Loadmap(String filename)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			//count rows columns
			int rowlengthori = 0;
			int rows = 0;
			int column = 0;
			String line = reader.readLine();
			
			rowlengthori = line.length();
			
			while(line != null)
			{
				rows++;
				column = line.length();
				line = reader.readLine();
				//////////checker on file if error in map file//////
				if (column != rowlengthori)
				{
					System.err.println(
							  "=================\n"
							+ "+++===ERROR===+++\n"
							+ "+++LEVEL=FILE=+++\n"
							+ "+INCORRECT=SIZE++\n"
							+ "+++FOR=THE=MAP+++\n"
							+ "+++===ERROR===+++\n"
							+ "=================\n"
							);
					System.exit(0);
				}
			}
			System.out.println("there are "+rows+" rows");
			System.out.println("there are "+column+" columns");
			reader.close();
			
			
			myMap = new int[rows][column];
			//reads da text file////////////
			reader = new BufferedReader(new FileReader(filename));
			line = reader.readLine();
			int rowNum = 0;
			while(line != null)
			{
				for (int i = 0; i < column; i ++)
				{
					myMap[rowNum][i] = Integer.parseInt(""+line.charAt(i));
					if(myMap[rowNum][i] == 6)
					{
						myPacman.setPos(i, rowNum);	
						//////////////trail idea///////////////trailPac.setPos(i, rowNum);
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
				rowNum++;
				line  =reader.readLine();
			}
			reader.close();
			System.out.println(Arrays.deepToString(myMap)+"\n");
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		myAnimationTimer.start();
	}
			
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int blockWidth = (int)Math.round((double)getWidth()/(double)myMap[0].length);
		int blockHeight = (int)Math.round((double)getHeight()/(double)myMap.length);
		
		g2.setColor(Color.black);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		int dotwidth = blockWidth/4;
		int dotheight = blockHeight/4;
				
		double top 		= 0;
		double bottom 	= 0;
		double left 	= 0;
		double right 	= 0;
		double dtopl 	= 0;
		double dtopr 	= 0;
		double dbottoml = 0;
		double dbottomr = 0;
		
		for(int y=0; y<myMap.length; y++)
		{
			isteleportValid = true;
			for(int x=0; x<myMap[y].length; x++)
			{
				g2.setColor(Color.blue);
				///////////lines/////////////////////////////////////////////////
				if (myMap[y][x] == 1)
				{
					////////////////////////corner arcs/////////////////////////////
					if (x == 0 && y == 0)
					{
						g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
					}
					else if (x == 0 && y == myMap.length-1)
					{
						g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
					}
					else if ( x == myMap[y].length-1 && y == 0)
					{
						g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
					}
					else if (x == myMap[y].length-1 && y == myMap.length-1)
					{
						g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 270,90);
					}
					///////////////////not corner then everyhing else lines and arcs//////////////////////////////
					else
					{	
						////////////////////border lines////////////
						if (x == 0 || x == myMap[y].length-1)
						{
							if(x == 0 && y > 0 && y<myMap.length-1)
							{
								dtopr 		= myMap[y-1][x+1];
								dbottomr 	= myMap[y+1][x+1];
								right 		= myMap[y][x+1];
								top 		= myMap[y-1][x];
								bottom 		= myMap[y+1][x];
								
								if (dtopr != 1 && top != 1 && right != 1)
								{
									g2.drawArc(x*blockWidth-blockWidth/2, y*blockHeight+blockHeight/2, blockWidth, blockHeight, 360 ,90);
								}
								else if (right != 1)
								{
									g2.drawLine(x*blockWidth+(blockWidth/2), (y*blockHeight),x*blockWidth+(blockWidth/2), (y*blockHeight+blockHeight));
								}
								else if(bottom != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
								}
								else if(top != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
								}
								else if (dtopr != 1)
								{
									g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight-blockHeight/2, blockWidth, blockHeight, 180,90);
								}
								else if (dbottomr != 1)
								{
									g2.drawArc(x*blockWidth+blockWidth/2, y*blockHeight+ blockHeight/2,blockWidth,blockHeight,90,90);
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
								else if(bottom != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
								}
								else if(top != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
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
						else if (y == 0 || y == myMap.length-1)
						{
							if(y == 0 && x > 0 && x<myMap[y].length-1)
							{
								bottom 		= myMap[y+1][x];
								dbottoml 	= myMap[y+1][x-1];
								dbottomr 	= myMap[y+1][x+1];

								if(bottom != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
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
							if(y == myMap.length-1 && x > 0 && x<myMap[y].length-1)
							{
								top 	= myMap[y-1][x];
								dtopl 	= myMap[y-1][x-1];
								dtopr 	= myMap[y-1][x+1];

								if(top != 1)
								{
									g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
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
						}
						////////////////////////////////////all da inside bits and bobos/////////////////
						else 
						{
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
								g2.drawLine(x*blockWidth, (y*blockHeight)+(blockHeight/2),x*blockWidth+blockWidth, (y*blockHeight+blockHeight)-(blockHeight/2));
							}
							else if (left != 1 || right != 1)
							{
								g2.drawLine(x*blockWidth+(blockWidth/2), (y*blockHeight),x*blockWidth+(blockWidth/2), (y*blockHeight+blockHeight));
							}
							////////////insidde corner///
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
						//////////////////////////////////////////////////////////////////////////////////////////////////////////
						////////////////////////////////////////////all drawing types//////////////////////////////////////////////
						///////////////////////////////////////////////////////////////////////////////////////////////////////////
						//left or right tinhyu
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
//				/////////////////////////////////////////////////////////////pacmnan movemonst in blocks///////////////////////////////////
//				////////////to check if its on a map o of which is a dot and can go nom
//				if(jj == y && x == j && myMap[y][x] == 0)
//				{
//					g2.setColor(Color.MAGENTA);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.out.println("Nom, Nom, Omonomom");
//				}
//				///////////////////////to checlk if it s on a a boarder and cant then move
//				if(jj == y && x == j && myMap[y][x] == 1)
//				{
//					g2.setColor(Color.MAGENTA);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.err.println("PACMAN, STOP IN THE NAME OF THE LAW");
//					
//				}
//				
//				////////////////////////////////////////////////////////ghosts movemoent on bloks///////////////////////////
//				if(bb == y && x == b && myMap[y][x] == 1)
//				{
//					g2.setColor(Color.GREEN);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.err.println("BLINKY, WAIT THATS ELLIGAL");
//				}
//				if(pp == y && x == p && myMap[y][x] == 1)
//				{
//					g2.setColor(Color.GREEN);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.err.println("PINKY, WAIT THATS ELLIGAL");
//				}
//				if(cc == y && x == c && myMap[y][x] == 1)
//				{
//					g2.setColor(Color.GREEN);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.err.println("CLYDE, WAIT THATS ELLIGAL");
//				}
//				if(ii == y && x == i && myMap[y][x] == 1)
//				{
//					g2.setColor(Color.GREEN);
//					g2.fillRect(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
//					System.err.println("INKY, WAIT THATS ELLIGAL");
//				}
				/////////////////////////////////dots etc//////////////////////////////////////////////////////////////////////////////
				if (myMap[y][x] == 0)
				{
					g2.setColor(Color.WHITE);
					g2.fillOval(x*blockWidth + dotwidth, y*blockHeight + dotheight, blockWidth/2, blockHeight/2);
				}
				//poswer up dots
				else if (myMap[y][x] == 2)
				{
					g2.setColor(Color.CYAN);
					g2.fillOval(x*blockWidth, y*blockHeight, blockWidth, blockHeight);
				}	
				
				//////////////////////////////////teleport across map//////////////////////////////////////////////////////
				if (myPacman.getXpos() == 0)
				{
					if (isteleportValid == true)
					{
						myPacman.setPos(myMap[x].length-1, myPacman.getYpos());
						isteleportValid = false;
					}
									
				}
				
				if (myPacman.getXpos() == myMap[y].length-1)
				{
					if(isteleportValid == true)
					{
						myPacman.setPos(0, myPacman.getYpos());
						isteleportValid = false;
					}
				}
				//////////////////////////////////////////////////////////////////////////////////////////////////////////
			}
		}
		
		///////idea for a trail//////////trailPac.draw(g2, (int)Math.round(blockWidth*(myPacman.getXpos())-50), (int)Math.round(blockHeight*(myPacman.getYpos())), blockWidth, blockHeight);
		Blinky.draw(g2, (int)Math.round(blockWidth*(Blinky.getXpos())), (int)Math.round(blockHeight*(Blinky.getYpos())), blockWidth, blockHeight);
		Inky.draw(g2, (int)Math.round(blockWidth*(Inky.getXpos())), (int)Math.round(blockHeight*(Inky.getYpos())), blockWidth, blockHeight);
		Clyde.draw(g2, (int)Math.round(blockWidth*Clyde.getXpos()), (int)Math.round(blockHeight*(Clyde.getYpos())), blockWidth, blockHeight);
		Pinky.draw(g2, (int)Math.round(blockWidth*(Pinky.getXpos())), (int)Math.round(blockHeight*(Pinky.getYpos())), blockWidth, blockHeight);	
				
		//allways draw pacmna after map to update poition and make it look like it move
		myPacman.draw(g2, (int)Math.round(blockWidth*(myPacman.getXpos())), (int)Math.round(blockHeight*(myPacman.getYpos())), blockWidth, blockHeight);
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	///////ever event taken place repaints screen showing movementy/////////////////////////////
	////////////////also does the score////////////////////////////
	public void actionPerformed(ActionEvent e) 
	{
		if(myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] == 0)
		{
			myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] = 5;
			myScore+=10;
		}
		if(myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] == 2)
		{
			myMap[(int)Math.round(myPacman.getYpos())][(int)Math.round(myPacman.getXpos())] = 5;
			myScore+=50;
			myPacman.BoostSpeed();
		}
		
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
		RedFollow();
		//TODO YOU FAT BALD BASTARD PEICE OF SUB HUMAN TRASH 2000 YEARS OF CONSTANT HUMAN EVOLUTION TO MAKE A HAIRLESS FUCK LIKE YOOOOOUUUUUU
		//TODO use gun an if that dont work. use more gun.
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////checks the corners around packmand and ghost to see if move is val9id///////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean isValidMove(Actor a, int direction)
	{
		
		double speed 		= a.getSpeed();
		
		double topleftX 	= a.getXpos();
		double topleftY 	= a.getYpos();
		
		double toprightX 	= a.getXpos()+0.99;
		double toprightY 	= a.getYpos();
		
		double bottomleftX 	= a.getXpos();
		double bottomleftY 	= a.getYpos()+0.99;
		
		double bottomrightX = a.getXpos()+0.99;
		double bottomrightY = a.getYpos()+0.99;
		
		if(direction == a.UP)
		{
			topleftY-=speed;
			toprightY-=speed;
		}
		if(direction == a.DOWN)
		{
			bottomleftY+=speed;
			bottomrightY+=speed;
		}
		if(direction == a.LEFT) 
		{
			topleftX-=speed;
			bottomleftX-=speed;
		}
		if(direction == a.RIGHT)
		{
			toprightX+=speed;
			bottomrightX+=speed;
		}
		if(myMap[(int)topleftY][(int)topleftX] != 1 
				&&
				myMap[(int)topleftY][(int)topleftX] != 3
				&&
				myMap[(int)toprightY][(int)toprightX] != 1
				&&
				myMap[(int)toprightY][(int)toprightX] != 3
				&& 
				myMap[(int)bottomleftY][(int)bottomleftX] != 1 
				&&
				myMap[(int)bottomleftY][(int)bottomleftX] != 3
				&& 
				myMap[(int)bottomrightY][(int)bottomrightX] != 1
				&&
				myMap[(int)bottomrightY][(int)bottomrightX] != 3)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////
	////every key press sets next state for turning///////////////////
	//////////////////////////////////////////////////////////////////
	public void keyPressed(KeyEvent e) 
	{
        if(e.getKeyChar() == 'a')
        {
        	myPacman.setnextFace(Actor.LEFT);      	
        }
        if(e.getKeyChar() == 'w')
        {
        	myPacman.setnextFace(Actor.UP);
        }
        if(e.getKeyChar() == 's')
        {
        	myPacman.setnextFace(Actor.DOWN);
        }
        if(e.getKeyChar() == 'd')
        {
        	myPacman.setnextFace(Actor.RIGHT);
        }
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void RedFollow() {
		
		int blockWidth 		= (int)Math.round((double)getWidth()/(double)myMap[0].length);
		int blockHeight 	= (int)Math.round((double)getHeight()/(double)myMap.length);
		
		double pacX 		= myPacman.getXpos();
		double pacY 		= myPacman.getYpos();
		
		double redX 		= Blinky.getXpos();
		double redY 		= Blinky.getYpos();
		
		int numy = 0;
		int numx = 0;
		
		int direction = Blinky.getFace();
		
		
	}
}

 */