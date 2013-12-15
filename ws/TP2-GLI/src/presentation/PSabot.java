package presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import listener.MyDragGestureListener;
import listener.MyDragSourceListener;
import listener.MyDragSourceMotionListener;
import listener.RetournerCarteSabotListener;
import listener.RetournerSabotListener;
import listener.SabotMouseListener;
import controle.CSabot;

public class PSabot extends DragAndDrop {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1595830508186217340L;
	private PTasDeCartes cachees;
	private PTasDeCartes visibles;
	private RetournerSabotListener rsl;
	private RetournerCarteSabotListener rcl;
	private boolean retournerCarte;
	private boolean retournerSabot;

	private static final int DECALVISIBLE = 15;

	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles) {
		controle = c;
		this.cachees = cachees;
		this.visibles = visibles;
		this.retournerCarte = true;
		this.retournerSabot = false;
		this.rsl = new RetournerSabotListener(c);
		this.rcl = new RetournerCarteSabotListener(c);

		// Cr�ation et assignation du layout manager
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));

		// Ajout des tas cach�es et visibles au panel
		add(this.cachees);
		add(this.visibles);
		this.cachees.setDxDy(0, 0);
		Icon icone = new ImageIcon(
				ClassLoader.getSystemResource("cartes/fond_sabot.png"));
		JLabel fond = new JLabel(icone);
		this.cachees.add(fond);
		Insets insets = this.cachees.getInsets();
		Dimension size = fond.getPreferredSize();
		fond.setBounds(insets.left, insets.right, size.width, size.height);
		visibles.setDxDy(DECALVISIBLE, 0);

		// Pour que le fond du jeu soit visible
		setOpaque(false);

		elementDrag = this.visibles;
		myDragSourceListener = new MyDragSourceListener(controle);
		dragSource = new DragSource();
		myDragGestureListener = new MyDragGestureListener(controle, this.visibles);
		dragSource.createDefaultDragGestureRecognizer(visibles,
				DnDConstants.ACTION_MOVE, myDragGestureListener);
		dragSource
				.addDragSourceMotionListener(new MyDragSourceMotionListener(this));

		cachees.addMouseListener(rsl);
		cachees.addMouseListener(rcl);
	}

	public void activerRetournerSabot() {
		retournerSabot = true;
	}

	public void activerRetournerCarte() {
		retournerCarte = true;
	}

	public void desactiverRetournerSabot() {
		retournerSabot = false;
	}

	public void desactiverRetournerCarte() {
		retournerCarte = false;
	}

	/**
	 * @return the retournerCarte
	 */
	public boolean isRetournerCarte() {
		return retournerCarte;
	}

	/**
	 * @return the retournerSabot
	 */
	public boolean isRetournerSabot() {
		return retournerSabot;
	}

	public CSabot getControle() {
		return (CSabot) controle;
	}

	public void setSabotMouseListener(SabotMouseListener sabotMouseListener) {
		this.visibles.addMouseListener(sabotMouseListener);
	}
}
