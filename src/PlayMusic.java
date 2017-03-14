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
	
	public static void play(String monFichier){
		try{
			if (clip.isRunning()){
				clip.stop();
				clip.flush();
				clip.close();
				Thread.sleep(100);
			}
			File f = new File(monFichier);
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
			clip.open(inputStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.err.println("mauvais fichier son");
		}catch (Exception ex){
			System.err.println(ex);
		}
	}
}