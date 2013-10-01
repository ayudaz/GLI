package v2;

import java.awt.Color;

public abstract class CreateurDessin {
	
	private Color foreground;
	
	abstract Dessin creerDessin();

	void setForeground(Color foreground){
		this.foreground = foreground;
	}
}
