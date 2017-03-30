import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.*;
/**
 * Classe permettant de jouer un son 
 * 
 * le son doit être suffisament court pour ne pas risquer d'en chevaucher un autre
 * 
 * @author Julien | Hugo
 * @see PlayMusic
 *
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
		Logger.log(Logger.ALL, "Joue musique jeton");
	}
	public static void boutton() {
		play("boutton.wav");	
		Logger.log(Logger.DEBUG, "Joue musique bouton");
	}
	public static void sauvegarde() {
		play("sauvegarde.wav");	
		Logger.log(Logger.DEBUG, "Joue musique bouton sauvegarde");
	}	
}
