package controle;

import presentation.PTasDeCartes;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;

public class CTasDeCartes extends TasDeCartes implements ICTas {
		
		private PTasDeCartes presentation;
		
		public CTasDeCartes(String nom, Usine usine){
			super(nom, usine);
			presentation = new PTasDeCartes(this);
		}
		
		/**
		 * @return the presentation
		 */
		public PTasDeCartes getPresentation() {
			return presentation;
		}

		public void empiler (Carte carte){
			if(isEmpilable(carte)){
				super.empiler(carte);
				try {
					if(carte == getSommet()){
						presentation.empiler(((CCarte)carte).getPresentation());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void depiler() throws Exception {	
			Carte carte;
			carte = getSommet();
			super.depiler();
			presentation.depiler(((CCarte)carte).getPresentation());
		}
		
		
}
