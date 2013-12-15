package presentation;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JPanel;

import controle.ICTas;

public class PTasDeCartes extends JPanel implements IPTas, Transferable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655838145894512078L;
	private int dx;
	private int dy;
	private ICTas controle;

	public PTasDeCartes(ICTas cTasDeCartes) {
		this.controle = cTasDeCartes;

		// Cr�ation et assignation du layout manager
		setLayout(null);
		Dimension d = new Dimension(PCarte.largeur, PCarte.hauteur);
		setPreferredSize(d);

		// Pour que le fond du jeu soit visible
		setOpaque(false);
	}

	public void empiler(PCarte carte) {
		this.add(carte, 0);
		int deplacementX, deplacementY;
		deplacementX = (controle.getNombre() - 1) * dx;
		deplacementY = (controle.getNombre() - 1) * dy;

		Insets insets = getInsets();
		Dimension size = carte.getPreferredSize();
		carte.setBounds(deplacementX + insets.left,
				deplacementY + insets.right, size.width, size.height);
		Dimension dTas = this.getPreferredSize();
		dTas.width = PCarte.largeur + deplacementX;
		dTas.height = PCarte.hauteur + deplacementY;
		this.setPreferredSize(dTas);
		repaint();
	}

	/*
	 * DECALAGE EN PIXEL QUAND ON DEPILE LA CARTE - Droite pour le sabot - Bas
	 * pour la colonne
	 */
	public void setDxDy(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void depiler(PCarte carte) {
		this.remove(carte);
		int deplacementX, deplacementY;
		deplacementX = (controle.getNombre() - 1) * dx;
		deplacementY = (controle.getNombre() - 1) * dy;
		Dimension dTas = this.getPreferredSize();
		dTas.width = PCarte.largeur + deplacementX;
		dTas.height = PCarte.hauteur + deplacementY;
		this.setPreferredSize(dTas);
		repaint();
	}

	public ICTas getControle() {
		return controle;
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		Object result = null;
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			result = this;
		}
		return (result);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		DataFlavor data[] = new DataFlavor[1];
		try {
			data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
		} catch (java.lang.ClassNotFoundException e) {
		}
		return (data);
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		boolean result = false;
		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
			result = true;
		}
		return (result);
	}

	public int getDy() {
		return dy;
	}

}
