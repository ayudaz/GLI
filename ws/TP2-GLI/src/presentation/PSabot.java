package presentation;

import java.awt.dnd.DragSource;

import javax.swing.JPanel;

import controle.CSabot;
import controle.TasDeCartes;

public class PSabot extends JPanel{
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;
	private DragSource ds;
	private RetournerSabotListener rsl = new RetournerSabotListener();
	private RetournerCarteListener rcl = new RetournerCarteListener();
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		//...
		this.cachees = cachees;
		add(cachees);
		cachees.setDxDy(0, 0);
		this.visibles = visibles;
		add(visibles);
		visibles.setDxDy(20, 0);
		
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(visibles, Move, new MyDragGestureListener());
	}
	
	public void activerRetournerSabot(){
		cachees.addMouseListener(rsl);
	}
	
	public void activerRetournerCarte(){
		cachees.addMouseListener(rcl);
	}

	public void desactiverRetournerSabot() {
		// TODO Auto-generated method stub
		
	}

	public void desactiverRetournerCarte() {
		// TODO Auto-generated method stub
		
	}
	
	public void c2p_debutDnDKO(PCarte pc){
		
	}
	
	public void c2p_debutDnDOK(PCarte pc){
		ds.startDrag(theInitialEvent, MOVE, pc, myDSL);
	}
}
