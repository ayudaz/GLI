package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
<<<<<<< Updated upstream
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
=======
>>>>>>> Stashed changes

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

	private JPanel successDropPanel;
	private JPanel errorDropPanel;
	
	public PTasDeCartesColorees(ICTas cTasDeCartes, final String chaine) {
		super(cTasDeCartes);
		controle = (CTasDeCartesColorees) cTasDeCartes;
		ImageIcon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/" + chaine + ".png"));
		fond = new JLabel (icone) ;
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
					System.out.println("DragEnter");
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
		setNormalState();
		theFinalEvent.acceptDrop(DnDConstants.ACTION_MOVE);
		theFinalEvent.getDropTargetContext().dropComplete(true);
		validate();
		repaint();
	}
	
	public void showAcceptTarget(boolean state) {
		if(state){
			successDropPanel.setVisible(true);
		}
		else{
			errorDropPanel.setVisible(true);
		}
	}
	
	public void setNormalState(){
		successDropPanel.setVisible(false);
		errorDropPanel.setVisible(false);		
	}

	public void finDnDInvalid() {
		theFinalEvent.rejectDrop();
	}

	
}
