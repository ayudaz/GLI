package presentation;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import listener.RetournerCarteListener;
import listener.RetournerSabotListener;
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
	private MyDragSourceListener myDragSourceListener;
	private DragGestureEvent theInitialEvent;
	private DragSourceListener myDSL;
	private RetournerSabotListener rsl;
	private RetournerCarteListener rcl;
	private static final int DECALVISIBLE = 15;
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		this.controle = c;
		this.cachees = cachees;
		this.visibles = visibles;
		this.rcl = new RetournerCarteListener(c);
		this.rsl = new RetournerSabotListener(c);
		
		// Cr�ation et assignation du layout manager
		layout = new SpringLayout();
		this.setLayout(layout);
		
		// Ajout des tas cach�es et visibles au panel
		add(cachees);
		add(visibles);
		cachees.setDxDy(0, 0);
		visibles.setDxDy(DECALVISIBLE, 0);
		
		// Contraintes d'affichage du Sabot
		setContraintes();
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
//		setBackground(Color.BLACK);
		
		this.cachees.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// ajout d'une image de fond sur le tas de carte cachees
		ImageIcon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/fond_sabot.png"));
		JLabel fond = new JLabel(icone) ;
		cachees.add(fond);
		
		myDragSourceListener = new MyDragSourceListener();
		ds = new DragSource(); 
		ds.createDefaultDragGestureRecognizer (
				visibles, 
				DnDConstants.ACTION_MOVE,
				new MyDragGestureListener ());
		
		ds.addDragSourceMotionListener (
				new MyDragSourceMotionListener ());
		
		//dropTarget = new DropTarget (this, new MyDropTargetListener ()) ;
				
		//myDSL = new MyDragSourceListener();
//		ds = new DragSource();
//		ds.createDefaultDragGestureRecognizer(visibles, DnDConstants.ACTION_MOVE, new MyDragGestureListener());
	}
	
	public void retournerCarte() {
		setContraintes();
	}
	
	public void retourner(){
		setContraintes();
	}
	
	public void setContraintes() {
		cachees.setContraintes();
		visibles.setContraintes();
		layout.putConstraint(SpringLayout.NORTH, cachees, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, visibles, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cachees, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, visibles, 25, SpringLayout.EAST, cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, visibles);
		layout.putConstraint(SpringLayout.EAST, this, 20, SpringLayout.EAST, visibles);
	}
	
	public void activerRetournerSabot(){
		cachees.addMouseListener(rsl);
	}
	
	public void activerRetournerCarte(){
		cachees.addMouseListener(rcl);
	}

	public void desactiverRetournerSabot() {
		cachees.removeMouseListener(rsl);		
	}

	public void desactiverRetournerCarte() {
		cachees.removeMouseListener(rcl);
	}
	
	
	
	public void c2p_debutDnDKO(PCarte pc){
		
	}
	
	public void c2p_debutDnDOK(PCarte pc){
		ds.startDrag(theInitialEvent, DragSource.DefaultMoveDrop, pc, myDSL);
		System.out.println("Debut DnDOK");
		repaint();
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
			theInitialEvent = e;
			PCarte pc = null;
			CCarte cc = null;
			try{
				pc = (PCarte)visibles.getComponentAt(e.getDragOrigin());
				cc = pc.getControle();
			}catch(Exception ex){}
			controle.p2c_debutDnD(cc);
		}

	}
	
	protected class MyDragSourceMotionListener implements DragSourceMotionListener {
		public void dragMouseMoved (DragSourceDragEvent event) {
			setLocation (event.getLocation ().x - getRootPane ().getParent ().getX (), event.getLocation ().y - getRootPane ().getParent ().getY ()) ; 
		} 
	}// MyDragSourceMotionListener
	
	public class MyDragSourceListener implements DragSourceListener {

		@Override
		public void dragDropEnd(DragSourceDropEvent e) {
			// TODO Auto-generated method stub
			controle.p2c_finDnD(e.getDropSuccess());
		}

		@Override
		public void dragEnter(DragSourceDragEvent e) {
			System.out.println("DragEnter");
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
	

	

	
}
