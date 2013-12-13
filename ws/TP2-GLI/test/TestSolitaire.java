import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.prefs.BackingStoreException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controle.CSolitaire;
import controle.CUsine;


public class TestSolitaire {

	public static void main(String[] args) {
		JFrame f = new JFrame ("Test Solitaire");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		CSolitaire solitaire = new CSolitaire("Solitaire", new CUsine());
		solitaire.initialiser();
		
		f.getContentPane().add(solitaire.getPresentation());
		f.setPreferredSize(f.getContentPane().getPreferredSize());
		f.pack();		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible(true);	// et le rendre visible

		solitaire.jouer();
	}

}
