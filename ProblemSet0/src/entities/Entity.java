package entities;

import handler.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	protected int xPos;
	protected int yPos;
	protected int velX;
	protected int velY;
	protected int velocity;
	protected boolean[] moveDirection = {false, false, false, false};
	protected ID id;
	protected int width;
	protected int height;
	protected Handler handler;
	
	
	
	public Entity (int x, int y, ID id, Handler handler) {
		
		this.xPos = x;
		this.yPos = y;
		this.velX = 0;
		this.velY = 0;
		this.id = id;
		this.handler = handler;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getX() {
		return this.xPos;
		
	}

	public void setX(int x){
		this.xPos = x;
		
	}
	
	public int getY(){
		return this.yPos;
		
	}
	
	public void setY(int y) {
		this.yPos = y;
	}
	
	public ID getId(){
		return this.id;
		
	}
	
	public void setId(ID id){
		this.id = id;
		
	}
	
	public void toggleDirection (int direction) {
		this.moveDirection[direction] = this.moveDirection[direction] ? false: true;
	
	}
	
	public boolean getMoveDirectionState(int direction) {
		return this.moveDirection[direction];
	}
	
	public void setVelX(int direction){
		this.velX = this.velocity * direction;
	}
	
	public void setVelY(int direction){
		this.velY = this.velocity * direction;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.xPos, this.yPos, this.width, this.height);
	}
	

	
	
	
	
	
	
	
	
	
}
