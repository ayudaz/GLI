package controle;

import presentation.PCarte;
import solitaire.application.Carte;

public class CCarte  extends Carte implements ICCarte {
	private PCarte presentation;
	
	public CCarte(int valeur, int couleur){
		super(Math.min(Carte.NbCartesParCouleur, Math.max(1,valeur)), Math.min(Carte.NbCouleurs, Math.max(1,couleur)));
		
		//pCarte = new PCarte (this, Carte.valeurs[getValeur()-1] + Carte.couleurs[getCouleur()-1]);
		//p.setFaceVisible(isFaceVisible());
	}

	/**
	 * @return the presentation
	 */
	public PCarte getPresentation() {
		return presentation;
	}	
}