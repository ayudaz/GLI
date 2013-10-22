package presentation;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import controle.CTasDeCartes;
import controle.CTasDeCartesColorees;

public class PTasDeCartesColorees extends PTasDeCartes {
	
	private DropTarget dt;
	private DropTargetDropEvent theFinalEvent;
	private CTasDeCartesColorees controle;
	private	PCarte pc;

	public PTasDeCartesColorees(CTasDeCartes cTasDeCartes) {
		super(cTasDeCartes);
		// TODO Auto-generated constructor stub
	}
	
	public void c2p_finDnDOK(){
		theFinalEvent.acceptDrop(theFinalEvent.getDropAction());
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	
	public void c2p_finDnDKO(){
		theFinalEvent.rejectDrop();
	}

	public void showEmpilable() {
		// TODO Auto-generated method stub
		
	}

	public void showNonEmpilable() {
		// TODO Auto-generated method stub
		
	}

	public void c2p_showNeutre() {
		// TODO Auto-generated method stub
		
	}
	
	public class MyDropTargetListener implements DropTargetListener {

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
}
