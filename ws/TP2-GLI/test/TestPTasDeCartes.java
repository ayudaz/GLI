import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controle.CCarte;
import controle.CTasDeCartes;
import controle.CUsine;
import presentation.PCarte;
import presentation.PTasDeCartes;


public class TestPTasDeCartes {

	public TestPTasDeCartes() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	   * programme de test : à déplacer dans une classe dédiée aux tests
	   * @param args
	   */
	  public static void main (String args []) {
		JFrame f = new JFrame ("Test PTasDeCartes") ;
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

		PTasDeCartes tas = new PTasDeCartes(new CTasDeCartes("Test", new CUsine()));
		tas.setDxDy(10, 0);
		PCarte c1, c2;
		c1 = new PCarte("1D", null);
		c2 = new PCarte("2D", null);
		tas.empiler(c1);
		tas.empiler(c2);
		
		c1.setFaceVisible(true);
		c2.setFaceVisible(true);
		f.getContentPane ().add(tas) ;

		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
	  } // main

}
