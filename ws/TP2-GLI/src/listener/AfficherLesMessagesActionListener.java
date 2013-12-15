package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

import retroaction.factory.FactoryRetroActions;

public class AfficherLesMessagesActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBoxMenuItem cb = (JCheckBoxMenuItem)e.getSource();
		FactoryRetroActions.msg = cb.isSelected();
		FactoryRetroActions.createRetroActions();
	}

}
