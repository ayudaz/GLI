package presentation;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controle.CSabot;

public class PSabot extends DragAndDrop{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1595830508186217340L;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;
	private RetournerSabotListener rsl;
	private RetournerCarteListener rcl;
	private boolean retournerCarte;
	private boolean retournerSabot;
	
	
	private static final int DECALVISIBLE = 15;
	
	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles){
		controle = c;
		this.cachees = cachees;
		this.visibles = visibles;
		this.retournerCarte = true;
		this.retournerSabot = false;
		this.rsl = new RetournerSabotListener();
		this.rcl = new RetournerCarteListener();
		
		// Cr�ation et assignation du layout manager
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		
		// Ajout des tas cach�es et visibles au panel
		add(cachees);
		add(visibles);
		this.cachees.setDxDy(0, 0);
		Icon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/fond_sabot.png"));
		JLabel fond = new JLabel(icone);
		this.cachees.add(fond);
		Insets insets = this.cachees.getInsets();
		Dimension size = fond.getPreferredSize();
		fond.setBounds(insets.left, insets.right, size.width, size.height);
		visibles.setDxDy(DECALVISIBLE, 0);
		
		// Pour que le fond du jeu soit visible
		setOpaque(false);
		
		elementDrag = this.visibles;               
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( visibles, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );
        
        cachees.addMouseListener(rsl);
        cachees.addMouseListener(rcl);
	}
	
	public void activerRetournerSabot(){
		retournerSabot = true;
	}
	
	public void activerRetournerCarte(){
		retournerCarte = true;
	}

	public void desactiverRetournerSabot() {
		retournerSabot = false;
	}

	public void desactiverRetournerCarte() {
		retournerCarte = false;
	}
	
	
	public class RetournerSabotListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(retournerSabot){
				try {
					((CSabot) controle).retourner();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}

	public class RetournerCarteListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(retournerCarte){
				try {
					((CSabot) controle).retournerCarte();
					((CSabot) controle).retournerCarte();
					((CSabot) controle).retournerCarte();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));

		}

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		}

	}
}
