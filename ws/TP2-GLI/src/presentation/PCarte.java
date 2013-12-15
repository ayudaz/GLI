package presentation;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.CCarte;

/**
 * Composant Pr�sentation d'une carte
 */
public class PCarte extends JPanel implements Transferable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8803764380933046718L;
	protected CCarte controle;
	protected JLabel face, dos;
	protected ImageIcon icone;
	protected static ImageIcon iconeDos;
	public static int largeur, hauteur;

	/**
	 * initialiser une carte
	 * 
	 * @param chaine
	 *            : nom de la carte (exemple "3H" = 3 Heart)
	 */
	public PCarte(final String chaine, final CCarte controle) {
		this.controle = controle;

		// image de la face
		icone = new ImageIcon(ClassLoader.getSystemResource("cartes/" + chaine
				+ ".gif"));
		face = new JLabel(icone);
		add(face);
		face.setLocation(0, 0);
		face.setSize(largeur, hauteur);

		// image du dos
		dos = new JLabel(iconeDos);
		add(dos);
		dos.setLocation(0, 0);
		dos.setSize(largeur, hauteur);

		// le JPanel
		setLayout(null);
		setOpaque(false);
		setSize(face.getSize());
		setPreferredSize(getSize());
		setFaceVisible(false);
	} // constructeur

	/**
	 * changer la visibilit� de la carte
	 * 
	 * @param faceVisible
	 *            : vrai si la face est visible, faux sinon
	 */
	public void setFaceVisible(boolean faceVisible) {
		face.setVisible(faceVisible);
		dos.setVisible(!faceVisible);
	}

	public final CCarte getControle() {
		return controle;
	}

	public ImageIcon getIcone() {
		return icone;
	}

	/**
	 * initialiser l'image du dos et les dimensions d'une PCarte
	 */
	static {
		iconeDos = new ImageIcon(
				ClassLoader.getSystemResource("cartes/dos.gif"));
		largeur = iconeDos.getIconWidth();
		hauteur = iconeDos.getIconHeight();
	}

	@Override
	public Object getTransferData(DataFlavor arg0)
			throws UnsupportedFlavorException, IOException {
		return this;
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return null;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0) {
		return true;
	}

} // PCarte