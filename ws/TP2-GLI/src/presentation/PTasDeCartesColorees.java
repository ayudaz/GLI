package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import retroaction.RetroActions;
import controle.CCarte;
import controle.CTasDeCartes;
import controle.CTasDeCartesColorees;
import controle.ICTas;

public class PTasDeCartesColorees extends PTasDeCartes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 487458044886830072L;

	private DropTarget dropTarget;
	private DropTargetDropEvent theFinalEvent;
	private DragGestureEvent theInitialEvent;
	
	private DragSource dragSource;
	private MyDragSourceListener myDragSourceListener;
	private JFrame dragFrame;
	private PTasDeCartes tasEnTransit;
	
	private CTasDeCartesColorees controle;

	private PTasDeCartes ptas;
	private JLabel fond;

	private JPanel successDropPanel;
	private JPanel errorDropPanel;

	public PTasDeCartesColorees(ICTas cTasDeCartes, final String chaine) {
		super(cTasDeCartes);
		controle = (CTasDeCartesColorees) cTasDeCartes;
		ImageIcon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/"
				+ chaine + ".png"));
		fond = new JLabel(icone);
		add(fond);
		Insets insets = getInsets();
		Dimension size = fond.getPreferredSize();
		fond.setBounds(insets.left, insets.right, size.width, size.height);

		successDropPanel = new JPanel();
		successDropPanel.setBackground(new Color(.0f, .7f, .0f, .8f));
		successDropPanel.setPreferredSize(new Dimension(PCarte.largeur, 600));
		successDropPanel.setSize(new Dimension(PCarte.largeur, 600));
		successDropPanel.setOpaque(true);
		successDropPanel.setVisible(false);

		errorDropPanel = new JPanel();
		errorDropPanel.setBackground(new Color(.8f, .0f, .0f, .8f));
		errorDropPanel.setPreferredSize(new Dimension(PCarte.largeur, 600));
		errorDropPanel.setSize(new Dimension(PCarte.largeur, 600));
		errorDropPanel.setOpaque(true);
		errorDropPanel.setVisible(false);

		add(successDropPanel);
		add(errorDropPanel);

		dropTarget = new DropTarget(this, new MyDropTargetListener());
		// Elements et listeners pour le DnD
		myDragSourceListener = new MyDragSourceListener();
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener());
		dragSource
				.addDragSourceMotionListener(new MyDragSourceMotionListener());
	}
	
	public class MyDragGestureListener implements DragGestureListener {

		@Override
		public void dragGestureRecognized(DragGestureEvent e) {
			theInitialEvent = e;
			PCarte pc = null;
			CCarte cc = null;
			try {
				pc = (PCarte) getComponentAt(e.getDragOrigin());
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
	
	protected class MyDragSourceMotionListener implements
	DragSourceMotionListener {
	public MyDragSourceMotionListener() {
		}
		
		public void dragMouseMoved(DragSourceDragEvent event) {
			int parentX = getRootPane().getX();
			int parentY = getRootPane().getY();
			int eventX = event.getLocation().x + 5;
			int eventY = event.getLocation().y + 15;
			dragFrame.setLocation(eventX - parentX, eventY - parentY);
			repaint();
		}
	}
	
	public class MyDragSourceListener implements DragSourceListener {
		
		@Override
		public void dragDropEnd(DragSourceDropEvent event) {
			controle.p2c_finDragSource(event.getDropSuccess());
			dragFrame.setVisible(false);
			validate();
			repaint();
		}

		@Override
		public void dragEnter(DragSourceDragEvent dsde) {
			dsde.getDragSourceContext().setCursor(
					new Cursor(Cursor.MOVE_CURSOR));
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

	protected class MyDropTargetListener implements DropTargetListener {
		protected PTasDeCartes pTas = null;

		public MyDropTargetListener() {
		}

		@Override
		public void dragEnter(DropTargetDragEvent event) {
			try {
				Transferable transferable = event.getTransferable();

				if (transferable.isDataFlavorSupported(new DataFlavor(
						DataFlavor.javaJVMLocalObjectMimeType))) {
					event.acceptDrag(DnDConstants.ACTION_MOVE);
					pTas = (PTasDeCartes) transferable
							.getTransferData(new DataFlavor(
									DataFlavor.javaJVMLocalObjectMimeType));
					controle.p2c_DragEnter(pTas.getControle());
				}

			} catch (Exception e) {
			}
		}

		@Override
		public void dragExit(DropTargetEvent event) {
			controle.p2c_DragExit(pTas.getControle());
		}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			theFinalEvent = dtde;
			controle.p2c_finDropTarget((CTasDeCartes) pTas.getControle());
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {

		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {

		}
	}

	public void finDnDValide() {
		setNormalState();
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
		validate();
		repaint();
	}
	
	public void c2p_debutDnDValide(PTasDeCartes ten) {
		tasEnTransit = ten;
		int hauteur = PCarte.hauteur;

		if (ten.getControle().getNombre() > 1) {
			hauteur += (ten.getControle().getNombre() - 1) * ten.getDy();
		}

		dragSource.startDrag(theInitialEvent, DragSource.DefaultMoveNoDrop,
				ten, myDragSourceListener);
		dragFrame = new JFrame();
		dragFrame.setSize(PCarte.hauteur, PCarte.largeur);
		dragFrame.setPreferredSize(new Dimension(PCarte.largeur, hauteur));
		dragFrame.add(ten, 0);
		dragFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dragFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		dragFrame.setUndecorated(true);
		dragFrame.setVisible(true);
		dragFrame.pack();
		repaint();
        RetroActions.debutDnDValide.faireRetroAction();
	}

	public void showAcceptTarget(boolean state) {
		if (state) {
			successDropPanel.setVisible(true);
		} else {
			errorDropPanel.setVisible(true);
		}
	}

	public void setNormalState() {
		successDropPanel.setVisible(false);
		errorDropPanel.setVisible(false);
	}

	public void finDnDInvalide() {
		theFinalEvent.rejectDrop();
	}

}
