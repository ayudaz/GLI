import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controle.CCarte;
import controle.CColonne;
import controle.CTasDeCartes;
import controle.CUsine;


public class TestColonne {

	public static void main(String[] args){
		JFrame f = new JFrame ("Test Colonne");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
		
		CColonne colonne = new CColonne("Test Colonne", new CUsine());
//		colonne.empiler(new CCarte(13, 1));
//		colonne.empiler(new CCarte(12, 2));
//		colonne.empiler(new CCarte(11, 1));
//		colonne.empiler(new CCarte(10, 2));
		
		CTasDeCartes tas = new CTasDeCartes("tas", new CUsine());
		tas.empiler(new CCarte(9, 1));
		tas.empiler(new CCarte(8, 1));
		tas.empiler(new CCarte(7, 1));
		colonne.setReserve(tas);
		try {
			colonne.retournerCarte();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		f.getContentPane ().add(colonne.getPresentation()) ;
		f.pack ();		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
	}
}
