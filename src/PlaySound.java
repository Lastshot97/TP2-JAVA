import java.io.File;
import javax.sound.sampled.*;

public class PlaySound {
	public static void jeton(){
		try{
			File f = new File("Menu Selection Click.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
			clip.open(inputStream);
			clip.start(); 
		} catch (NullPointerException e) {
			System.err.println("mauvais fichier son");
		}catch (Exception ex){
			System.err.println(ex);
		}
    }
}
