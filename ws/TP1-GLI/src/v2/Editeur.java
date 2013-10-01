package v2;

import java.awt.Color;

import javax.swing.JFrame;

public class Editeur extends JFrame {
	
	private static int width = 800;
	private static int height = 600;
	
	private ZoneDeDessin zdd;
	
	public Editeur(){
		super("Mon super editeur de dessin");
		this.setSize(width, height);
		this.getContentPane().setBackground(Color.YELLOW);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		zdd = new ZoneDeDessin();
		this.getContentPane().add(zdd);
		zdd.setSize(getSize());
	}
}
