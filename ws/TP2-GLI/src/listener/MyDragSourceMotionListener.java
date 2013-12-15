package listener;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceMotionListener;

import presentation.DragAndDrop;

public class MyDragSourceMotionListener implements DragSourceMotionListener {
	
	private DragAndDrop dragAndDrop;
	
	public MyDragSourceMotionListener(DragAndDrop dragAndDrop){
		this.dragAndDrop = dragAndDrop;
	}

	@Override
	public void dragMouseMoved(DragSourceDragEvent event) {
		int parentX = dragAndDrop.getRootPane().getX();
		int parentY = dragAndDrop.getRootPane().getY();
		int eventX = event.getLocation().x + 5;
		int eventY = event.getLocation().y + 15;
		dragAndDrop.getDragFrame().setLocation(eventX - parentX, eventY - parentY);
		dragAndDrop.repaint();
	}

}
