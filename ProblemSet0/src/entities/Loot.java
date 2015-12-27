package entities;

import handler.Handler;

import java.awt.Color;
import java.awt.Graphics;

public class Loot extends Entity {


	
	public Loot(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.width = 20;
		this.height = 20;
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(this.xPos, this.yPos, this.width, this.height);
		
	}

	
	
}
