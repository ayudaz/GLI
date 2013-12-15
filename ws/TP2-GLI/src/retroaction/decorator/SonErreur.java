package retroaction.decorator;

import utilitaire.Son;

public class SonErreur extends RetroActionDecorator {

	public SonErreur(RetroAction retroActionDecoree) {
		super(retroActionDecoree);
	}
	
	@Override
	public void faireRetroAction(){
		super.faireRetroAction();
		Son s = new Son("erreur.wav");
		s.jouer();
	}

}
