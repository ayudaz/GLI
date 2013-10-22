package controle;

import presentation.PSabot;

public class CSabot extends Sabot{
		private PSabot pSabot;
		private CCarte enTransit;
		
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
		
		public void empiler(CCarte cc){
			//TODO à FAIRE !!!
		}
		
		public CCarte getSommet(){
			//TODO c'est pas bon !!!!
			return new CCarte(0, 0);
		}
		
		public void p2c_debutDnD(CCarte cc){
			if(cc == getSommet()){
				depiler();
				enTransit = cc;
				presentation.c2p_debutDnDOK(cc.getPresentation());
			}
			else{
				presentation.c2p_debutDnDKO(cc.getPresentation());
			}
		}
		
		public void p2c_finDnD(boolean s){
			if(!s){
				empiler(enTransit);
			}
		}
		
}
