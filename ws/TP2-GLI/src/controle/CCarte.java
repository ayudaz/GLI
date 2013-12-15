package controle;

import presentation.PCarte;
import solitaire.application.Carte;

public class CCarte extends Carte implements ICCarte {
	private PCarte presentation;

	public CCarte(int valeur, int couleur) {
		super(Math.min(Carte.NbCartesParCouleur, Math.max(1, valeur)), Math
				.min(Carte.NbCouleurs, Math.max(1, couleur)));

		presentation = new PCarte(Carte.valeurs[getValeur() - 1]
				+ Carte.couleurs[getCouleur() - 1], this);
		presentation.setFaceVisible(isFaceVisible());
	}

	/**
	 * changer la visibilit� de la carte
	 * 
	 * @param faceVisible
	 *            : vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible(boolean faceVisible) {
		super.setFaceVisible(faceVisible);
		presentation.setFaceVisible(faceVisible);
	}

	/**
	 * @return the presentation
	 */
	public PCarte getPresentation() {
		return presentation;
	}
}
