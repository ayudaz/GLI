package presentation;

import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetEvent;

import controle.CTasDeCartes;

public class PTasDeCartesColorees extends PTasDeCartes {
	
	private DropTarget dt;
	private DropTargetEvent theFinalEvent;
	
	PCarte pc;

	public PTasDeCartesColorees(CTasDeCartes cTasDeCartes) {
		super(cTasDeCartes);
		// TODO Auto-generated constructor stub
	}
	
	public void c2p_finDnDOK(){
		theFinalEvent.acceptDrop();
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	
	public void c2p_finDnDKO(){
		theFinalEvent.rejectDrop();
	}

}
