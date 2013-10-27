package controle;

import presentation.PTasDeCartesColorees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CTasDeCartesColorees extends TasDeCartesColorees implements ICTasDeCartes {
	
	private PTasDeCartesColorees presentation;
	
	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		this.presentation = new PTasDeCartesColorees(this);
	}

	/**
	 * @return the presentation
	 */
	public PTasDeCartesColorees getPresentation() {
		return presentation;
	}

	public void p2c_dragEnter(CCarte cc){
		if(isEmpilable(cc)){
			presentation.showEmpilable();
		}
		else{
			presentation.showNonEmpilable();
		}
	}
	
	public void p2c_dragExit(CCarte cc){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CCarte cc){
		if(isEmpilable(cc)){
			empiler(cc);
			presentation.c2p_finDnDOK();
		}
		else{
			presentation.c2p_finDnDKO();
		}
		presentation.c2p_showNeutre();
	}
}
