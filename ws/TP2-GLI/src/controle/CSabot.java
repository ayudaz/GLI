package controle;

import presentation.PSabot;
import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class CSabot extends Sabot implements IControleDND {
	private PSabot presentation;
	private CTasDeCartes enTransit;

	public CSabot(String nom, Usine usine) {
		super(nom, usine);
		presentation = new PSabot(this,
				((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartes) visibles).getPresentation());
	}

	/**
	 * @return the presentation
	 */
	public PSabot getPresentation() {
		return presentation;
	}

	public void setReserve(Tas t) {
		super.setReserve(t);
		if (isCarteRetournable()) {
			presentation.activerRetournerCarte();
		} else {
			presentation.desactiverRetournerCarte();

			if (isRetournable()) {
				presentation.activerRetournerSabot();
			} else {
				presentation.desactiverRetournerSabot();
			}
		}
	}

	public void retourner() throws Exception {
		if (isRetournable()) {
			super.retourner();
		} else {
			presentation.desactiverRetournerSabot();
			presentation.activerRetournerCarte();
		}
	}

	public void retournerCarte() throws Exception {
		super.retournerCarte();
		if (!isCarteRetournable()) {
			presentation.desactiverRetournerCarte();
			presentation.activerRetournerSabot();
		}
	}

	public void p2c_debutDnDDrag(CCarte ccarte) {
		try {
			if ((ccarte == (CCarte) getSommet()) && (ccarte != null)) {
				depiler();
				enTransit = new CTasDeCartes("dragInProgress", new CUsine());
				enTransit.empiler(ccarte);
				presentation.c2p_debutDnDValide(enTransit.getPresentation());
			} else {
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void p2c_finDragSource(boolean dropSuccess) {
		if (!dropSuccess) {
			empiler(enTransit);
		}
	}

	@Override
	public void p2c_finDropTarget(CTasDeCartes ctas) {

	}

	@Override
	public void p2c_DragEnter(ICTas icTas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void p2c_DragExit(ICTas icTas) {
		// TODO Auto-generated method stub

	}
}
