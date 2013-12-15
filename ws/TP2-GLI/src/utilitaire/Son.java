package utilitaire;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Son extends Thread {
	private URL u1;//l'url de ton fichier son
    private AudioClip s1;//le son créé depuis ton url
 
    public Son(String nom) {
        u1 = ClassLoader.getSystemResource("sons/"+nom);
        s1 = Applet.newAudioClip(u1);
    }
    public void jouer() {
        s1.play();
    }
    public void jouerEnBoucle() {
        s1.loop();
    }
    public void arreter() {
        s1.stop();
    }
}
