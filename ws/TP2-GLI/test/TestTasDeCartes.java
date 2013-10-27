import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controle.CCarte;
import controle.CTasDeCartes;
import controle.CUsine;


public class TestTasDeCartes {

	public TestTasDeCartes() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	   * programme de test : à déplacer dans une classe dédiée aux tests
	   * @param args
	   */
	  public static void main (String args []) {
		JFrame f = new JFrame ("Test CTasDeCartes") ;
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

		CTasDeCartes tas = new CTasDeCartes("Test", new CUsine());
		tas.getPresentation().setDxDy(10, 10);
		CCarte c1, c2, c3, c4, c5, c6;
		c1 = new CCarte(1,1);
		c2 = new CCarte(2,1);
		c3 = new CCarte(3,1);
		c4 = new CCarte(4,1);
		c5 = new CCarte(5,1);
		c6 = new CCarte(6,1);
		c1.setFaceVisible(true);
		c2.setFaceVisible(true);
		c3.setFaceVisible(true);
		c4.setFaceVisible(true);
		c5.setFaceVisible(true);
		c6.setFaceVisible(true);
		tas.empiler(c1);
		tas.empiler(c2);
		tas.empiler(c3);
		tas.empiler(c4);
		tas.empiler(c5);
		tas.empiler(c6);
		tas.depiler();
		f.getContentPane ().add(tas.getPresentation()) ;

		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
	  } // main

}
