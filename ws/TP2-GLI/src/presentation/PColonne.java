package presentation;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CColonne;

public class PColonne extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6012710342824704043L;
	private CColonne controle;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;
	private SpringLayout layout;

	public PColonne(CColonne controle, PTasDeCartes cachees, PTasDeCartesAlternees visibles) {
		this.controle = controle;
		this.cachees = cachees;
		this.visibles = visibles;
		// SpringLayout
		layout = new SpringLayout();
		this.setLayout(layout);
		
		// ajout des composants au panel
		this.add(cachees);
		cachees.setDxDy(0, 10);
		this.add(visibles,0);
		visibles.setDxDy(0, 10);
		
		// ajoute les contraintes sur la colonne
		layout.putConstraint(SpringLayout.WEST, cachees, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, cachees, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, visibles, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, visibles, -86, SpringLayout.SOUTH, cachees);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, visibles);
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
	}

	public void cacherCachees() {
		layout.putConstraint(SpringLayout.NORTH, visibles, -96, SpringLayout.SOUTH, cachees);
	}

}
