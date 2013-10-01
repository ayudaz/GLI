package v2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Dessin {

	public Rectangle() {
		super();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(0, 0, getWidth()-1, getHeight()-1));
	}
}
