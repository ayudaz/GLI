package listener;

import java.awt.Cursor;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import controle.IControleDND;

public class MyDragSourceListener implements DragSourceListener {
	
	private IControleDND controle;
	
	public MyDragSourceListener(IControleDND controle){
		this.controle = controle;
	}
	
	@Override
	public void dragDropEnd(DragSourceDropEvent event) {
		controle.p2c_finDragSource(event.getDropSuccess());
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		dsde.getDragSourceContext().setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {

	}

	@Override
	public void dragExit(DragSourceEvent dse) {

	}

}
