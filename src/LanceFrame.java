//import puisQuatre.Puis4;
/*
 * Main permettant le lancement de l'application
 */
public class LanceFrame {

	public static void main(String[] args) {
		PlayMusic.init();
		Puis4 modele = new Puis4();
		new MenuFrame(modele);
	}

}
