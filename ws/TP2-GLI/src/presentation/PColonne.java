package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ColonneMouseListener;
import listener.RetournerCarteColonneListener;
import controle.CColonne;

public class PColonne extends DragAndDrop {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6012710342824704043L;
	private PTasDeCartes cachees;
	private PTasDeCartesAlternees visibles;
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
		add(this.cachees);
		add(this.visibles);
		this.cachees.setDxDy(0, DECALY);
		Icon icone = new ImageIcon(ClassLoader.getSystemResource("cartes/fond_colonne.png"));
		JLabel fond = new JLabel(icone);
		this.cachees.add(fond);
		Insets insets = this.cachees.getInsets();
		Dimension sizeFond = fond.getPreferredSize();
		fond.setBounds(insets.left, insets.top, sizeFond.width, sizeFond.height);
		this.visibles.setDxDy(0, DECALY);
		
		affichage();
		
		// ajout du listener de retournement des cartes
		this.cachees.addMouseListener(new RetournerCarteColonneListener(cc));

		// Pour que le fond du jeu soit visible
		 setOpaque(false);
		
		
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
		int nbCarte = this.cachees.getControle().getNombre() + this.visibles.getControle().getNombre();
		Insets insets = this.getInsets();
		Dimension sizeCachees; 
		if(nbCarte != 0){
			sizeCachees = this.cachees.getPreferredSize();
		}
		else{
			sizeCachees = new Dimension(PCarte.largeur, PCarte.hauteur);
		}
		Dimension sizeVisible = this.visibles.getPreferredSize();
		
		this.cachees.setBounds(insets.left, insets.top, sizeCachees.width, sizeCachees.height);
		this.visibles.setBounds(insets.left, insets.top+this.cachees.getControle().getNombre()*DECALY, sizeVisible.width, sizeVisible.height);
		
		Dimension d;
		if(nbCarte != 0){
			d = new Dimension(PCarte.largeur, PCarte.hauteur + (nbCarte-1)*DECALY);
		}
		else{
			d = new Dimension(PCarte.largeur, PCarte.hauteur);
		}
		this.setPreferredSize(d);
		this.setSize(d);
		repaint();
	}

	public void empiler(PCarte c) {
		if(getControle().isVide()){
			this.add(visibles, 0);
		}
		this.visibles.empiler(c);
		affichage();
	}
	
	public void empiler(PTasDeCartes tas) {
		if(!getControle().isVide()){
			this.add(visibles, 0);
		}
		affichage();
	}

	public void depiler(PCarte c) {
		this.visibles.depiler(c);
		if(getControle().isVide()){
			this.remove(visibles);
		}
		affichage();
	}

	public void retournerCarte() {
		affichage();
		this.add(visibles, 0);
	}
	
	@Override
	public void finDnDValide() {
		super.finDnDValide();
		System.out.println("Fin DND valide");
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

	public CColonne getControle() {
		return (CColonne) controle;
	}

	public void setColonneListener(ColonneMouseListener colonneMouseListener) {
		visibles.addMouseListener(colonneMouseListener);
	}

}
