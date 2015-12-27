package entities;

import handler.Handler;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity{

	
	
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.velocity = 10;
		this.width = 50;
		this.height = 50;
		
	}
	


	public void tick() {
		this.movePlayer();
		this.collision();
		
	}
	
	private void movePlayer(){
		if(this.moveDirection[0]){
			this.yPos -= this.velocity;
		} else if(this.moveDirection[1]){
			this.yPos += this.velocity;
		}
		
		if(this.moveDirection[2]){
			this.xPos += this.velocity;
		} else if(this.moveDirection[3]){
			this.xPos -= this.velocity;
		}
	}



	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(this.xPos, this.yPos, this.width, this.height);
		
	}
	
	protected void collision() {
		for(Entity entity : this.handler.entitiesList){
			
			if(entity.getId() == ID.Loot){
				
				//Player touches loot
				if(this.getBounds().intersects(entity.getBounds())){
					this.handler.entitiesList.remove(entity);
						System.out.println("touching");
					
				}
			}
			
			
		}
	}
	
	

	
	
	
	
	



	

}
