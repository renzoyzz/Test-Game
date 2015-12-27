package keyInput;

import handler.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entities.Entity;
import entities.ID;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private KeyBindings keyBindings;
	
	public KeyInput (Handler handler){
		this.handler = handler;
		this.keyBindings = new KeyBindings();
	}
	
	
	
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(Entity entity: this.handler.entitiesList){

			if(entity.getId() == ID.Player){
				System.out.println(this.keyBindings.getMoveUp());
				System.out.println(key);
				if(key == this.keyBindings.getMoveUp() && !entity.getMoveDirectionState(0)) entity.toggleDirection(0);
				if(key == this.keyBindings.getMoveDown() && !entity.getMoveDirectionState(1)) entity.toggleDirection(1);
				if(key == this.keyBindings.getMoveLeft() && !entity.getMoveDirectionState(2)) entity.toggleDirection(2);
				if(key == this.keyBindings.getMoveRight() && !entity.getMoveDirectionState(3)) entity.toggleDirection(3);
				
				
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(Entity entity: this.handler.entitiesList){

			if(entity.getId() == ID.Player){
				if(key == this.keyBindings.getMoveUp()) entity.toggleDirection(0);
				if(key == this.keyBindings.getMoveDown()) entity.toggleDirection(1);
				if(key == this.keyBindings.getMoveLeft()) entity.toggleDirection(2);
				if(key == this.keyBindings.getMoveRight()) entity.toggleDirection(3);
				
			}
		}
	}
	
}
