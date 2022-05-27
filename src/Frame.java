import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener, MouseListener{
	
	// instance variables - "global" variable
	private final static String PRESSED = "pressed ";
	private final static String RELEASED = "released ";
	
	long timeLeft;

	private JComponent component;
	private Timer timer;
	private Map<String, Point> pressedKeys = new HashMap<String, Point>();

	
	Basketball b = new Basketball(900,890);
	Player1 p1 = new Player1(1000,800);
	Scoreboard s = new Scoreboard(575, -150);
	HoopLeft hL = new HoopLeft(-30,475);
	HoopRight hR = new HoopRight(1435, 442);
	Floor f = new Floor(0,0);
	
	
	
	boolean move = true;
	
	Set<Character> Keyspressed = new HashSet<Character>();
	
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		f.paint(g);
		b.paint(g);
		p1.paint(g);
		s.paint(g);
		hL.paint(g);
		hR.paint(g);
		
		g.drawLine(b.getX()+30, b.getY()+20, b.getX()+105, b.getY()+20);
		g.drawLine(b.getX()+105, b.getY()+20, b.getX()+105, b.getY()+135);
		g.drawLine(b.getX()+105, b.getY()+135, b.getX()+30, b.getY()+135);
		g.drawLine(b.getX()+30, b.getY()+135, b.getX()+30, b.getY()+20);
		
		g.drawLine(p1.getX()+160, p1.getY(), p1.getX()+240, p1.getY());
		g.drawLine(p1.getX()+240, p1.getY(), p1.getX()+240, p1.getY()+200);
		g.drawLine(p1.getX()+240, p1.getY()+200, p1.getX()+160, p1.getY()+200);
		g.drawLine(p1.getX()+160, p1.getY()+200, p1.getX()+160, p1.getY());
		
		Font plainFont = new Font("Serif",Font.BOLD,72);
		g.setFont(plainFont);
		g.setColor(Color.RED);
		g.drawString(""+Basketball.score, 845, 131);
		
		if(Player1.hasBall() == true)
		{
			b.y = p1.getY()+80; //min y of ball (+20) = half of max and min y of p1 (+100), so set Y of ball to p1 y + 80.
			b.x = p1.getX()+95; //max x of ball (+105) = half of min and max x of p1 (+200), so set x of ball to p1 x + 95
		}
	}
	
	public static void main(String[] arg)
	{
		Frame f = new Frame();
		
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Emperor2K");
		f.setSize(new Dimension(1950, 1100));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	Timer t;
		
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

	public void resetEverything()
	{
		b.setX((int) (Math.random()*(1200) +100));
		b.setY(890);
		Player1.shotInPlace = false;
		HoopLeft.changePicture("/imgs/hoopleft.png");
		p1.setX(1000);
		p1.setY(800);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e){
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == 87) //W (move left)
		{
			Player1.moveLeft();
		}
		if(e.getKeyCode() == 82) //R (move right)
		{
			Player1.moveRight();
		}
		if(e.getKeyCode()==37)
		{
			Basketball.x -=5;
		}
		if(e.getKeyCode()==38)
		{
			Basketball.y-=5;
		}
		if(e.getKeyCode()==39)
		{
			Basketball.x+=5;
		}
		if(e.getKeyCode()==40)
		{
			Basketball.y+=5;
		}
		if(e.getKeyCode()==32)
		{
			
			Player1.shoot();
		}
		if(e.getKeyCode()==75)
		{
			resetEverything();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
