package presentation;

import java.awt.Cursor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import controle.CSabot;

public class PSabot extends DragAndDrop{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1595830508186217340L;
	//private CSabot controle;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;
	private SpringLayout layout;
	private RetournerSabotListener rsl = new RetournerSabotListener();
	private RetournerCarteListener rcl = new RetournerCarteListener();
	
	
	private static final int DECALVISIBLE = 15;
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		controle = c;
		this.cachees = cachees;
		this.visibles = visibles;
		
		// Cr�ation et assignation du layout manager
		layout = new SpringLayout();
		this.setLayout(layout);
		
		// Ajout des tas cach�es et visibles au panel
		add(cachees);
		add(visibles);
		cachees.setDxDy(0, 0);
		Icon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/fond_sabot.png"));
		cachees.add(new JLabel(icone));
		visibles.setDxDy(DECALVISIBLE, 0);
		
		// Contraintes d'affichage du Sabot
		setContraintes();
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
		
		elementDrag = this.visibles;               
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( visibles, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );		
	}
	
	public void retournerCarte() {
		setContraintes();
	}	
	
	public void retourner() {
		setContraintes();
	}
	
	public void setContraintes() {
		cachees.setContraintes();
		visibles.setContraintes();
		layout.putConstraint(SpringLayout.NORTH, cachees, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, visibles, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cachees, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, visibles, 25, SpringLayout.EAST, cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, visibles);
		layout.putConstraint(SpringLayout.EAST, this, 20, SpringLayout.EAST, visibles);
	}
	
	public void activerRetournerSabot(){
		cachees.addMouseListener(rsl);
	}
	
	public void activerRetournerCarte(){
		cachees.addMouseListener(rcl);
	}

	public void desactiverRetournerSabot() {
		cachees.removeMouseListener(rsl);
	}

	public void desactiverRetournerCarte() {
		cachees.removeMouseListener(rcl);
	}
	
	
	public class RetournerSabotListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				((CSabot) controle).retourner();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}

	public class RetournerCarteListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				((CSabot) controle).retournerCarte();
				((CSabot) controle).retournerCarte();
				((CSabot) controle).retournerCarte();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		}

	}
}
