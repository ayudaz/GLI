package controle;

import presentation.PTasDeCartes;
import solitaire.application.Carte;
import solitaire.application.Tas;

public interface ICTasDeCartes extends Tas {
	public PTasDeCartes getPresentation();
	public void empiler(Carte carte);
}
