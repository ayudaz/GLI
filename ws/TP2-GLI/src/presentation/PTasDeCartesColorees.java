package presentation;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import presentation.DragAndDrop.MyDropTargetListener;
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
    private CTasDeCartesColorees controle;
    
    private	PTasDeCartes ptas;
	private JLabel fond;

	public PTasDeCartesColorees(ICTas cTasDeCartes, final String chaine) {
		super(cTasDeCartes);
		controle = (CTasDeCartesColorees) cTasDeCartes;
		ImageIcon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/" + chaine + ".png"));
		fond = new JLabel (icone) ;
		add(fond);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		

		dropTarget = new DropTarget(this, new MyDropTargetListener());
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
				
				if (transferable.isDataFlavorSupported(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType))) {
					event.acceptDrag(DnDConstants.ACTION_MOVE);
					pTas = (PTasDeCartes) transferable.getTransferData(new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType));
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			// TODO Auto-generated method stub
			
		}
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
