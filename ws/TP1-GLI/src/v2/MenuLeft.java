package v2;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MenuLeft extends JPanel {
	
	private ZoneDeDessin zdd;
	
	public MenuLeft(ZoneDeDessin zdd) {
		super();
		this.zdd = zdd;
		setLayout(new FlowLayout());
		setOpaque(true);
		setBackground(Color.pink);
		
		JPanel panelChoixForme = new JPanel();
		panelChoixForme.setLayout(new GridLayout(0,1));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JToggleButton jButtonRectFill = new JToggleButton("Rectangle Plein");
		jButtonRectFill.addActionListener(new MyButtonListener(zdd, new CreateurRectangleFill()));
		buttonGroup.add(jButtonRectFill);
		
		
		JToggleButton jButtonRect = new JToggleButton("Rectangle");
		jButtonRect.addActionListener(new MyButtonListener(zdd, new CreateurRectangle()));
		buttonGroup.add(jButtonRect);
		
		JToggleButton jButtonEllipseFill = new JToggleButton("Ellipse Pleine");
		jButtonEllipseFill.addActionListener(new MyButtonListener(zdd, new CreateurEllipseFill()));
		buttonGroup.add(jButtonEllipseFill);
		
		JToggleButton jButtonEllipse = new JToggleButton("Ellipse");
		jButtonEllipse.addActionListener(new MyButtonListener(zdd, new CreateurEllipse()));
		buttonGroup.add(jButtonEllipse);
		
		
		panelChoixForme.add(jButtonRectFill);
		panelChoixForme.add(jButtonRect);
		panelChoixForme.add(jButtonEllipse);
		panelChoixForme.add(jButtonEllipseFill);
		

		jButtonRectFill.doClick();
		this.add(panelChoixForme);
	}
	
	

}
