package v2;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PrevisualiseurListener implements PropertyChangeListener {
	
	Previsualiseur previsualiseur;
	
	public PrevisualiseurListener(Previsualiseur p){
		this.previsualiseur = p;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getPropertyName() == "foreground"){
			previsualiseur.getDessin().setForeground(((Color)evt.getNewValue()));
			previsualiseur.repaint();
		}
		if(evt.getPropertyName() == "forme"){
			CreateurDessin cd = (CreateurDessin) evt.getNewValue();	
			Dessin d = cd.creerDessin();
			d.setForeground(previsualiseur.getZdd().getForeground());	
			d.setBounds(20, 20,previsualiseur.getWidth()-40,previsualiseur.getHeight()-40);
			previsualiseur.setDessin(d);
		}
	}

}
