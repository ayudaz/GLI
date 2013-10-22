import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controle.CSabot;
import controle.CUsine;


public class TestSabot {

	public TestSabot() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JFrame f = new JFrame ("Test PSabot");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

		CSabot sabot = new CSabot("Test", new CUsine());
		
		
		f.getContentPane ().add(sabot.getPresentation()) ;
		f.pack ();		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
	}

}
