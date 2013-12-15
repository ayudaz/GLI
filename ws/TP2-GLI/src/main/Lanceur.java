package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import listener.AProposActionListener;
import listener.AideActionListener;
import listener.ChoixNbCartesActionListener;
import listener.NouvellePartieActionListener;
import controle.CSolitaire;
import controle.CUsine;

public class Lanceur extends JFrame {

	private static final long serialVersionUID = 8666586439406360918L;
	private JMenuBar menuBar;
	private JMenu menuParametres;
	private JMenu menuAide;
	private CSolitaire solitaire;

	public Lanceur() {
		super("Solitaire");

		menuBar = new JMenuBar();
		menuParametres = new JMenu("Partie");
		menuAide = new JMenu("?");
		menuBar.add(menuParametres);
		menuBar.add(menuAide);

		JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
		nouvellePartie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		nouvellePartie
				.addActionListener(new NouvellePartieActionListener(this));
		menuParametres.add(nouvellePartie);

		ButtonGroup bgNbCartes = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItemNbCartes = new JRadioButtonMenuItem(
				"Tirer une Carte");
		rbMenuItemNbCartes.setSelected(false);
		rbMenuItemNbCartes.setMnemonic(KeyEvent.VK_1);
		rbMenuItemNbCartes
				.addActionListener(new ChoixNbCartesActionListener(1));
		bgNbCartes.add(rbMenuItemNbCartes);
		menuParametres.add(rbMenuItemNbCartes);

		rbMenuItemNbCartes = new JRadioButtonMenuItem("Tirer trois Cartes");
		rbMenuItemNbCartes.setSelected(true);
		rbMenuItemNbCartes.setMnemonic(KeyEvent.VK_3);
		rbMenuItemNbCartes
				.addActionListener(new ChoixNbCartesActionListener(3));
		bgNbCartes.add(rbMenuItemNbCartes);
		menuParametres.add(rbMenuItemNbCartes);

		JMenuItem aide = new JMenuItem("Aide");
		aide.addActionListener(new AideActionListener(this));
		menuAide.add(aide);

		JMenuItem aPropos = new JMenuItem("A Propos");
		aPropos.addActionListener(new AProposActionListener(this));
		menuAide.add(aPropos);

		this.setJMenuBar(menuBar);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);

		nouvellePartie();
	}

	public void nouvellePartie() {
		solitaire = new CSolitaire("Solitaire", new CUsine());
		solitaire.initialiser();
		setContentPane(solitaire.getPresentation());
		setPreferredSize(getContentPane().getPreferredSize());
		pack();
	}

	public static void main(String[] args) {
		new Lanceur();
	}

}
