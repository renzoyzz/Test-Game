package entity.listener;

import java.util.EventListener;

import entity.event.EntityEvent;

public interface EntityListener extends EventListener
{
	abstract void selected(EntityEvent e);
	abstract void cancelSelection(EntityEvent e);
	abstract void collision(EntityEvent e);
	abstract void spawned(EntityEvent e);
	abstract void removed(EntityEvent e);
}
