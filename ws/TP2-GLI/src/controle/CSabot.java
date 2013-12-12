package controle;

import presentation.PSabot;
import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class CSabot extends Sabot implements IControleDND{
	private PSabot presentation;
	private CTasDeCartes enTransit;

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


	public void p2c_debutDnDDrag(CCarte ccarte) {
		if(ccarte != null){
			System.out.println("Debut Drag N Drop");
		}
		try {
			if(ccarte == (CCarte) getSommet()){
				depiler();
				enTransit = new CTasDeCartes("dragInProgress", new CUsine());
				enTransit.empiler(ccarte);
				presentation.c2p_debutDnDValide(enTransit.getPresentation());
			}
			else{
				//
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void p2c_finDragSource(boolean dropSuccess) {
		// TODO Auto-generated method stub
		if(!dropSuccess){
			empiler(enTransit);
		}
	}

	@Override
	public void p2c_finDropTarget(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void p2c_DragEnter(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void p2c_DragExit(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		
	}
}
