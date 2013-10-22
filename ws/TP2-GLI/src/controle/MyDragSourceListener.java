package controle;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public class MyDragSourceListener implements DragSourceListener {

	public MyDragSourceListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent e) {
		// TODO Auto-generated method stub
		controle.p2c_finDnD(e.getDropSuccess());
	}

	@Override
	public void dragEnter(DragSourceDragEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DragSourceEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DragSourceDragEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent e) {
		// TODO Auto-generated method stub

	}

}
