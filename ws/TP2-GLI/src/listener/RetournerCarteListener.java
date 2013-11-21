package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controle.CSabot;

public class RetournerCarteListener implements MouseListener {
	
	private CSabot controle;
	
	public RetournerCarteListener(CSabot controle){
		this.controle = controle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			controle.retournerCarte();
			controle.retournerCarte();
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}