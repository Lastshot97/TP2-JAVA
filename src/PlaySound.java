import java.io.File;
import javax.sound.sampled.*;

public class PlaySound {
	
	public static void play(String fichier){
		try{
			/*if (clip.isRunning()){
				clip.stop();
				clip.setFramePosition(0);
				clip.flush();
			}*/
			File f = new File(fichier);
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
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
	public static void sauvegarde() {
		play("sauvegarde.wav");	
	}	
}
