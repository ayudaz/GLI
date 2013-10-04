package v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MenuRight extends JPanel {
	private ZoneDeDessin zdd;
	
	public MenuRight(ZoneDeDessin zdd) {
		super();
		this.zdd = zdd;
		setLayout(new BorderLayout());
		setOpaque(true);
		setBackground(Color.green);

		JPanel panelChoixForme = new JPanel();
		panelChoixForme.setLayout(new GridLayout(0, 1));

		ButtonGroup buttonGroup = new ButtonGroup();

		JToggleButton jButtonRed = new JToggleButton("Rouge");
		jButtonRed.addActionListener(new MyButtonListenerColor(zdd,Color.red));
		buttonGroup.add(jButtonRed);

		JToggleButton jButtonJaune = new JToggleButton("Jaune");
		jButtonJaune.addActionListener(new MyButtonListenerColor(zdd,Color.yellow));
		buttonGroup.add(jButtonJaune);

		JToggleButton jButtonBleu = new JToggleButton("Bleu");
		jButtonBleu.addActionListener(new MyButtonListenerColor(zdd,Color.blue));
		buttonGroup.add(jButtonBleu);

		JToggleButton jButtonChooser = new JToggleButton("Je veux choisir ma couleur");
		jButtonChooser.addMouseListener(new ListenerToOpenJCHooserColor(zdd));
		buttonGroup.add(jButtonChooser);
		
		panelChoixForme.add(jButtonRed);
		panelChoixForme.add(jButtonJaune);
		panelChoixForme.add(jButtonBleu);
		panelChoixForme.add(jButtonChooser);
		
		Previsualiseur p = new Previsualiseur(this.getWidth(),150, zdd);
		PrevisualiseurListener pListener = new PrevisualiseurListener(p);
		zdd.addPropertyChangeListener("foreground", pListener);
		zdd.addPropertyChangeListener("forme", pListener);
		
		jButtonRed.doClick();
		this.add(panelChoixForme, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);
	}
}
