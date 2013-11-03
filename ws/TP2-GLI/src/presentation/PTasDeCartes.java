package presentation;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CCarte;
import controle.ICTasDeCartes;

public class PTasDeCartes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655838145894512078L;
	private int dx;
	private int dy;
	private int nbVisibles;
	private ICTasDeCartes controle;
	private SpringLayout layout;

	public PTasDeCartes(ICTasDeCartes cTasDeCartes) {
		this.controle = cTasDeCartes;
		
		// Création et assignation du layout manager
		layout = new SpringLayout();
		setLayout(layout) ;
		
		// un tas de carte soit avoir au minimum la taille d'une carte
		layout.putConstraint(SpringLayout.EAST, this, PCarte.largeur, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, this, PCarte.hauteur, SpringLayout.NORTH, this);
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
	}
	
	public void empiler(PCarte carte) {
		this.add(carte, 0);
		int deplacementX, deplacementY;
		if(nbVisibles != 0){
			deplacementX = ((controle.getNombre() - 1) % nbVisibles) * dx;
			deplacementY = ((controle.getNombre() - 1) % nbVisibles) * dy;
		}
		else{
			deplacementX = (controle.getNombre() - 1) * dx;
			deplacementY = (controle.getNombre() - 1) * dy;
		}
		
		layout.putConstraint(SpringLayout.WEST, carte, deplacementX, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, carte, deplacementY, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, carte);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, carte);
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
		try {
			if(!controle.isVide()){
				PCarte nouveauSommet = ((CCarte)controle.getSommet()).getPresentation();
				layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, nouveauSommet);
				layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, nouveauSommet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setNbVisibles(int nbVisibles) {
		this.nbVisibles = nbVisibles;
	}
}
