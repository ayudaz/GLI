package v2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class FilledRectangle extends Dessin {

	public FilledRectangle() {
		super();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Rectangle2D.Double(0, 0, getWidth()-1, getHeight()-1));
	}
}
