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
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
		pilesAlternees.setLayout(new BoxLayout(pilesAlternees, BoxLayout.X_AXIS));
		
		// Ajout des composants au Solitaire
		JPanel haut = new JPanel();
		haut.setLayout(new BorderLayout());
		haut.setOpaque(false);
		haut.add(sabot, BorderLayout.CENTER);
		haut.add(pilesColorees, BorderLayout.LINE_END);
		this.add(haut, BorderLayout.PAGE_START);
		this.add(pilesAlternees, BorderLayout.CENTER);
		pilesAlternees.add(Box.createRigidArea(new Dimension(30, 0)));
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
	 */
	public void setSabot(PSabot sabot) {
		this.sabot.add(sabot);
	}

	public void addColonne(PColonne pileAlternee) {
		this.pilesAlternees.add(pileAlternee);
		this.pilesAlternees.add(Box.createHorizontalGlue());
	}

	public void addPileColorees(PTasDeCartesColorees pileColorees) {
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

	public void afficheMessageGagne() {
		JOptionPane.showMessageDialog(getParent(),"Eggs are not supposed to be green.");
	}

	public void afficheMessagePerd() {
		JOptionPane.showMessageDialog(getParent(),"It works !");
	}
}
