package presentation;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controle.CCarte;
import controle.CSabot;

public class PSabot extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1595830508186217340L;
	private CSabot controle;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;
	private DragSource ds;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;
	private RetournerSabotListener rsl = new RetournerSabotListener();
	private RetournerCarteListener rcl = new RetournerCarteListener();
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		controle = c;
		this.cachees = cachees;
		add(cachees);
		cachees.setDxDy(0, 0);
		this.visibles = visibles;
		add(visibles);
		visibles.setDxDy(20, 0);
		myDSL = new MyDragSourceListener();
		ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(visibles, DnDConstants.ACTION_MOVE, new MyDragGestureListener());
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
		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop, pc, myDSL);
	}
	
	class MyDragGestureListener implements DragGestureListener {

		/**
		 * 
		 */
		public MyDragGestureListener() {
			
		}
		
		

		/**
		 * @return the theInitialEvent
		 */
		public DragGestureEvent getTheInitialEvent() {
			return theInitialEvent;
		}



		/* (non-Javadoc)
		 * @see java.awt.dnd.DragGestureListener#dragGestureRecognized(java.awt.dnd.DragGestureEvent)
		 */
		@Override
		public void dragGestureRecognized(DragGestureEvent e) {
			// TODO Auto-generated method stub
			theInitialEvent = e;
			PCarte pc = null;
			CCarte cc = null;
			try{
				pc = (PCarte)visibles.getComponentAt(e.getDragOrigin());
				cc = pc.getControle();
			}catch(Exception ex){
				controle.p2c_debutDnD(cc);
			}
		}

	}
	
	public class MyDragSourceListener implements DragSourceListener {

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
	public class RetournerSabotListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			controle.retourner();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public class RetournerCarteListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				controle.retournerCarte();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
