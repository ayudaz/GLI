package main;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.WindowConstants;

import listener.ChoixNbCartesActionListener;
import controle.CSolitaire;
import controle.CUsine;

public class Lanceur extends JFrame {

	private static final long serialVersionUID = 8666586439406360918L;
	private JMenuBar menuBar;
	private JMenu menuParametres;
	
	public Lanceur(){
		super("Solitaire");
		menuBar = new JMenuBar();
		menuParametres = new JMenu("Partie");
		menuParametres.setMnemonic(KeyEvent.VK_ALT);
		menuBar.add(menuParametres);
		
		ButtonGroup bgNbCartes = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItemNbCartes = new JRadioButtonMenuItem("Tirer une Carte");
		rbMenuItemNbCartes.setSelected(false);
		rbMenuItemNbCartes.setMnemonic(KeyEvent.VK_1);
		rbMenuItemNbCartes.addActionListener(new ChoixNbCartesActionListener(1));
		bgNbCartes.add(rbMenuItemNbCartes);
		menuParametres.add(rbMenuItemNbCartes);
		
		rbMenuItemNbCartes = new JRadioButtonMenuItem("Tirer trois Cartes");
		rbMenuItemNbCartes.setSelected(true);
		rbMenuItemNbCartes.setMnemonic(KeyEvent.VK_3);
		rbMenuItemNbCartes.addActionListener(new ChoixNbCartesActionListener(3));
		bgNbCartes.add(rbMenuItemNbCartes);
		menuParametres.add(rbMenuItemNbCartes);
		
		this.setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		Lanceur frameSolitaire = new Lanceur();
		frameSolitaire.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameSolitaire.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		CSolitaire solitaire = new CSolitaire("Solitaire", new CUsine());
		Thread t = new Thread(solitaire);
		solitaire.initialiser();
		
		frameSolitaire.getContentPane().add(solitaire.getPresentation());
		frameSolitaire.setPreferredSize(frameSolitaire.getContentPane().getPreferredSize());
		frameSolitaire.pack();	
		frameSolitaire.setLocation(200,100);	
		frameSolitaire.setVisible(true);
		frameSolitaire.setResizable(false);

		t.start();
	}

}
