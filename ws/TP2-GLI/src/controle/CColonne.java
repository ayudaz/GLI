package controle;

import presentation.PColonne;
import solitaire.application.Colonne;
import solitaire.application.Usine;

public class CColonne extends Colonne {
	
	private PColonne presentation;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		
		presentation = new PColonne(this, ((CTasDeCartes)cachees).getPresentation(), ((CTasDeCartesAlternees)visibles).getPresentation());
	}

	public PColonne getPresentation() {
		return presentation;
	}
	
	@Override
	public void retournerCarte() throws Exception{
		super.retournerCarte();
		if(this.cachees.isVide()){
			presentation.cacherCachees();
		}
	}
	
	
}
