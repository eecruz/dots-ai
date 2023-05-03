import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Graphics;
import javax.sound.sampled.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Random;
import processing.PVector;

public class World extends JFrame
{ 	
	Panel panel;
	
	public World() 
	{
		panel = new Panel();
		this.setTitle("Dots AI");
		this.setSize(800, 800); //size of the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.CYAN);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
	}
}
