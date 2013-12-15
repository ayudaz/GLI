package controle;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CUsine extends Usine {

	public CUsine() {
		super();
	}

	@Override
	public Carte newCarte(int valeur, int couleur) {
		return new CCarte(valeur, couleur);
	}

	@Override
	public Colonne newColonne(String nom, Usine usine) {
		return new CColonne(nom, usine);
	}

	@Override
	public Sabot newSabot(String nom, Usine usine) {
		return new CSabot(nom, usine);
	}

	@Override
	public Solitaire newSolitaire(String nom, Usine usine) {
		return new CSolitaire(nom, usine);
	}

	@Override
	public TasDeCartes newTasDeCartes(String nom, Usine usine) {
		return new CTasDeCartes(nom, usine);
	}

	@Override
	public TasDeCartesAlternees newTasDeCartesAlternees(String nom, Usine usine) {
		return new CTasDeCartesAlternees(nom, usine);
	}

	@Override
	public TasDeCartesColorees newTasDeCartesColorees(String nom, int couleur,
			Usine usine) {
		return new CTasDeCartesColorees(nom, couleur, usine);
	}
}
