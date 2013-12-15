package presentation;

import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listener.MyDragGestureListener;
import listener.MyDragSourceListener;
import listener.MyDropTargetListener;
import retroaction.RetroActions;
import controle.IControleDND;

public class DragAndDrop extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9214215836406254963L;
	protected DragSource dragSource = null;
	protected DropTarget dropTarget;
	protected MyDragGestureListener myDragGestureListener;
	protected MyDropTargetListener myDropTargetListener;
	protected MyDragSourceListener myDragSourceListener = null;
	protected PTasDeCartes tasEnTransit;
	protected JFrame dragFrame = null;
	protected IControleDND controle;
	protected JPanel elementDrag;
	
	/**
	 * @return the dragFrame
	 */
	public JFrame getDragFrame() {
		return dragFrame;
	}

	public void c2p_finDragSource() {
		dragFrame.setVisible(false);
		validate();
		repaint();
	}

	public void c2p_debutDnDValide(PTasDeCartes ten) {
		tasEnTransit = ten;
		int hauteur = PCarte.hauteur;

		if (ten.getControle().getNombre() > 1) {
			hauteur += (ten.getControle().getNombre() - 1) * ten.getDy();
		}

		dragSource.startDrag(myDragGestureListener.getTheInitialEvent(), DragSource.DefaultMoveNoDrop,
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
		myDropTargetListener.getTheFinalEvent().acceptDrop(DnDConstants.ACTION_MOVE);
		myDropTargetListener.getTheFinalEvent().getDropTargetContext().dropComplete(true);
		RetroActions.finDnDValide.faireRetroAction();
	}

	public void finDnDInvalide() {
		myDropTargetListener.getTheFinalEvent().rejectDrop();
		RetroActions.finDnDInvalid.faireRetroAction();
	}

}
