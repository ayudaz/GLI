package v2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class FilledEllipse extends Dessin {

	public FilledEllipse() {
		super();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Ellipse2D.Double(0, 0, getWidth()-1, getHeight()-1));
	}
	
	public boolean contains(int x, int y){
		Ellipse2D e = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
	      return (e.contains (x, y)) ;
	}
}
