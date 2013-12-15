package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import solitaire.application.TasDeCartesColorees;
import controle.CCarte;
import controle.CSabot;

public class SabotMouseListener implements MouseListener {

	private CSabot sabot;
	private TasDeCartesColorees[] tasDeCartesColorees;

	public SabotMouseListener(CSabot sabot,
			TasDeCartesColorees[] tasDeCartesColorees) {
		this.sabot = sabot;
		this.tasDeCartesColorees = tasDeCartesColorees;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			try {
				CCarte carte = (CCarte) sabot.getSommet();
				for (TasDeCartesColorees tas : tasDeCartesColorees) {
					if (tas.isEmpilable(carte)) {
						sabot.depiler();
						tas.empiler(carte);
					}
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

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
