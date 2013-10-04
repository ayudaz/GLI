package v2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Dessin {
	
	public Ellipse() {
		super();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(0, 0, getWidth()-1, getHeight()-1));
	}
	
	public boolean contains(int x, int y){
		Ellipse2D ePetite = new Ellipse2D.Double(0, 0, getWidth()-10, getHeight()-10);
		Ellipse2D eGrande = new Ellipse2D.Double(0, 0, getWidth()+10, getHeight()+10);
		
	      return (eGrande.contains (x, y) && !(ePetite.contains(x, y))) ;
	}
}
