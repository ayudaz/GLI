package v2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public abstract class Dessin extends JPanel {
	
	private Point position;
	
	public Dessin() {
		// TODO Auto-generated constructor stub
		super();
		this.setOpaque(false);
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListerner(this));
		
	}
	
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			position = e.getPoint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MyMouseMotionListerner implements MouseMotionListener{
		private Dessin dessin;
		
		public MyMouseMotionListerner(Dessin dessin) {
			// TODO Auto-generated constructor stub
			this.dessin = dessin;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			dessin.setLocation((int)(e.getX()-dessin.position.getX()+dessin.getX()),(int)(e.getY()-dessin.position.getY()+dessin.getY()));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		
	}

}
