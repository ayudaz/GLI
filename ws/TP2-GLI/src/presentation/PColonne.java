package presentation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CColonne;

public class PColonne extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6012710342824704043L;
	private CColonne controle;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;
	private SpringLayout layout;
	private static final int DECALY = 15;

	public PColonne(CColonne controle, PTasDeCartes cachees, PTasDeCartesAlternees visibles) {
		this.controle = controle;
		this.cachees = cachees;
		this.visibles = visibles;
		// SpringLayout
		layout = new SpringLayout();
		this.setLayout(layout);
		
		// ajout des composants au panel
		this.add(cachees);
		this.cachees.setDxDy(0, DECALY);
		this.add(visibles,0);
		this.visibles.setDxDy(0, DECALY);
		
		//ajout du listener de retournement des cartes
		this.addMouseListener(new RetournerCarteListener());
		
		// ajoute les contraintes sur la colonne
		setContraintes();
		
		// Pour que le fond du jeu soit visible
//		setOpaque(false);
		setBackground(Color.BLACK);
	}
	
	public void setContraintes(){
		this.cachees.setContraintes();
		this.visibles.setContraintes();
		layout.putConstraint(SpringLayout.WEST, this.cachees, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, this.cachees, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.visibles, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, this.cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, this.visibles);
		if(this.cachees.getComponentCount() == 0){
			layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur, SpringLayout.SOUTH, this.cachees);
		}
		else{
			layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur+DECALY, SpringLayout.SOUTH, this.cachees);
		}
		if(this.visibles.getComponentCount() == 0){
			layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, this.cachees);
		}
	}
	
	public void empiler(PCarte c){
		this.visibles.empiler(c);
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur+DECALY, SpringLayout.SOUTH, this.cachees);
		if(!controle.isCarteRetournable()){
			cacherCachees();
		}
	}
	public void empiler(PColonne col) {
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur+DECALY, SpringLayout.SOUTH, this.cachees);
		if(!controle.isCarteRetournable()){
			cacherCachees();
		}
	}
	
	public void depiler(PCarte c){
		this.visibles.depiler(c);
		setContraintes();
		if(!controle.isCarteRetournable()){
			cacherCachees();
		}
		if(controle.isVide()){
			cacherVisibles();
		}
	}
	
	public void retournerCarte(boolean cacheesVide){
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur+DECALY, SpringLayout.SOUTH, this.cachees);
		if(cacheesVide){
			cacherCachees();
		}
		validate();
		repaint();
	}
	
	public void cacherCachees() {
        layout.putConstraint(SpringLayout.NORTH, visibles, -PCarte.hauteur, SpringLayout.SOUTH, cachees);
	}
	
	public void cacherVisibles() {
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, cachees);
	}

	public class RetournerCarteListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				controle.retournerCarte();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	

}
