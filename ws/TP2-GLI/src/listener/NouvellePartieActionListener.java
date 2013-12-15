package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Lanceur;

public class NouvellePartieActionListener implements ActionListener {
	
	private Lanceur lanceur;

	public NouvellePartieActionListener(Lanceur lanceur) {
		this.lanceur = lanceur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lanceur.nouvellePartie();
	}

}
