package controle;

import presentation.IPTas;
import presentation.PTasDeCartes;
import solitaire.application.Carte;
import solitaire.application.Tas;

public interface ICTas extends Tas {
	public IPTas getPresentation();
}
