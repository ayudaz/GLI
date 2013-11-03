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
import javax.swing.SpringLayout;

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
	private SpringLayout layout;
	private DragSource ds;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;
	private RetournerSabotListener rsl = new RetournerSabotListener();
	private RetournerCarteListener rcl = new RetournerCarteListener();
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		controle = c;
		this.cachees = cachees;
		this.visibles = visibles;
		
		// Création et assignation du layout manager
		layout = new SpringLayout();
		this.setLayout(layout);
		
		// Ajout des tas cachées et visibles au panel
		add(cachees);
		add(visibles);
		cachees.setDxDy(0, 0);
		visibles.setDxDy(15, 0);
		visibles.setNbVisibles(3);
		
		// Contraintes d'affichage du Sabot
		layout.putConstraint(SpringLayout.NORTH, cachees, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, visibles, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cachees, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, visibles, 25, SpringLayout.EAST, cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, visibles);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, visibles);
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
		
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
