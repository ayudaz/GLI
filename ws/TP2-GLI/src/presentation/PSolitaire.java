/**
 * 
 */
package presentation;

import java.awt.Color;

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
	
	private JPanel sabot;
	private JPanel pilesAlternees;
	private JPanel pilesColorees;
	
	private CSolitaire controle;
	
	public PSolitaire(CSolitaire controle){
		this.controle = controle;
		pilesAlternees = new JPanel();
		pilesAlternees.setBackground(Color.CYAN);
		pilesColorees = new JPanel();
		pilesColorees.setBackground(Color.MAGENTA);
		sabot = new JPanel();
		sabot.setBackground(Color.PINK);
		this.add(sabot);
		this.add(pilesColorees);
		this.add(pilesAlternees);
	}

	/**
	 * @param sabot the sabot to set
	 */
	public void setSabot(PSabot sabot) {
		this.sabot.add(sabot);
	}

	public void addColonne(PColonne pileAlternees) {
		this.pilesAlternees.add(pileAlternees);
	}

	public void addPileColorees(PTasDeCartesColorees pileColorees) {
		this.pilesColorees.add(pileColorees);
	}
	
	
}
