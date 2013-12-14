/**
 * 
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import listener.ColonneMouseListener;
import listener.SabotMouseListener;
import listener.SolitaireClicDroitMouseListener;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.TasDeCartesColorees;
import controle.CSabot;
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
	private BufferedImage bgImg;
	GridBagConstraints gridBagConstraints;
	private TexturePaint bgTexture;
	
	private CSolitaire controle;
	
	public PSolitaire(CSolitaire controle){
		this.controle = controle;
		
		// Cr�ation des trois JPanel
		pilesAlternees = new JPanel();
		pilesColorees = new JPanel();
		sabot = new JPanel();
		sabot.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
		Dimension d = new Dimension(PCarte.largeur*2 + 30 + 15*24, PCarte.hauteur);
		sabot.setPreferredSize(d);
		
		// Pour que le fond du jeu soit visible partout
		sabot.setOpaque(false);
		pilesColorees.setOpaque(false);
		pilesAlternees.setOpaque(false);
		
		
		// Assignation des layout manager aux JPanel
		this.setLayout(new BorderLayout(0, 30));
		pilesColorees.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		pilesAlternees.setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridwidth = 7;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
		gridBagConstraints.insets = new Insets(20, 30, 0, 30);
		
		// Ajout des composants au Solitaire
		JPanel haut = new JPanel();
		haut.setLayout(new BorderLayout());
		haut.setOpaque(false);
		haut.add(sabot, BorderLayout.CENTER);
		haut.add(pilesColorees, BorderLayout.LINE_END);
		this.add(haut, BorderLayout.PAGE_START);
		this.add(pilesAlternees, BorderLayout.CENTER);
		Dimension sol = new Dimension(1000, 600);
		this.setPreferredSize(sol);
		
		// Fond du jeu
		this.bgImg = this.toBufferedImage(Toolkit.getDefaultToolkit().getImage("src/ressources/bg.jpg"));
		this.bgTexture = new TexturePaint(bgImg,new Rectangle(0, 0, bgImg.getWidth(), bgImg.getHeight()));
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g; 
		g2d.setPaint(bgTexture);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	/**
	 * @param sabot the sabot to set
	 * @param pilesColorees 
	 */
	public void setSabot(PSabot sabot, TasDeCartesColorees[] pilesColorees) {
		this.sabot.add(sabot);
		sabot.setSabotMouseListener(new SabotMouseListener(sabot.getControle(), pilesColorees));
	}

	public void addColonne(PColonne pileAlternee, TasDeCartesColorees[] pilesColorees) {
		this.pilesAlternees.add(pileAlternee, gridBagConstraints);
		pileAlternee.setColonneListener(new ColonneMouseListener(pileAlternee.getControle(), pilesColorees));
	}

	public void addPileColorees(PTasDeCartesColorees pileColorees) {
		this.pilesColorees.add(pileColorees);
	}
	
	public void setClicDroitMouseListener(CSabot sabot,	Colonne[] colonnes, TasDeCartesColorees[] tasDeCartesColorees) {
		this.addMouseListener(new SolitaireClicDroitMouseListener(sabot, colonnes, tasDeCartesColorees));
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

	public void afficheMessageGagne() {
		JOptionPane.showMessageDialog(getParent(),"Félicitations ! Vous avez gagnez !");
	}

	
}
