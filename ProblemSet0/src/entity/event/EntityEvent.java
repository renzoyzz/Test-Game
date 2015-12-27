package entity.event;

import java.awt.AWTEvent;

import entity.Entity;

public class EntityEvent extends AWTEvent
{
	public static final int ENTITY_FIRST = 
			AWTEvent.RESERVED_ID_MAX + 1;
	public static final int ENTITY_LAST =
			AWTEvent.RESERVED_ID_MAX + 4;
	public static final int SELECTED = ENTITY_FIRST;
	public static final int CANCEL_SELECTION = ENTITY_FIRST + 1;
	public static final int COLLISION = ENTITY_FIRST + 2;
	public static final int SPAWNED = ENTITY_FIRST + 3;
	public static final int REMOVED = ENTITY_FIRST + 4;
	
	public EntityEvent(Entity source, int id)
	{
		super(source, id);
	}
	
	
}
