import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import presentation.PCarte;


public class TestPCarte {

	public TestPCarte() {
		// TODO Auto-generated constructor stub
	}

	 /**
	   * programme de test : à déplacer dans une classe dédiée aux tests
	   * @param args
	   */
	  public static void main (String args []) {
		JFrame f = new JFrame ("Test PCarte") ;
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

		// une carte visible
		PCarte pc = new PCarte ("QH", null);
		pc.setFaceVisible(true);
		f.getContentPane ().add(pc) ;

		// une carte cachée
		pc = new PCarte("1D", null);
		pc.setFaceVisible(false);
		f.getContentPane ().add(pc) ;

		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
	  } // main
}
