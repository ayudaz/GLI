package controle;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import presentation.PSabot;
import solitaire.application.Sabot;
import solitaire.application.Tas;

public class CSabot extends Sabot {
	private PSabot presentation;
	private CCarte enTransit;

	public CSabot(String nom, CUsine u){
		super(nom,u);
		//p = new PSabot((CTasDeCartes)cachees).getPresentation()), ((CTasDeCartes)visibiles).getPresenation());
	}

	// ICI ?????
	public void setReserve(Tas t){
		super.setReserve(t);
		if(isRetournable()){
			presentation.activerRetournerCarte();
		}
		else{
			presentation.desactiverRetournerCarte();

			if(isRetournable()){
				presentation.activerRetournerSabot();
			}
			else{
				presentation.desactiverRetournerSabot();
			}
		}
	}

	public void retourner(){
		try {
			super.retourner();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presentation.desactiverRetournerSabot();
		if(isRetournable()){
			presentation.activerRetournerCarte();
		}
	}

	public void depiler(){
		try {
			super.depiler();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isRetournable()){
			presentation.desactiverRetournerSabot();
		}
	}


	public void p2c_debutDnD(CCarte cc){
		try {
			if(cc == getSommet()){
				depiler();
				enTransit = cc;
				presentation.c2p_debutDnDOK(cc.getPresentation());
			}
			else{
				presentation.c2p_debutDnDKO(cc.getPresentation());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void p2c_finDnD(boolean s){
		if(!s){
			empiler(enTransit);
		}
	}
}
