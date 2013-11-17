package controle;

import presentation.PTasDeCartesAlternees;
import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements ICTas {
	
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

	public void empiler (Carte carte){
		if(isVide() || isEmpilable(carte)){
			super.empiler(carte);
			try {
				if(carte == getSommet()){
					presentation.empiler(((CCarte)carte).getPresentation());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void depiler() throws Exception {	
		Carte carte;
		carte = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)carte).getPresentation());
	}
	
	
}
