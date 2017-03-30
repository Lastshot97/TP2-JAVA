import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import puisQuatre.Puis4;

/**
 * Ecouteur du boutton permettant de charger la dernière partie sauvegarder
 * 
 * @author Julien | Hugo
 *
 */
public class ChargerListener implements ActionListener {

	private MenuFrame menuFrame;
	
	public ChargerListener(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("sauvegarde.pw4"));
			new Puiss4Frame((Puis4) ois.readObject());
			ois.close();
			menuFrame.dispose();  // on ferme la fenetre seulement si le chargement est réussi
			Logger.log(Logger.DEBUG, "chargement d'une partie precedente");
		} catch (Exception e) {
			Logger.log(Logger.IMPORTANT, "echec du chargement" + e);;
		} 
	}

}
