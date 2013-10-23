package controle;

import presentation.PSolitaire;
import solitaire.application.Solitaire;
import solitaire.application.Usine;

public class CSolitaire extends Solitaire {
	
	private PSolitaire presentation;

	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		this.presentation = new PSolitaire(this);
	}
	
	public void initialiser(){
		super.initialiser();
		//this.presentation.initialiser(((CSabot)this.sabot).getPresentation(), 
				//((CTasDeCartesAlternees)this.pilesAlternees)., this.pilesColorees);
	}

}
