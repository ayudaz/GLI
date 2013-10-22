package controle;

public class CTasDeCartesColores extends TasDeCartesColores {
	
	public void p2c_dragEnter(CCarte cc){
		if(isEmpilable(cc)){
			presentation.showEmpilable();
		}
		else{
			presentation.showNonEmpilable();
		}
	}
	
	public void p2c_dragExit(CCarte cc){
		presentation.c2p_showNeutre();
	}
	
	public void p2c_drop(CCarte cc){
		if(isEmpilable(cc)){
			empiler(cc);
			presentation.c2p_finDnDOK();
		}
		else{
			presentation.c2p_finDnDKO();
		}
		presentation.c2p_showNeutre();
	}
}
