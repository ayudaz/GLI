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
		System.out.println(isCarteRetournable());
		System.out.println("avant = " + cachees.getNombre() + ":" + visibles.getNombre());
		super.retournerCarte();
		System.out.println("après = " + cachees.getNombre() + ":" + visibles.getNombre());
		if(this.cachees.isVide()){
			presentation.cacherCachees();
		}
	}
	
	
}
