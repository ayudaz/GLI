package presentation;

import java.awt.Color;
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

import controle.CCarte;
import controle.CTasDeCartes;
import controle.IControleDND;

public class DragAndDrop extends JPanel {

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
			try{
				pc = (PCarte) elementDrag.getComponentAt(e.getDragOrigin());
				cc = pc.getControle();
			}catch(Exception ex){}
			
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
        public void dragDropEnd( DragSourceDropEvent event )
        {
			controle.p2c_finDragSource(event.getDropSuccess());
            dragFrame.setVisible( false );
            validate();
            repaint();
        }

        @Override
        public void dragEnter( DragSourceDragEvent evt )
        {
        	// TODO Auto-generated method stub
        	controle.p2c_DragEnter(tasEnTransit.getControle());
        }

		@Override
		public void dragOver(DragSourceDragEvent dsde) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dropActionChanged(DragSourceDragEvent dsde) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dragExit(DragSourceEvent dse) {
			// TODO Auto-generated method stub
        	controle.p2c_DragExit(tasEnTransit.getControle());
		}
	}

	protected class MyDropTargetListener implements DropTargetListener {
		protected PTasDeCartes pTas = null;

		public MyDropTargetListener() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void dragEnter(DropTargetDragEvent event) {
			try {
				Transferable transferable = event.getTransferable();
				System.out.println("DragEnter");
				if (transferable.isDataFlavorSupported(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType))) {
					event.acceptDrag(DnDConstants.ACTION_MOVE);
					pTas = (PTasDeCartes) transferable.getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
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
			// TODO Auto-generated method stub
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}
	}

	protected class MyDragSourceMotionListener implements DragSourceMotionListener {
		public MyDragSourceMotionListener() {
			// TODO Auto-generated constructor stub
		}

		public void dragMouseMoved (DragSourceDragEvent event) {
			/*int parentX = getRootPane().getX();
            int parentY = getRootPane().getY();
            int eventX = event.getLocation().x + 10;
            int eventY = event.getLocation().y - 15;
            dragFrame.setLocation( eventX - parentX, eventY - parentY );
            repaint();*/
			dragFrame.setLocation (event.getLocation ().x
					- getRootPane ().getParent ().getX (),
					event.getLocation ().y
					- getRootPane ().getParent ().getY ()) ;
			repaint();
		} 
	}
	
	

	public void c2p_debutDnDValide(PTasDeCartes ten) {
		tasEnTransit = ten;
        dragSource.startDrag (
        		theInitialEvent, DragSource.
        		DefaultMoveNoDrop,
        		ten, myDragSourceListener);
        dragFrame = new JFrame();
        dragFrame.setSize(PCarte.hauteur,PCarte.largeur);
        dragFrame.setPreferredSize(new Dimension(PCarte.largeur,PCarte.hauteur));
        dragFrame.add( ten );
        dragFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        dragFrame.setExtendedState( JFrame.MAXIMIZED_BOTH );
        dragFrame.setUndecorated( true );
        dragFrame.setVisible( true );
        dragFrame.pack();
        repaint();
	}

	public void finDnDValide() {
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
		validate();
		repaint();
	}

	public void finDnDInvalid() {
		theFinalEvent.rejectDrop();
	}

}
