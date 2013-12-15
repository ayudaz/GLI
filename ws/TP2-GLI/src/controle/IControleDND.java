package controle;

import javax.swing.JPanel;

public interface IControleDND {
	
	public JPanel getPresentation();
	
	public void p2c_debutDnDDrag(CCarte ccarte);

	public void p2c_finDragSource(boolean dropSuccess);

	public void p2c_finDropTarget(CTasDeCartes ctas);

	public void p2c_DragEnter(ICTas icTas);

	public void p2c_DragExit(ICTas icTas);
}
