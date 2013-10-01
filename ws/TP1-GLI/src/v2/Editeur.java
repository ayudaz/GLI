package v2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Editeur extends JFrame {
	
	private static int width = 800;
	private static int height = 600;
	private MenuLeft menuLeft;
	private ZoneDeDessin zdd;
	
	public Editeur(){
		super("Mon super editeur de dessin");
		this.setLayout(new BorderLayout());
		
		this.setSize(width, height);
		this.getContentPane().setBackground(Color.YELLOW);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.zdd = new ZoneDeDessin();
		this.menuLeft = new MenuLeft(zdd);
		this.getContentPane().add(zdd,BorderLayout.CENTER);
		this.getContentPane().add(menuLeft,BorderLayout.WEST);
		menuLeft.setPreferredSize(new Dimension(200,this.getHeight()));
		menuLeft.setSize(new Dimension(200,this.getHeight()));
		zdd.setPreferredSize(getSize());
		this.setVisible(true);
	}
}
