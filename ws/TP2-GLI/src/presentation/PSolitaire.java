/**
 * 
 */
package presentation;

import javax.swing.JPanel;

import controle.CSolitaire;

/**
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class PSolitaire extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4769739927354638675L;
	
	private CSolitaire controle;
	
	public PSolitaire(CSolitaire controle){
		this.controle = controle;
	}
	
	public void initialiser(PSabot sabot, PColonne[] pilesAlternees, PTasDeCartesColorees[] pilesColorees){
		this.add(sabot);
		for (PTasDeCartesColorees pTasDeCartesColorees : pilesColorees) {
			this.add(pTasDeCartesColorees);
		}
		for (PColonne pColonne : pilesAlternees) {
			this.add(pColonne);
		}

	}
}
