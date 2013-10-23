package controle;

import presentation.PTasDeCartesAlternees;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CTasDeCartesAlternees extends TasDeCartesAlternees {
	
	private PTasDeCartesAlternees presentation;

	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		//presentation = new PTasDeCartesAlternees(this);
	}

}
