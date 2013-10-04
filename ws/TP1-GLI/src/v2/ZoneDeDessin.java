/**
 * 
 */
package v2;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {
	
	private Point debut = new Point();
	private Point fin = new Point();
	/**
	 * Current_state of pattern State
	 */
	private CreateurDessin cd;
	private Dessin d;
	
	public ZoneDeDessin(){
		super();
		this.setVisible(true);
		this.addMouseListener(new MyMouseListener());
		this.addMouseMotionListener(new MyMouseMotionListener());
		this.setLayout(null);
	}
	
	
	/**
	 * @param d the d to set
	 */
	public void setCD(CreateurDessin cd) {
		this.cd = cd;
		firePropertyChange("forme", "we don't care", cd);
	}


	public CreateurDessin getCreateurDessin(){
		return cd;
	}

	class MyMouseListener implements MouseListener {

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
			debut = e.getPoint();
			d = cd.creerDessin();
			d.setForeground(getForeground());
			add(d,0);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class MyMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			fin = e.getPoint();
			d.setBounds((int)Math.min(debut.getX(), fin.getX()), (int)Math.min(debut.getY(), fin.getY()), (int)Math.abs(debut.getX()-fin.getX()), (int)Math.abs(debut.getY()-fin.getY()));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


