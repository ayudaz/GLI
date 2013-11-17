package controle;

import presentation.PColonne;
import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Tas;
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
	
	public void empiler(Carte c){
		super.empiler(c);
		this.presentation.empiler(((CCarte)c).getPresentation());
	}
	
	public void empiler(Tas tas){
		super.empiler(tas);
		presentation.empiler(((CColonne)tas).getPresentation());
	}
	
	public void depiler() throws Exception{
		Carte carte;
		carte = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)carte).getPresentation());
	}
	
	@Override
    public void retournerCarte() throws Exception{
        super.retournerCarte();
        if(this.cachees.isVide()){
            presentation.retournerCarte(true);
        }
        else{
        	presentation.retournerCarte(false);
        }
    }
}
