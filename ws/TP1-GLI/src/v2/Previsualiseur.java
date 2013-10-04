package v2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Previsualiseur extends JPanel{
	
	private ZoneDeDessin zdd;
	private Dessin d;
	
	public Previsualiseur(int width, int height, ZoneDeDessin zdd){
		this.zdd =zdd;
		setLayout(null);
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(width, height));
		setSize(new Dimension(width, height));
		
		CreateurDessin cd = zdd.getCreateurDessin();
		cd.setForeground(zdd.getForeground());		
		
		d = cd.creerDessin();
		repaint();
		
		for(MouseListener l : d.getListeners(MouseListener.class)){
			d.removeMouseListener(l);
		}
		for(MouseMotionListener ml : d.getListeners(MouseMotionListener.class)){
			d.removeMouseMotionListener(ml);
		}
		
		add(d);
		setOpaque(true);
		setVisible(true);
	}

	public void setDessin(Dessin d) {
		this.d = d;
		removeAll();
		add(d);
		repaint();
	}

	public Dessin getDessin() {
		return d;
	}

	public ZoneDeDessin getZdd() {
		return zdd;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		d.setBounds(20, 20,getWidth()-40, getHeight()-40);
	}

}
