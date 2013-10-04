package v2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;

public class ListenerToOpenJCHooserColor implements MouseListener {
	private ZoneDeDessin zdd;
	
	public ListenerToOpenJCHooserColor(ZoneDeDessin zdd){
		this.zdd = zdd;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Color c = JColorChooser.showDialog(zdd.getParent(), "Ma couleur", zdd.getForeground());
		if(c != null){		
			zdd.setForeground(c);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
