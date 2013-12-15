package listener;

import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;

import javax.swing.JPanel;

import presentation.PCarte;
import controle.CCarte;
import controle.IControleDND;

public class MyDragGestureListener implements DragGestureListener {
	
	private DragGestureEvent theInitialEvent;
	private IControleDND controle;
	private JPanel elementDrag;
	
	public MyDragGestureListener(IControleDND controle, JPanel elementDrag){
		this.controle = controle;
		this.elementDrag = elementDrag;
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent e) {
		theInitialEvent = e;
		PCarte pc = null;
		CCarte cc = null;
		try {
			pc = (PCarte) elementDrag.getComponentAt(e.getDragOrigin());
			cc = pc.getControle();
		} catch (Exception ex) {
		}

		controle.p2c_debutDnDDrag(cc);
	}
	
	/**
	 * @return the theInitialEvent
	 */
	public DragGestureEvent getTheInitialEvent() {
		return theInitialEvent;
	}

}
