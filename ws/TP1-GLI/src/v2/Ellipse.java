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
		Point center = new Point(
				this.getWidth()/2,
				this.getHeight()/2);

          double _xRadius = this.getWidth() / 2;
          double _yRadius = this.getHeight() / 2;


          if (_xRadius <= 0.0 || _yRadius <= 0.0)
              return false;
          
          Point normalized = new Point(x - center.x,
                                       y - center.y);

          return ((double)(normalized.x * normalized.x)
                   / (_xRadius * _xRadius)) + ((double)(normalized.y * normalized.y) / (_yRadius * _yRadius))
              <= 1.0;
	}
}
