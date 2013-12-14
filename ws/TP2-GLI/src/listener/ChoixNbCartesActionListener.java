package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButtonMenuItem;

public class ChoixNbCartesActionListener implements ActionListener {
	
	private int nbCartes;
	
	public ChoixNbCartesActionListener(int nbCartes){
		this.nbCartes = nbCartes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RetournerCarteSabotListener.setNbCartes(nbCartes);
	}

}
