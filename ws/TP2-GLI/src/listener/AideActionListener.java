package listener;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AideActionListener implements ActionListener {
	
	private Frame frame;

	public AideActionListener(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(frame, 
				"Clic droit le fond vert => remplie les tas de cartes colorées avec toutes les cartes disponibles\n"
				+ "Double clic sur une carte => envoie cette carte sur les tas de carte colorées si possible", 
				"Aide", 
				JOptionPane.PLAIN_MESSAGE);
	}

}
