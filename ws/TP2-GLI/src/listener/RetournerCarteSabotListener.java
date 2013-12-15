package listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controle.CSabot;

public class RetournerCarteSabotListener implements MouseListener {

	private CSabot controle;
	private static int nbCartes;

	public RetournerCarteSabotListener(CSabot controle) {
		this.controle = controle;
		nbCartes = 3;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (controle.getPresentation().isRetournerCarte()) {
			try {
				for (int i = 0; i < nbCartes; i++) {
					controle.retournerCarte();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
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
		controle.getPresentation().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		controle.getPresentation().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	/**
	 * @return the nbCartes
	 */
	public static int getNbCartes() {
		return nbCartes;
	}

	/**
	 * @param nbCartes
	 *            the nbCartes to set
	 */
	public static void setNbCartes(int nbCartes) {
		RetournerCarteSabotListener.nbCartes = nbCartes;
	}

}