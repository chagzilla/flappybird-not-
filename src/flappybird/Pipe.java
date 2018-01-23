package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pipe {
	int top;
	int bottom;
	int height = 800;
	int width = 1000;
	int x,y, h2;
	int w = 20;
	public Random random;
	public Pipe()
	{
		random = new Random();
		top = random.nextInt(height/2);
		bottom = random.nextInt(height/2);
		x = width - 21;
		y = 100 +random.nextInt(600);
		h2 = 75 + random.nextInt(200);
		
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, 0, w, y);
		
		g.drawRect(x,  y + h2 , w, height - h2 - y);
	}
	
	public void update()
	{
		x += -5;
		
	}
	
}
