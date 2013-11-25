package presentation;

import java.awt.datatransfer.UnsupportedFlavorException;
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

import controle.CTasDeCartesColorees;
import controle.ICTas;

public class PTasDeCartesColorees extends PTasDeCartes {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 487458044886830072L;

	private DropTarget dropTargetListener;
    private DropTargetDropEvent theFinalEvent;    
    private MyDropTargetListener myDropTargetListener;
    
	private CTasDeCartesColorees controle;
	private	PTasDeCartes ptas;
	private JLabel fond;

	public PTasDeCartesColorees(ICTas cTasDeCartes, final String chaine) {
		super(cTasDeCartes);
		ImageIcon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/" + chaine + ".png"));
		fond = new JLabel (icone) ;
		add(fond);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		myDropTargetListener = new MyDropTargetListener();
		dropTargetListener = new DropTarget(this, myDropTargetListener);
	}
	
	public void c2p_finDnDOK(){
		theFinalEvent.acceptDrop(theFinalEvent.getDropAction());
		theFinalEvent.getDropTargetContext().dropComplete(true);
	}
	
	public void c2p_finDnDKO(){
		theFinalEvent.rejectDrop();
	}

	public void showEmpilable() {
		// TODO Auto-generated method stub
		
	}

	public void showNonEmpilable() {
		// TODO Auto-generated method stub
		
	}

	public void c2p_showNeutre() {
		// TODO Auto-generated method stub
		
	}
	
	public class MyDropTargetListener implements DropTargetListener {

		@Override
		public void dragEnter(DropTargetDragEvent e) {
			// TODO V�rifier que pc est pas null !!!!!!!!
			try {
				ptas = (PTasDeCartes) e.getTransferable().getTransferData(null);
			} catch (UnsupportedFlavorException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			controle.p2c_dragEnter(ptas.getControle());
		}

		@Override
		public void dragExit(DropTargetEvent e) {
			controle.p2c_dragExit(ptas.getControle());		
		}

		@Override
		public void dragOver(DropTargetDragEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void drop(DropTargetDropEvent e) {
			// TODO le r�cup�rer de PTasDeCarteColor�s.
			theFinalEvent = e;
			controle.p2c_drop(ptas.getControle());
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
