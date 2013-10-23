package presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import controle.ICTasDeCartes;

public class PTasDeCartes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655838145894512078L;
	private int dx;
	private int dy;
	private ICTasDeCartes controle;

	public PTasDeCartes(ICTasDeCartes cTasDeCartes) {
		this.controle = cTasDeCartes;		

		// le JPanel
		setLayout (null) ;
		setBackground (Color.yellow) ;
		setOpaque (true);
		Dimension d = new Dimension(PCarte.largeur, PCarte.hauteur);
		setSize (d) ;
		setPreferredSize(getSize());
	}
	
	public void empiler(PCarte carte) {
		this.add(carte, 0);
		int deplacementX = (controle.getNombre() - 1) * dx;
		int deplacementY = (controle.getNombre() - 1) * dy;
		if(controle.getNombre() > 1)
			setBounds(getBounds().x, getBounds().y, getBounds().width + dx, getBounds().height + dy);
		setPreferredSize(getSize());
		carte.setLocation(carte.getBounds().x + deplacementX, carte.getBounds().y + deplacementY);
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

}
