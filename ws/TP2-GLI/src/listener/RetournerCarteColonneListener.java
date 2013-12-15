package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import retroaction.RetroActions;
import controle.CColonne;

public class RetournerCarteColonneListener implements MouseListener {
	
	public CColonne controle;
	
	public RetournerCarteColonneListener(CColonne controle){
		this.controle = controle;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			controle.retournerCarte();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		RetroActions.clicRetournerCarte.faireRetroAction();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
