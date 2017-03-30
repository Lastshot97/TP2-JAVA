import java.io.FileNotFoundException;

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
			new Logger("config1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger.log(Logger.INFO, "lancement du jeu");
		PlayMusic.init();
		Puis4 modele = new Puis4(7, 8, 1);
		new MenuFrame(modele);
	}

}
