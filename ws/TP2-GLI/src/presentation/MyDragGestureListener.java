/**
 * 
 */
package presentation;

import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.beans.Visibility;

import controle.CCarte;

/**
 * @author lelievret
 *
 */
public class MyDragGestureListener implements DragGestureListener {

	/**
	 * 
	 */
	public MyDragGestureListener() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.awt.dnd.DragGestureListener#dragGestureRecognized(java.awt.dnd.DragGestureEvent)
	 */
	@Override
	public void dragGestureRecognized(DragGestureEvent e) {
		// TODO Auto-generated method stub
		DragGestureEvent theInitialEvent = e;
		PCarte pc = null;
		CCarte cc = null;
		try{
			pc = (PCarte)visibles.getComponentAt(e.getDragOrigin());
			cc = pc.getControle();
		}catch(Exception e){
			controle.p2c_debutDnD(cc);
		}
	}

}
