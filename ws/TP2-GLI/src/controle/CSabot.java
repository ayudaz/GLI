package controle;

import presentation.PSabot;

public class CSabot extends Sabot{
		private PSabot pSabot;
		
		public CSabot(String nom, CUsine u){
			super(nom,u);
			//p = new PSabot((CTasDeCartes)cachees).getPresentation()), ((CTasDeCartes)visibiles).getPresenation());
		}
		
		// ICI ?????
		public void setReserve(Tas t){
			super.setReserve(t);
			if(isRetournable()){
				pSabot.activerRetournerCarte();
			}
			else{
				pSabot.desactiverRetournerCarte();
				
				if(isRetournable()){
					pSabot.activerRetournerSabot();
				}
				else{
					pSabot.desactiverRetournerSabot();
				}
			}
		}
			
		public void retourner(){
			super.retourner();
			pSabot.desactiverRetournerSabot();
			if(isRetournable()){
				pSabot.activerRetournerCarte();
			}
		}
		
		public void depiler(){
			super.depiler();
			if(!isRetournable()){
				pSabot.desactiverRetournerSabot();
			}
		}
		
}
