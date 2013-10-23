package controle;

import presentation.PTasDeCartesAlternees;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements ICTasDeCartes {
	
	private PTasDeCartesAlternees presentation;

	public CTasDeCartesAlternees(String nom, Usine usine) {
		super(nom, usine);
		presentation = new PTasDeCartesAlternees(this);
	}

	/**
	 * @return the presentation
	 */
	public PTasDeCartesAlternees getPresentation() {
		return presentation;
	}

}
