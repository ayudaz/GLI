package retroaction.decorator;

import utilitaire.Son;

public class SonCarte1 extends RetroActionDecorator {

	public SonCarte1(RetroAction retroActionDecoree) {
		super(retroActionDecoree);
	}
	
	@Override
	public void faireRetroAction(){
		super.faireRetroAction();
		Son s = new Son("carte1.wav");
		s.jouer();
	}

}
