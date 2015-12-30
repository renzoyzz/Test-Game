package entities;

public enum AnimationState {

	UP(0),
	DOWN(1),
	LEFT(2),
	RIGHT(3);
	
	private int ID;
	private AnimationState (int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
}
