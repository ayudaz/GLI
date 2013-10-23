package controle;

import presentation.PColonne;
import solitaire.application.Colonne;
import solitaire.application.Usine;

public class CColonne extends Colonne {
	
	private PColonne presentation;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		
		presentation = new PColonne(this);
	}

	public PColonne getPresentation() {
		return presentation;
	}

}
