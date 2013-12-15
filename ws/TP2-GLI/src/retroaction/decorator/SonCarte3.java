package retroaction.decorator;

import utilitaire.Son;

public class SonCarte3 extends RetroActionDecorator {

	public SonCarte3(RetroAction retroActionDecoree) {
		super(retroActionDecoree);
	}
	
	@Override
	public void faireRetroAction(){
		super.faireRetroAction();
		Son s = new Son("carte3.wav");
		s.jouer();
	}

}
