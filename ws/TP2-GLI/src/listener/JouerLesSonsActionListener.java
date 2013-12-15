package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

import retroaction.factory.FactoryRetroActions;

public class JouerLesSonsActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBoxMenuItem cb = (JCheckBoxMenuItem)e.getSource();
		FactoryRetroActions.son = cb.isSelected();
		FactoryRetroActions.createRetroActions();
	}

}
