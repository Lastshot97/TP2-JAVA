import java.io.File;
import javax.sound.sampled.*;

public class PlayMusic {
	private static Clip clip;

	public static void init() {
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void play(String monFichier, Boolean jouerEnContinue){
		try{
			stop();
			File f = new File(monFichier);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);  //  TODO passer en tant que ressource comme les images
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