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
	
	private PSabot sabot;
	private JPanel pilesAlternees;
	private JPanel pilesColorees;
	
	private CSolitaire controle;
	
	public PSolitaire(CSolitaire controle){
		this.controle = controle;
		pilesAlternees = new JPanel();
		pilesColorees = new JPanel();
		this.add(pilesAlternees);
		this.add(pilesColorees);
	}

	/**
	 * @param sabot the sabot to set
	 */
	public void setSabot(PSabot sabot) {
		this.sabot = sabot;
	}

	public void addColonne(PColonne pileAlternees) {
		this.pilesAlternees.add(pileAlternees);
	}

	public void addPileColorees(PTasDeCartesColorees pileColorees) {
		this.pilesColorees.add(pileColorees);
	}
	
	
}
