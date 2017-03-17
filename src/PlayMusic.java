
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.*;
/*
 * Cette classe gère la musique du menu principale
 * Elle est composée des méthodes :
 * - init() : permet de récupérer une instance de Clip
 * - play(String nomFichier, Boolean jouerEnContinue) : permet de jouer un morceau donné en continu ou non
 */
public class PlayMusic {
	private static Clip clip;

	public static void init() {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void play(String nomFichier, Boolean jouerEnContinue){
		try{
			stop();
			InputStream audio = PlayMusic.class.getResourceAsStream(nomFichier);
			BufferedInputStream bis = new BufferedInputStream(audio);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(bis); 			
			clip.open(inputStream);
			if (jouerEnContinue){
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}else{
				clip.start();
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("mauvais fichier son");
		}catch (Exception ex){
			System.err.println(ex);
		}
	}
	public static void stop(){
		clip.stop();
		clip.flush();
		clip.close();
	}
}