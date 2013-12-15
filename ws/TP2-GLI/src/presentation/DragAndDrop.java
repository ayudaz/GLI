package presentation;

import java.awt.Cursor;
import java.awt.Dimension;
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

import javax.swing.JFrame;
import javax.swing.JPanel;

import retroaction.RetroActions;
import controle.CCarte;
import controle.CTasDeCartes;
import controle.IControleDND;

public class DragAndDrop extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214215836406254963L;
	protected DragSource dragSource = null;
	protected DropTarget dropTarget;
	protected DragGestureEvent theInitialEvent;
	protected DropTargetDropEvent theFinalEvent;
	protected MyDragSourceListener myDragSourceListener = null;
	protected PTasDeCartes tasEnTransit;
	protected JFrame dragFrame = null;
	protected IControleDND controle;
	protected JPanel elementDrag;

	public class MyDragGestureListener implements DragGestureListener {

		@Override
		public void dragGestureRecognized(DragGestureEvent e) {
			theInitialEvent = e;
			PCarte pc = null;
			CCarte cc = null;
			try {
				pc = (PCarte) elementDrag.getComponentAt(e.getDragOrigin());
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
			System.out.println("dragEnter");
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
				e.printStackTrace();
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

	public void finDnDValide() {
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
		RetroActions.finDnDValide.faireRetroAction();
	}

	public void finDnDInvalide() {
		theFinalEvent.rejectDrop();
		RetroActions.finDnDInvalid.faireRetroAction();
	}

}
