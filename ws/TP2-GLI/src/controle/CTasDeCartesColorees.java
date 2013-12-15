package controle;

import java.util.ArrayList;
import java.util.List;

import presentation.PTasDeCartesColorees;
import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CTasDeCartesColorees extends TasDeCartesColorees implements ICTas, Subject {
	
	private PTasDeCartesColorees presentation;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public CTasDeCartesColorees(String nom, int couleur, Usine usine) {
		super(nom, couleur, usine);
		this.presentation = new PTasDeCartesColorees(this, "F"+couleur);
	}

	/**
	 * @return the presentation
	 */
	public PTasDeCartesColorees getPresentation() {
		return presentation;
	}
	
	public void empiler (Carte carte){
		if(isEmpilable(carte)){
			super.empiler(carte);
			try {
				if(carte == getSommet()){
					presentation.empiler(((CCarte)carte).getPresentation());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void depiler() throws Exception {	
		Carte carte;
		carte = getSommet();
		super.depiler();
		presentation.depiler(((CCarte)carte).getPresentation());
	}

	public void p2c_debutDnDDrag(CCarte ccarte) {
		
	}


	public void p2c_finDropTarget(CTasDeCartes ctas) {
		if(ctas.getNombre() <= 1){
			try {
				if(isEmpilable(ctas.getSommet())){
					empiler(ctas.getSommet());
					presentation.finDnDValide();
				}
				else{
					presentation.finDnDInvalid();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			presentation.finDnDInvalid();
		}		
	}

	public void p2c_DragEnter(ICTas icTas) {
		// TODO Auto-generated method stub
		System.out.println("DragEnter CTasColorees");
		try {
			if(isEmpilable(icTas.getSommet())){
				presentation.showAcceptTarget(true);
			} 
			else {
				presentation.showAcceptTarget(false);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void p2c_DragExit(ICTas icTas) {
		presentation.setNormalState();	
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void notifier() {
		for(Observer o : observers){
			o.update();
		}
	}

}
