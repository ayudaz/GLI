package controle;

import presentation.IPTas;
import solitaire.application.Tas;

public interface ICTas extends Tas {
	public IPTas getPresentation();
}
