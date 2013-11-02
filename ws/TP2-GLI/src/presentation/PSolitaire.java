/**
 * 
 */
package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controle.CSolitaire;

/**
 * @author Lelievre Thomas & Leloup Florian
 *
 */
public class PSolitaire extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4769739927354638675L;
	
	private JPanel sabot;
	private JPanel pilesAlternees;
	private JPanel pilesColorees;
	private SpringLayout layoutSolitaire;
	private SpringLayout layoutColorees;
	private SpringLayout layoutAlternees;
	private SpringLayout layoutSabot;
	private BufferedImage bgImg;
	private TexturePaint bgTexture;
	
	private CSolitaire controle;
	
	public PSolitaire(CSolitaire controle){
		this.controle = controle;
		
		// Création des trois JPanel
		pilesAlternees = new JPanel();
		pilesColorees = new JPanel();
		sabot = new JPanel();
		
		// Pour que le fond du jeu soit visible partout
		sabot.setOpaque(false);
		pilesColorees.setOpaque(false);
		pilesAlternees.setOpaque(false);
		
		// Création des layout manager SpringLayout
		layoutSolitaire = new SpringLayout();
		layoutColorees = new SpringLayout();
		layoutSabot = new SpringLayout();
		layoutAlternees = new SpringLayout();
		
		// Assignation des layout manager aux JPanel
		this.setLayout(layoutSolitaire);
		pilesColorees.setLayout(layoutColorees);
		sabot.setLayout(layoutSabot);
		pilesAlternees.setLayout(layoutAlternees);
		
		// Ajout des composants au Solitaire
		this.add(sabot);
		this.add(pilesColorees);
		this.add(pilesAlternees);
		
		// Contraintes sur l'afichage du solitaire
		setLayout();
		
		// Fond du jeu
		this.bgImg = this.toBufferedImage(Toolkit.getDefaultToolkit().getImage("src/ressources/bg.jpg"));
		this.bgTexture = new TexturePaint(bgImg,new Rectangle(0, 0, bgImg.getWidth(), bgImg.getHeight()));
	}
	
	public void setLayout(){
		layoutSolitaire.putConstraint(SpringLayout.NORTH, sabot, 0, SpringLayout.NORTH, this);
		layoutSolitaire.putConstraint(SpringLayout.NORTH, pilesColorees, 0, SpringLayout.NORTH, this);
		layoutSolitaire.putConstraint(SpringLayout.NORTH, pilesAlternees, 20, SpringLayout.SOUTH, sabot);
		layoutSolitaire.putConstraint(SpringLayout.WEST, sabot, 0, SpringLayout.WEST, this);
		layoutSolitaire.putConstraint(SpringLayout.WEST, pilesAlternees, 0, SpringLayout.WEST, this);
		layoutSolitaire.putConstraint(SpringLayout.SOUTH, this, 0, SpringLayout.SOUTH, pilesAlternees);
		layoutSolitaire.putConstraint(SpringLayout.EAST, pilesColorees, 0, SpringLayout.EAST, this);
		layoutSolitaire.putConstraint(SpringLayout.EAST, this, 0, SpringLayout.EAST, pilesAlternees);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g; 
		g2d.setPaint(bgTexture);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * @param sabot the sabot to set
	 */
	public void setSabot(PSabot sabot) {
		this.sabot.add(sabot);
		layoutSabot.putConstraint(SpringLayout.NORTH, sabot, 20, SpringLayout.NORTH, this.sabot);
		layoutSabot.putConstraint(SpringLayout.WEST, sabot, 30, SpringLayout.WEST, this.sabot);
		layoutSabot.putConstraint(SpringLayout.SOUTH, this.sabot, 15, SpringLayout.SOUTH, sabot);
		layoutSabot.putConstraint(SpringLayout.EAST, this.sabot, 30, SpringLayout.EAST, sabot);
	}

	public void addColonne(PColonne pileAlternees) {
		int paddingLeft = 30 + pilesAlternees.getComponentCount() * (PCarte.largeur + 30);
		layoutAlternees.putConstraint(SpringLayout.WEST, pileAlternees, paddingLeft, SpringLayout.WEST, pilesAlternees);
		layoutAlternees.putConstraint(SpringLayout.NORTH, pileAlternees, 20, SpringLayout.NORTH, pilesAlternees);
		layoutAlternees.putConstraint(SpringLayout.EAST, pilesAlternees, 30, SpringLayout.EAST, pileAlternees);
		layoutAlternees.putConstraint(SpringLayout.SOUTH, pilesAlternees, 15, SpringLayout.SOUTH, pileAlternees);
		this.pilesAlternees.add(pileAlternees);
	}

	public void addPileColorees(PTasDeCartesColorees pileColorees) {
		int paddingLeft = 30 + pilesColorees.getComponentCount() * (PCarte.largeur + 30);
		layoutColorees.putConstraint(SpringLayout.WEST, pileColorees, paddingLeft, SpringLayout.WEST, pilesColorees);
		layoutColorees.putConstraint(SpringLayout.NORTH, pileColorees, 20, SpringLayout.NORTH, pilesColorees);
		layoutColorees.putConstraint(SpringLayout.EAST, pilesColorees, 30, SpringLayout.EAST, pileColorees);
		layoutColorees.putConstraint(SpringLayout.SOUTH, pilesColorees, 15, SpringLayout.SOUTH, pileColorees);
		this.pilesColorees.add(pileColorees);
		
	}
	
	private BufferedImage toBufferedImage(Image image) {	
		image = new ImageIcon(image).getImage(); 

		BufferedImage bufferedImage = new BufferedImage( image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB); 
		Graphics g = bufferedImage.createGraphics(); 

		g.setColor(Color.white); 
		g.fillRect(0, 0, image.getWidth(null), 
		image.getHeight(null)); 
		g.drawImage(image, 0, 0, null); 
		g.dispose(); 
		return bufferedImage; 
	}
}
