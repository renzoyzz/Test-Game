package handler;

import java.awt.Graphics;
import java.util.LinkedList;

import entities.Entity;




public class Handler  {
	
	public LinkedList<Entity> entitiesList = new LinkedList<Entity>();
	
	
	public void tick() {
		for(Entity entity: this.entitiesList){
			entity.tick();
		}
		
	}
	
	public void render(Graphics g){
		for(Entity entity: this.entitiesList){
			entity.render(g);
			
		}
		
	}
	
	public void addEntity(Entity entity){
		this.entitiesList.add(entity);
		
	}
	
	public void removeEntity(Entity entity){
		this.entitiesList.remove(entity);
		
	}

	
	
	
	
	
	
}
