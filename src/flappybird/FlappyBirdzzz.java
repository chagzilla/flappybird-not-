package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class FlappyBirdzzz implements ActionListener, KeyListener {
	public static FlappyBirdzzz flappy;
	public Renderer renderer;
	public int width = 1000;
	public int height = 800;
	public Bird bird;
	public Pipes pipes;
	public boolean w;
	public int gameStatus = 0;
	
	public FlappyBirdzzz()
	{
		Timer timer = new Timer(20, this);
		JFrame jframe = new JFrame("Flappy Birds");
		renderer = new Renderer();
		
		jframe.setSize(width + 15, height);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(renderer);
		jframe.addKeyListener(this);
		
		timer.start();

	}
	public void start()
	{ 
		gameStatus = 2;
		bird = new Bird();
		pipes = new Pipes();
	}
	public void update()
	{
		bird.update();
		pipes.update();
		if(w)
			bird.up();
			
	}
	public void render(Graphics2D g)
	{
		if (gameStatus == 0)
		{
			//g.setColor(Color.BLACK);
			//g.fillRect(0, 0, width, height);
			//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//g.setColor(Color.WHITE);
			//g.setFont(new Font("Arial", 1, 50));
			//g.drawString("Flappy Birds", width/2 - 150, 50);
		}
		if(gameStatus == 2)
		{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		bird.render(g);
		pipes.render(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int id = arg0.getKeyCode();
				if(id == KeyEvent.VK_W)
					w = true;
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int id = arg0.getKeyCode();
				if(id == KeyEvent.VK_W)
					w = false;
				if (id == KeyEvent.VK_SHIFT)
				{
					start();
				}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (gameStatus == 2)
		{
			update();
			renderer.repaint();
		}
	}
	public static void main(String[] args)
	{
	flappy = new FlappyBirdzzz();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
