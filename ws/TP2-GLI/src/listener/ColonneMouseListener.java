package listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presentation.PCarte;
import solitaire.application.TasDeCartesColorees;
import controle.CCarte;
import controle.CColonne;
import controle.CTasDeCartesColorees;

public class ColonneMouseListener implements MouseListener {
	
	private CColonne colonne;
	private TasDeCartesColorees[] tasDeCartesColorees;
	
	public ColonneMouseListener(CColonne colonne, TasDeCartesColorees[] pilesColorees){
		this.colonne = colonne;
		this.tasDeCartesColorees = pilesColorees;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			 try {
				CCarte carte = (CCarte) colonne.getSommet();
				for(TasDeCartesColorees tas : tasDeCartesColorees){
					if(tas.isEmpilable(carte)){
						try {
							colonne.depiler();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						tas.empiler(carte);
					}
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		colonne.getPresentation().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		colonne.getPresentation().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
