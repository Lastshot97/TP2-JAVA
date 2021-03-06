import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import puisQuatre.Puis4;

/**
 * Ecouteur du boutton permettant de choisir les <em>paramètres</em> de la partie à lancer
 * 
 * @author Julien | Hugo
 *
 */class ButtonNewGameListener implements ActionListener {

	private Puis4 modele;
	private Frame menu;
	
	public ButtonNewGameListener(Frame menu, Puis4 modele) {
		this.modele = modele;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			new NewGameDialog(menu, modele);
			Logger.log(Logger.DEBUG, "nouvelle partie");
		} catch (IOException e) {
			Logger.log(Logger.IMPORTANT, "echec de la création d'une fenetre de dialog"
			+ "permettant de lancer une partie" + e);
		}
	}

}
