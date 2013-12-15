package retroaction.decorator;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MsgErreur extends RetroActionDecorator {

	public MsgErreur(RetroAction retroActionDecoree) {
		super(retroActionDecoree);
	}

	@Override
	public void faireRetroAction(){
		super.faireRetroAction();
		String msg = "Vous ne pouvez placer une carte sur une autre que s'il "
				+ "s'agit de la carte immédiatement inférieure et qu'elle n'est pas "
				+ "de la même couleur.\n"
				+ "L'ordre est R,D,V,10,9,8,7,6,5,4,3,2,1";
		JOptionPane pane = new JOptionPane(msg, JOptionPane.WARNING_MESSAGE);
		JDialog dialog = pane.createDialog("Déplacement non autorisé !");
		dialog.setVisible(true);
	}
}
