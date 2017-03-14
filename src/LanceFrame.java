import puisQuatre.Puis4;

public class LanceFrame {

	public static void main(String[] args) {
		PlayMusic.init();
		Puis4 modele = new Puis4();
		new MenuFrame(modele);
	}

}
