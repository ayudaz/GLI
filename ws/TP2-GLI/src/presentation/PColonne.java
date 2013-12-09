package presentation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CColonne;

public class PColonne extends DragAndDrop {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012710342824704043L;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;
	private SpringLayout layout;
	private static final int DECALY = 15;
	private JPanel successTopPanel;
	private JPanel errorTopPanel;
	
	public PColonne(CColonne cc, PTasDeCartes cachees,
			PTasDeCartesAlternees visibles) {
		controle = cc;
		this.cachees = cachees;
		this.visibles = visibles;
		// SpringLayout
		layout = new SpringLayout();
		this.setLayout(layout);

		// ajout des composants au panel
		this.add(cachees);
		this.cachees.setDxDy(0, DECALY);
		this.add(visibles, 0);
		this.visibles.setDxDy(0, DECALY);

		// ajout du listener de retournement des cartes
		this.addMouseListener(new RetournerCarteListener());

		// ajoute les contraintes sur la colonne
		setContraintes();

		// Pour que le fond du jeu soit visible
		// setOpaque(false);
		setBackground(Color.BLACK);
		
		
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

	public void setContraintes() {
		this.cachees.setContraintes();
		this.visibles.setContraintes();
		layout.putConstraint(SpringLayout.WEST, this.cachees, 0,
				SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, this.cachees, 0,
				SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, this.visibles, 0,
				SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST,
				this.cachees);
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH,
				this.visibles);
		
		if (this.cachees.getComponentCount() == 0) {
			layout.putConstraint(SpringLayout.NORTH, this.visibles,
					-PCarte.hauteur, SpringLayout.SOUTH, this.cachees);
		} else {
			layout.putConstraint(SpringLayout.NORTH, this.visibles,
					-PCarte.hauteur + DECALY, SpringLayout.SOUTH, this.cachees);
		}
		if (this.visibles.getComponentCount() == 0) {
			layout.putConstraint(SpringLayout.SOUTH, this, 0,
					SpringLayout.SOUTH, this.cachees);
		}

		validate();
		repaint();
	}

	public void empiler(PCarte c) {
		this.visibles.empiler(c);
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur
				+ DECALY, SpringLayout.SOUTH, this.cachees);
		
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
	}

	public void empiler(PTasDeCartes ptas) {
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur
				+ DECALY, SpringLayout.SOUTH, this.cachees);
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
	}

	public void depiler(PCarte c) {
		this.visibles.depiler(c);
		setContraintes();
		if (!((CColonne) controle).isCarteRetournable()) {
			cacherCachees();
		}
		if (((CColonne) controle).isVide()) {
			cacherVisibles();
		}
	}

	public void retournerCarte(boolean cacheesVide) {
		setContraintes();
		layout.putConstraint(SpringLayout.NORTH, this.visibles, -PCarte.hauteur
				+ DECALY, SpringLayout.SOUTH, this.cachees);
		if (cacheesVide) {
			cacherCachees();
		}
		validate();
		repaint();
	}

	public void cacherCachees() {
		layout.putConstraint(SpringLayout.NORTH, visibles, -PCarte.hauteur,
				SpringLayout.SOUTH, cachees);
	}

	public void cacherVisibles() {
		layout.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH,
				cachees);
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
