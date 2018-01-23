package flappybird;

import java.awt.Color;
import java.awt.Graphics;


public class Bird {

	public int x,y, width;
	public float gravity = 1;
	public float velocity;
	
	public Bird()
	{
		x = 400;
		y = 400;
		width = 25;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.drawOval(x, y, width, width);
	}
	
	public void update()
	{
		
		velocity += gravity;
		if (velocity > 18)
			velocity = 18;
		y += velocity;
		if (y > 800)
			y = 800;
	}
	
	public void up()
	{
		velocity -= 6;
	}
}
