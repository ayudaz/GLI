package controle;

import presentation.PTasDeCartesColorees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CTasDeCartesColorees extends TasDeCartesColorees {
	
	private PTasDeCartesColorees presentation;
	
	public CTasDeCartesColorees(String arg0, int arg1, Usine arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
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
