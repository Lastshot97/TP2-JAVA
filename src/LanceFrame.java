import puisQuatre.Puis4;

/**
 * Classe permettant le lancement de l'application
 * 
 * @author Julien | Hugo
 * @see MenuFrame
 */
public class LanceFrame {

	public static void main(String[] args) {
		Logger.log(Logger.INFO, "lancement du jeu");
		PlayMusic.init();
		Puis4 modele = new Puis4(7, 8, 1);
		new MenuFrame(modele);
	}

}
