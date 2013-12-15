package retroaction;

import retroaction.decorator.MsgErreur;
import retroaction.decorator.RetroAction;
import retroaction.decorator.SimpleRetroAction;
import retroaction.decorator.SonCarte1;
import retroaction.decorator.SonCarte2;
import retroaction.decorator.SonCarte3;
import retroaction.decorator.SonErreur;

public class RetroActions {
	
	public static RetroAction finDnDInvalid = new MsgErreur(new SonErreur(new SimpleRetroAction()));
	public static RetroAction finDnDValide = new SonCarte1(new SimpleRetroAction());
	public static RetroAction debutDnDValide = new SonCarte3(new SimpleRetroAction());
	public static RetroAction clicRetournerCarte = new SonCarte1(new SimpleRetroAction());
	public static RetroAction clicRetournerSabot = new SonCarte2(new SimpleRetroAction());
}
