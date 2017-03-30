import java.io.FileNotFoundException;
import java.io.PrintWriter;

import puisQuatre.Puis4;

/**
 * Classe permettant le lancement de l'application
 * 
 * @author Julien | Hugo
 * @see MenuFrame
 */
public class LanceFrame {

	public static void main(String[] args) {
		try {
			new Logger(Logger.ALL,new PrintWriter("LogPuissance4"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Logger.log(Logger.INFO, "lancement du jeu");
		PlayMusic.init();
		Puis4 modele = new Puis4(7, 8, 1);
		new MenuFrame(modele);
	}

}
