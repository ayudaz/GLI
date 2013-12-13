package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controle.CColonne;

public class PColonne extends DragAndDrop {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012710342824704043L;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;
//	private SpringLayout layout;
	private static final int DECALY = 15;
	private JPanel successTopPanel;
	private JPanel errorTopPanel;
	
	public PColonne(CColonne cc, PTasDeCartes cachees,
			PTasDeCartesAlternees visibles) {
		controle = cc;
		this.cachees = cachees;
		this.visibles = visibles;
		this.setLayout(null);

		// ajout des composants au panel
		this.add(cachees);
		this.cachees.setDxDy(0, DECALY);
		this.add(visibles, 0);
		this.visibles.setDxDy(0, DECALY);
		
		affichage();
		
		// ajout du listener de retournement des cartes
		this.addMouseListener(new RetournerCarteListener());

		// Pour que le fond du jeu soit visible
		 setOpaque(false);
//		setBackground(Color.BLACK);
		
		
		successTopPanel = new JPanel();
        successTopPanel.setBackground(new Color(.0f, .7f, .0f, .7f));
        successTopPanel.setPreferredSize(new Dimension(PCarte.largeur, 600));
        successTopPanel.setSize(new Dimension(PCarte.largeur, 600));
        successTopPanel.setOpaque(true);
        successTopPanel.setVisible(false);
        this.add(successTopPanel,0);
        
        errorTopPanel = new JPanel();
        errorTopPanel.setBackground(new Color(.8f, .0f, .0f, .7f));
        errorTopPanel.setPreferredSize(new Dimension(PCarte.largeur, 600));
        errorTopPanel.setSize(new Dimension(PCarte.largeur, 600));
        errorTopPanel.setOpaque(true);
        errorTopPanel.setVisible(false);
        this.add(errorTopPanel,0);
        
		//Elements et listeners pour le DnD
		elementDrag = this.visibles;
		dropTarget = new DropTarget(this, new MyDropTargetListener());
		myDragSourceListener = new MyDragSourceListener();
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this.visibles,
				DnDConstants.ACTION_MOVE, new MyDragGestureListener());
		dragSource
				.addDragSourceMotionListener(new MyDragSourceMotionListener());

	}
	
	public void affichage(){
		Insets insets = this.getInsets();
		Dimension sizeCachees = this.cachees.getPreferredSize();
		this.cachees.setBounds(insets.left, insets.top, sizeCachees.width, sizeCachees.height);
		Dimension sizeVisible = this.visibles.getPreferredSize();
		this.visibles.setBounds(insets.left, insets.top+this.cachees.getComponentCount()*DECALY, sizeVisible.width, sizeVisible.height);
		int nbCarte = this.cachees.getComponentCount() + this.visibles.getComponentCount();
		Dimension d = new Dimension(PCarte.largeur, PCarte.hauteur + (nbCarte-1)*DECALY);
		this.setPreferredSize(d);
	}

	public void empiler(PCarte c) {
		this.visibles.empiler(c);
		affichage();
		
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
	}

	public void empiler(PTasDeCartes ptas) {
		affichage();
		
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
	}

	public void depiler(PCarte c) {
		this.visibles.depiler(c);
		affichage();
		
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
		if (((CColonne) controle).isVide()) {
			cacherVisibles();
		}
	}

	public void retournerCarte(boolean cacheesVide) {
		affichage();
		
		if (cacheesVide) {
			cacherCachees();
		}
	}

	public void cacherCachees() {
//		layout.putConstraint(SpringLayout.NORTH, visibles, -PCarte.hauteur,
//				SpringLayout.SOUTH, cachees);
	}

	public void cacherVisibles() {
//		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH,
//				cachees);
	}
	
	public void showAcceptTarget(boolean state) {
		//System.out.println("ShowAcceptTarget with state : "+state);
		if(state){
			successTopPanel.setVisible(true);
		}
		else{
			errorTopPanel.setVisible(true);
		}
	}
	
	public void setNormalState(){
		//System.out.println("Normal state");
		successTopPanel.setVisible(false);
		errorTopPanel.setVisible(false);		
	}
	
	class RetournerCarteListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				((CColonne) controle).retournerCarte();
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
