package presentation;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

public class MyDropTargetListener implements DropTargetListener {

	public MyDropTargetListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dragEnter(DropTargetDragEvent e) {
		// TODO Vérifier que pc est pas null !!!!!!!!
		pc = (PCarte)e.getTransferable().getTransferData(...);
		controle.p2c_dragEnter(pc.getControle());
	}

	@Override
	public void dragExit(DropTargetEvent e) {
		controle.p2c_dragExit(pc.getControle());		
	}

	@Override
	public void dragOver(DropTargetDragEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent e) {
		// TODO le récupérer de PTasDeCarteColorés.
		theFinalEvent = e;
		controle.p2c_drop(pc.getControle());
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent e) {
		// TODO Auto-generated method stub

	}

}
