package flappybird;

import java.awt.Graphics;
import java.util.LinkedList;

public class Pipes {
 public LinkedList<Pipe> pipes;
 int num;
 	public Pipes()
 	{
 		pipes = new LinkedList<Pipe>();
 	}
 	
 	public void render(Graphics g)
 	{
 		for(Pipe x: pipes)
 		{
 			x.render(g);
 		}
 	}
 	
 	public void update()
 	{ num ++;
 		if(pipes.size() == 0)
 			pipes.add(new Pipe());
 		
 		if(num % 50 == 0)
 		{
 			pipes.add(new Pipe());
 		}
 		
 		for(Pipe x: pipes)
 			x.update();
 	}
}
