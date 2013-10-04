package controle;

import presentation.PTasDeCartes;

public class CTasDeCartes extends TasDeCartes {
		
		private PTasDeCartes pTasDeCartes;
		
		public CTasDeCartes(String nom, CUsine u){
			super(nom, u);
			pTasDeCartes = new PTasDeCartes(this);
		}
		
		public void empiler (Carte carte){
			if(isEmpilable(carte)){
				super.empiler(carte);
				if(carte == getSommet()){
					//pTasDeCartes.empiler((CCarte)carte)).getPresentation();
				}
			}
		}
		
		// /!\ DOIT LEVER UNE EXCEPTION /!\
		//public void depiler() throws Exception{
		public void depiler(){	
			Carte carte = getSommet();
			super.depiler();
			//pTasDeCartes.depiler((CCarte)carte).getPresentation());
		}
		
}
