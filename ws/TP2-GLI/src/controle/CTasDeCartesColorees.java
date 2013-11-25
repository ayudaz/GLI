package controle;

import presentation.PTasDeCartesColorees;
import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CTasDeCartesColorees extends TasDeCartesColorees implements ICTas {
	
	private PTasDeCartesColorees presentation;
	
	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		this.presentation = new PTasDeCartesColorees(this, "F"+couleur);
	}

	/**
	 * @return the presentation
	 */
	public PTasDeCartesColorees getPresentation() {
		return presentation;
	}
	
	public void empiler (Carte carte){
		if(isEmpilable(carte)){
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

	public void p2c_dragEnter(CTasDeCartes cTasDeCartes){
		if(isEmpilable(cTasDeCartes)){
			System.out.println("Tas empilable");
			presentation.showEmpilable();
		}
		else{
			System.out.println("Tas non empilable");
			presentation.showNonEmpilable();
		}
	}
	
	public void p2c_dragExit(CTasDeCartes cTasDeCartes){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CTasDeCartes cTasDeCartes){
		if(isEmpilable(cTasDeCartes)){
			empiler(cTasDeCartes);
			presentation.c2p_finDnDOK();
		}
		else{
			presentation.c2p_finDnDKO();
		}
		presentation.c2p_showNeutre();
	}
}
