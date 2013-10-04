package v2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyButtonListenerColor implements ActionListener, ChangeListener {
	
	private ZoneDeDessin zdd;
	private Color color;

	public MyButtonListenerColor(ZoneDeDessin zdd, Color c){
		this.color = c;
		this.zdd = zdd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		zdd.setForeground(color);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
				
	}

}
