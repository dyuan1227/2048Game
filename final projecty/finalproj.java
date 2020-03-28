import javax.swing.*;
import javax.imageio.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.applet.*;
import java.io.*;
import java.util.*;
import java.util.Random;

public class finalproj extends Applet implements KeyListener, FocusListener
{
	Image zero;
	Image two;
	Image four;
	Image eight;
	Image onesix;
	Image threetwo;
	Image sixfour;
	Image onetwoeight;
	Image twofivesix;
	Image fiveonetwo;
	Image onezerotwofour;
	Image twozerofoureight;
	int [][] tile = new int[4][4];
	int x;
	int y;
	public void init()
	{
		addKeyListener(this);
		addFocusListener(this);
		try
		{
			zero = ImageIO.read(new File("0.png"));
			two = ImageIO.read(new File("2.png"));
		}
		catch(IOException e){System.out.println("Error loading Pictures");}
		for(int i = 0; i < 4; i ++)
		{
			for(int j = 0; j < 4; j ++)
			{
				tile[i][j] = 0;
			}
		}
		x = (int)(Math.random()*4);
		y = (int)(Math.random()*4);
		tile[x][y] = 2;
		System.out.println(x+" "+y);
		x = (int)(Math.random()*4);
		y = (int)(Math.random()*4);
		while(tile[x][y]!=0)
		{
			x = (int)(Math.random()*4);
			y = (int)(Math.random()*4);
		}
		tile[x][y] = 2;
		System.out.println(x+" " +y);
	}
	public void update(Graphics g){paint(g);}
	public void paint(Graphics g)
	{
		for(int i = 0; i < 4; i ++)
		{
			for(int j = 0; j < 4; j ++)
			{
				if(tile[i][j] == 0){g.drawImage(zero,i*200,j*200,this);}
				if(tile[i][j] == 2){g.drawImage(two,i*200,j*200,this);}
				if(tile[i][j] == 4){g.drawImage(four,i*200,j*200,this);}
				if(tile[i][j] == 8){g.drawImage(eight,i*200,j*200,this);}
				if(tile[i][j] == 16){g.drawImage(onesix,i*200,j*200,this);}
				if(tile[i][j] == 32){g.drawImage(threetwo,i*200,j*200,this);}
				if(tile[i][j] == 64){g.drawImage(sixfour,i*200,j*200,this);}
				if(tile[i][j] == 128){g.drawImage(onetwoeight,i*200,j*200,this);}
				if(tile[i][j] == 256){g.drawImage(twofivesix,i*200,j*200,this);}
				if(tile[i][j] == 512){g.drawImage(fiveonetwo,i*200,j*200,this);}
				if(tile[i][j] == 1024){g.drawImage(onezerotwofour,i*200,j*200,this);}
				if(tile[i][j] == 2048){g.drawImage(twozerofoureight,i*200,j*200,this);}
			}
		}
	}
	public void focusGained(FocusEvent evt){}
	public void focusLost(FocusEvent evt){}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}


	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		System.out.println(key);
		if(key == 37)
		{

			for(int i = 1; i < 4; i ++)
			{
				for(int j = 0; j < 4; j ++)
				{
					if(tile[i][j]!=0 && tile[i-1][j] == 0)
					{

							int replace =i-1;
							while(tile[replace][j] == 0 && replace>0)
							{
								replace --;
							}

							tile[replace][j] = tile[i][j];

							if(tile[i-1][j]==tile[i][j]&&tile[i][j]!=0)
							{

								tile[i-1][j]=tile[i][j]*2;	repaint();

								tile[i][j]=0;
								System.out.println(" "+tile[i-1][j]);

					        }
					        else
					        {
					        	tile[i][j]=0;
					        	System.out.println(" "+tile[i-1][j]);
					        }



					}
				}
			}
		}
		if(key == 38)
		{

			for(int i = 0; i < 4; i ++)
			{
				for(int j = 1; j < 4; j ++)
				{
					if(tile[i][j]!=0 && tile[i][j-1] == 0)
					{




							int replace =j-1;
							while(tile[i][replace] == 0 && replace>0)
							{
								replace --;
							}
							tile[i][replace] = tile[i][j];

							if(tile[i][j]==tile[i][j-1])
							{

								tile[i][j-1]=tile[i][j]*2;
								tile[i][j]=0;

					        }


				    }
			    }
	    	}
		}
		if(key == 39)
		{
			for(int i = 0; i < 3; i ++)
			{
				for(int j = 0; j < 4; j ++)
				{
					if(tile[i][j]!=0 && tile[i+1][j] == 0)
					{




							int replace =i+1;

							while(tile[replace][j] == 0 && replace<3)
							{
								replace ++;

							}
							tile[replace][j] = tile[i][j];
							tile[i][j] = 0;

					}
				}
			}
		}
		if(key == 40)
		{


			for(int i = 0; i < 4; i ++)
			{
				for(int j = 0; j < 3; j ++)
				{
					if(tile[i][j]!=0 && tile[i][j+1] == 0)
					{




							int replace =j+1;
							while(tile[i][replace] == 0 && replace<3)
							{
								replace ++;
								System.out.println(replace);
							}
							tile[i][replace] = tile[i][j];
							tile[i][j] = 0;

					}
				}
			}
		}

		x = (int)(Math.random()*4);
		y = (int)(Math.random()*4);
		while(tile[x][y]!=0)
		{
			x = (int)(Math.random()*4);
			y = (int)(Math.random()*4);
		}
		tile[x][y] = 2;
		repaint();
	}







	public static void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while(endDelay - startDelay<n)
			endDelay = System.currentTimeMillis();
	}
}