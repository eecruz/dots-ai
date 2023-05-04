
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import javax.swing.JPanel;
import processing.PVector;

public class Panel extends JPanel implements ActionListener
{
	private Population test;
	public PVector goal  = new PVector(400, 10);
	Timer timer;
	
	public Panel()
	{
		this.setPreferredSize(new Dimension(800, 800));
		this.setBackground(Color.WHITE);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new MyKeyAdapter());
		
		test = new Population(1000, this);//create a new population with 1000 members
		timer = new Timer(10, this);
	}
	
	void draw(Graphics g) 
	{ 

		//draw goal
		g.setColor(Color.BLUE);
		g.fillOval((int) goal.x, (int) goal.y, 10, 10);

		//draw obstacle(s)
//		g.setColor(Color.BLUE);
//
//		g.fillRect(0, 300, 600, 10);


		if (test.allDotsDead()) 
		{
			//genetic algorithm
			test.calculateFitness();
			test.naturalSelection();
			test.mutateDemBabies();
		} 
		
		else 
		{
			//if any of the dots are still alive then update and then show them

			test.update();
			test.show(g);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	public void timerToggle()
	{
		if(timer.isRunning())
			timer.stop();
		else
			timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(timer.isRunning())
		{
			repaint();
		}
	}
	
	public class MyKeyAdapter extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
				timerToggle();
				
		}
	}
}
