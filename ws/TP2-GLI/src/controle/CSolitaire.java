package controle;

import presentation.PSolitaire;
import solitaire.application.Colonne;
import solitaire.application.Solitaire;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;

public class CSolitaire extends Solitaire implements Observer {
	
	private PSolitaire presentation;

	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);
		this.presentation = new PSolitaire(this);
	}
	
	/**
	 * @return the presentation
	 */
	public PSolitaire getPresentation() {
		return presentation;
	}

	@Override
	public void initialiser(){
		super.initialiser();
		
		presentation.setSabot(((CSabot)this.sabot).getPresentation(), this.pilesColorees);
		
		for(TasDeCartesColorees tas : this.pilesColorees){
			presentation.addPileColorees(((CTasDeCartesColorees)tas).getPresentation());
			((CTasDeCartesColorees)tas).addObserver(this);
		}
		
		for(Colonne col : this.pilesAlternees){
			presentation.addColonne(((CColonne)col).getPresentation(), this.pilesColorees);
		}
		
		presentation.setClicDroitMouseListener((CSabot)this.sabot, this.pilesAlternees, this.pilesColorees);
	}
	
	@Override
	public void traiterJeu(char paramChar){
		super.traiterJeu(paramChar);
	}

	@Override
	public void update() {
		if(gagne()){
			presentation.afficheMessageGagne();
		}
	}
	
	@Override
	public void run(){
		super.run();
	}
	
	
}
