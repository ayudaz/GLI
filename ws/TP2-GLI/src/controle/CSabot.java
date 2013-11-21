package controle;

import presentation.PSabot;
import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class CSabot extends Sabot {
	private PSabot presentation;
	private CCarte enTransit;

	public CSabot(String nom, Usine usine){
		super(nom,usine);
		presentation = new PSabot(this, ((CTasDeCartes)cachees).getPresentation(), ((CTasDeCartes)visibles).getPresentation());
	}

	/**
	 * @return the presentation
	 */
	public PSabot getPresentation() {
		return presentation;
	}

	public void setReserve(Tas t){
		super.setReserve(t);
		if(isCarteRetournable()){
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

	public void retourner() throws Exception{
		super.retourner();
		presentation.retourner();
		presentation.desactiverRetournerSabot();
		presentation.activerRetournerCarte();
	}
	
	public void retournerCarte() throws Exception{
		super.retournerCarte();
		presentation.retournerCarte();
		if(!isCarteRetournable()){
			presentation.desactiverRetournerCarte();
			presentation.activerRetournerSabot();
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
