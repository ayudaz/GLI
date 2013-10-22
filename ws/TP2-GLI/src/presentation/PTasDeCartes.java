package presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.CCarte;
import controle.CTasDeCartes;

public class PTasDeCartes extends JPanel {

	private int dx;
	private int dy;
	private CTasDeCartes controle;

	public PTasDeCartes(CTasDeCartes cTasDeCartes) {
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
		this.add(carte);
	}
	
	/*
	 * DECALAGE EN PIXEL QUAND ON DEPILE LA CARTE
	 * - Droite pour le sabot
	 * - Bas pour la colonne
	 */	
	public void setDxDy(int dx, int dy){
		this.dx = dx;
		this.dy = dy;
		Dimension d = new Dimension(PCarte.largeur + controle.getNombre()* dx, PCarte.hauteur + controle.getNombre()*dy);
		setSize (d) ;
		repaint();
	}

}
