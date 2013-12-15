package listener;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AProposActionListener implements ActionListener {

	private Frame frame;

	public AProposActionListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane
				.showMessageDialog(
						frame,
						"Ce jeu à été développé dans le cadre d'un TP sur la création d'interfaces graphiques en Swing "
								+ "en utilisant la méthode PAC-Amodeus.\n\n"
								+ "IHM par Florian Leloup & Thomas Lelièvre, noyau applicatif par Thierry Duval",
						"A Propos", JOptionPane.PLAIN_MESSAGE);
	}

}
