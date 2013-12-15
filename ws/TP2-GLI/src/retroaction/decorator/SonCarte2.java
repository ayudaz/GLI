package retroaction.decorator;

import utilitaire.Son;

public class SonCarte2 extends RetroActionDecorator {

	public SonCarte2(RetroAction retroActionDecoree) {
		super(retroActionDecoree);
	}
	
	@Override
	public void faireRetroAction(){
		super.faireRetroAction();
		Son s = new Son("carte2.wav");
		s.jouer();
	}

}
