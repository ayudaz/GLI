package controle;

import presentation.PTasDeCartes;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;

public class CTasDeCartes extends TasDeCartes {
		
		private PTasDeCartes presentation;
		
		public CTasDeCartes(String nom, CUsine u){
			super(nom, u);
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
						//pTasDeCartes.empiler((CCarte)carte)).getPresentation();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// /!\ DOIT LEVER UNE EXCEPTION /!\
		//public void depiler() throws Exception{
		public void depiler(){	
			try {
				Carte carte = getSommet();
				super.depiler();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			presentation.depiler((CCarte)carte).getPresentation());
		}
		
		
}
