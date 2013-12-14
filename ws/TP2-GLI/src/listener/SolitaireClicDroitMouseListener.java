package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.TasDeCartesColorees;
import controle.CSabot;

public class SolitaireClicDroitMouseListener implements MouseListener {
	
	private CSabot sabot;
	private Colonne[] colonnes;
	private TasDeCartesColorees[] tasDeCartesColorees;
	
	public SolitaireClicDroitMouseListener(CSabot sabot, Colonne[] colonnes, TasDeCartesColorees[] tasDeCartesColorees){
		this.sabot = sabot;
		this.colonnes = colonnes;
		this.tasDeCartesColorees = tasDeCartesColorees;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)){
			boolean trouve = true;
			while(trouve){
				trouve = false;
				Carte carte;
				try {
					if(!sabot.isVide()){
						carte = sabot.getSommet();
						for(TasDeCartesColorees tas : tasDeCartesColorees){
							if(tas.isEmpilable(carte)){
								trouve = true;
								sabot.depiler();
								tas.empiler(carte);
							}
						}
					}
					for(Colonne col : colonnes){
						if(!col.isVide()){
							carte = col.getSommet();
							for(TasDeCartesColorees tas : tasDeCartesColorees){
								if(tas.isEmpilable(carte)){
									trouve = true;
									col.depiler();
									tas.empiler(carte);
								}
							}
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
