import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.*;
/*
 * Cette classe gère la musique de la fenêtre de jeu
 * Elle est constituée de la méthode play(String fichier) qui permet de jouer la musique donnée
 */
public class PlaySound {
	
	public static void play(String fichier){
		try{
			Clip clip = AudioSystem.getClip();
			InputStream audio = PlayMusic.class.getResourceAsStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(audio);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(bis); 
			clip.open(inputStream);
			clip.start();
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("mauvais fichier son");
		}catch (Exception ex){
			System.err.println(ex);
		}
	}
	public static void jeton(){
		play("Menu Selection Click.wav");
	}
	public static void boutton() {
		play("boutton.wav");		
	}
	/*public static void sauvegarde() {
		play("sauvegarde.pw4");	
	}	*/
}
