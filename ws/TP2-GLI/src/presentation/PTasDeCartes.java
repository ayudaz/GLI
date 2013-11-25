package presentation;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CCarte;
import controle.CTasDeCartes;
import controle.ICTas;

public class PTasDeCartes extends JPanel implements IPTas, Transferable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655838145894512078L;
	private int dx;
	private int dy;
	private ICTas controle;
	private SpringLayout layout;

	public PTasDeCartes(ICTas cTasDeCartes) {
		this.controle = cTasDeCartes;
		
		// Cr�ation et assignation du layout manager
		layout = new SpringLayout();
		setLayout(layout) ;
		
		//ajout des contraintes sur le tas de carte
		setContraintes();
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
//		setBackground(Color.BLUE);
	}
	
	public void setContraintes() {
		// un tas de carte soit avoir au minimum la taille d'une carte
		layout.putConstraint(SpringLayout.EAST, this, PCarte.largeur, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, this, PCarte.hauteur, SpringLayout.NORTH, this);
		int deplacementX, deplacementY;
		deplacementX = (controle.getNombre() - 1) * dx;
		deplacementY = (controle.getNombre() - 1) * dy;
		if(controle.getNombre() > 0){
			layout.putConstraint(SpringLayout.EAST, this, PCarte.largeur+deplacementX, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.SOUTH, this, PCarte.hauteur+deplacementY, SpringLayout.NORTH, this);
		}
		
	}
	
	public void empiler(PCarte carte) {
		this.add(carte, 0);
		int deplacementX, deplacementY;
		deplacementX = (controle.getNombre() - 1) * dx;
		deplacementY = (controle.getNombre() - 1) * dy;
		
		layout.putConstraint(SpringLayout.WEST, carte, deplacementX, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, carte, deplacementY, SpringLayout.NORTH, this);
	}
	
	/*
	 * DECALAGE EN PIXEL QUAND ON DEPILE LA CARTE
	 * - Droite pour le sabot
	 * - Bas pour la colonne
	 */	
	public void setDxDy(int dx, int dy){
		this.dx = dx;
		this.dy = dy;
	}

	public void depiler(PCarte carte) {
		this.remove(carte);
	}
	 @Override
	    public Object getTransferData( DataFlavor flavor ) throws UnsupportedFlavorException, IOException
	    {
	        Object result = null;
	        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
	            result = this;
	        }
	        return (result);
	    }

	    @Override
	    public DataFlavor[] getTransferDataFlavors()
	    {
	        DataFlavor data[] = new DataFlavor[1];
	        try {
	            data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
	        } catch (java.lang.ClassNotFoundException e) {
	        }
	        return (data);
	    }

	    @Override
	    public boolean isDataFlavorSupported( DataFlavor flavor )
	    {
	        boolean result = false;
	        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
	            result = true;
	        }
	        return (result);
	    }

		public CTasDeCartes getControle() {
			// TODO Auto-generated method stub
			return (CTasDeCartes) controle;
		}

}
