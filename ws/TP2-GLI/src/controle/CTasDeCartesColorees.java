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

	public void p2c_debutDnDDrag(CCarte ccarte) {
		
	}


	public void p2c_finDropTarget(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		System.out.println("CTAS: "+ctas);
		if(ctas.getNombre() <= 1){
			System.out.println("On peut empiler");
			try {
				if(isEmpilable(ctas.getSommet())){
					System.out.println("Et on empile");
					empiler(ctas.getSommet());
					presentation.finDnDValide();
				}
				else{
					System.out.println("Mais on empile pas... :(");
					presentation.finDnDInvalid();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("On ne peut pas empiler :'(");
			presentation.finDnDInvalid();
		}
		
	}

	public void p2c_DragEnter(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		//System.out.println("TEST DRAG ENTER");
	}

	public void p2c_DragExit(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		
	}

}
