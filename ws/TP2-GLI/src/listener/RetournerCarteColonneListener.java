package listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		controle.getPresentation().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		controle.getPresentation().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

}
