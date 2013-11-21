package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controle.CSabot;

public class RetournerSabotListener implements MouseListener {
	
	public CSabot controle;
	
	public RetournerSabotListener(CSabot controle){
		this.controle = controle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			controle.retourner();
		} catch (Exception e1) {
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
