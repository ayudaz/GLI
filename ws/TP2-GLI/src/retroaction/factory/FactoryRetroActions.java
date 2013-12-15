package retroaction.factory;

import retroaction.RetroActions;
import retroaction.decorator.MsgErreur;
import retroaction.decorator.SimpleRetroAction;
import retroaction.decorator.SonCarte1;
import retroaction.decorator.SonCarte2;
import retroaction.decorator.SonCarte3;
import retroaction.decorator.SonErreur;

public class FactoryRetroActions {
	
	public static boolean son = true;
	public static boolean msg = true;
	
	private static void createRetroActionsSongMsg(){
		RetroActions.finDnDInvalid = new MsgErreur(new SonErreur(new SimpleRetroAction()));
		RetroActions.finDnDValide = new SonCarte1(new SimpleRetroAction());
		RetroActions.debutDnDValide = new SonCarte3(new SimpleRetroAction());
		RetroActions.clicRetournerCarte = new SonCarte1(new SimpleRetroAction());
		RetroActions.clicRetournerSabot = new SonCarte2(new SimpleRetroAction());
	}
	
	private  static void createRetroActionsSong(){
		RetroActions.finDnDInvalid = new SonErreur(new SimpleRetroAction());
		RetroActions.finDnDValide = new SonCarte1(new SimpleRetroAction());
		RetroActions.debutDnDValide = new SonCarte3(new SimpleRetroAction());
		RetroActions.clicRetournerCarte = new SonCarte1(new SimpleRetroAction());
		RetroActions.clicRetournerSabot = new SonCarte2(new SimpleRetroAction());
	}
	
	private static void createRetroActionsMsg(){
		RetroActions.finDnDInvalid = new MsgErreur(new SimpleRetroAction());
		RetroActions.finDnDValide = new SimpleRetroAction();
		RetroActions.debutDnDValide = new SimpleRetroAction();
		RetroActions.clicRetournerCarte = new SimpleRetroAction();
		RetroActions.clicRetournerSabot = new SimpleRetroAction();
	}
	
	private static void createRetroActionsSimple(){
		RetroActions.finDnDInvalid = new SimpleRetroAction();
		RetroActions.finDnDValide = new SimpleRetroAction();
		RetroActions.debutDnDValide = new SimpleRetroAction();
		RetroActions.clicRetournerCarte = new SimpleRetroAction();
		RetroActions.clicRetournerSabot = new SimpleRetroAction();
	}
	
	public static void createRetroActions(){
		if(son && msg){
			createRetroActionsSongMsg();
		}
		else if(son && !msg){
			createRetroActionsSong();
		}
		else if(!son && msg){
			createRetroActionsMsg();
		}
		else{
			createRetroActionsSimple();
		}
	}
}
