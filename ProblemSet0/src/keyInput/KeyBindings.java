package keyInput;

public class KeyBindings {

	private Key moveUp;
	private Key moveDown;
	private Key moveLeft;
	private Key moveRight;
	
	public KeyBindings() {
		this.moveUp = new Key(87);
		this.moveDown = new Key(83);
		this.moveLeft = new Key(68);
		this.moveRight = new Key(65);
	}
	
	
	
	
	public int getMoveUp(){
		return this.moveUp.getKeyCode();
	}
	
	public int getMoveDown(){
		return this.moveDown.getKeyCode();
	}
	
	public int getMoveLeft(){
		return this.moveLeft.getKeyCode();
	}
	
	public int getMoveRight(){
		return this.moveRight.getKeyCode();
	}
	
	
	
}
