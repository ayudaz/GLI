package listener;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import presentation.PTasDeCartes;
import controle.CTasDeCartes;
import controle.IControleDND;

public class MyDropTargetListener implements DropTargetListener {

	protected PTasDeCartes pTas = null;
	private IControleDND controle;
	private DropTargetDropEvent theFinalEvent;

	public MyDropTargetListener(IControleDND controle) {
		this.controle = controle;
	}

	/**
	 * @return the theFinalEvent
	 */
	public DropTargetDropEvent getTheFinalEvent() {
		return theFinalEvent;
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
