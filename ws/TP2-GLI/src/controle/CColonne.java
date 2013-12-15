package controle;

import presentation.PColonne;
import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class CColonne extends Colonne implements IControleDND {

	private CTasDeCartes enTransit;
	private PColonne presentation;

	public CColonne(String nom, Usine usine) {
		super(nom, usine);

		presentation = new PColonne(this,
				((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartesAlternees) visibles).getPresentation());
	}

	public PColonne getPresentation() {
		return presentation;
	}
	
	@Override
	public void empiler(Tas tas){
		super.empiler(tas);
		this.presentation.empiler(((CTasDeCartes)tas).getPresentation());
	}

	@Override
	public void empiler(Carte c) {
		super.empiler(c);
		this.presentation.empiler(((CCarte) c).getPresentation());
	}

	@Override
	public void depiler() throws Exception {
		Carte carte;
		carte = getSommet();
		super.depiler();
		presentation.depiler(((CCarte) carte).getPresentation());
	}

	@Override
	public void retournerCarte() throws Exception {
		super.retournerCarte();
		presentation.retournerCarte();
	}


	@Override
	public void p2c_debutDnDDrag(CCarte selectedCarte) {
		if(selectedCarte == null){
			System.out.println("Null card");
		}
		try {
			for (int i=1; i <= visibles.getNombre(); i++) {
                Carte carte = visibles.getCarte(i);
                System.out.println("Carte "+i+" : "+((CCarte) carte));
                if (carte == selectedCarte) {
                        enTransit = new CTasDeCartes("drag", new CUsine());
                        enTransit.getPresentation().setDxDy(0, 15);
                        
                        for (int j=i; j >= 1; j--) {
                                enTransit.empiler(getCarte(j));
                        }
                        for (int k=0; k<i; k++) {
                                depiler();
                        }
                        presentation.c2p_debutDnDValide(enTransit.getPresentation());
                }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void p2c_finDragSource(boolean dropSuccess) {
		if(!dropSuccess){
			empiler(enTransit);
		}
	}

	public void p2c_finDropTarget(CTasDeCartes ctas) {
		// TODO Auto-generated method stub
		if (isEmpilable(ctas)){
			empiler(ctas);
			presentation.setNormalState();
			presentation.finDnDValide();
			presentation.affichage();
		}
		else{
			presentation.setNormalState();
			presentation.finDnDInvalid();
		}
	}

	public void p2c_DragEnter(ICTas ctas) {
		// TODO Auto-generated method stub
		if (isEmpilable(ctas)) {
			presentation.showAcceptTarget(true);
		} else {
			presentation.showAcceptTarget(false);
		}
	}

	public void p2c_DragExit(ICTas ctas) {
		// TODO Auto-generated method stub
		//System.out.println("DragExit CColonne");
		presentation.setNormalState();
	}
}
