package listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import retroaction.RetroActions;
import controle.CSabot;

public class RetournerSabotListener implements MouseListener {
	
	public CSabot controle;
	
	public RetournerSabotListener(CSabot controle){
		this.controle = controle;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(controle.getPresentation().isRetournerSabot()){
			try {
				controle.retourner();
			} catch (Exception e1) {
			}
			RetroActions.clicRetournerSabot.faireRetroAction();
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
