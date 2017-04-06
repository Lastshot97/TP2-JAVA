import java.awt.Choice;
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
	private Choice nomSauv;
	
	public ChargerListener(MenuFrame menuFrame, Choice nomSauv) {
		this.menuFrame = menuFrame;
		this.nomSauv = nomSauv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(nomSauv.getSelectedItem()));
			new Puiss4Frame((Puis4) ois.readObject());
			ois.close();
			menuFrame.dispose();  // on ferme la fenetre seulement si le chargement est réussi
			Logger.log(Logger.DEBUG, "chargement d'une partie precedente : " + nomSauv.getSelectedItem());
		} catch (Exception e) {
			Logger.log(Logger.IMPORTANT, "echec du chargement" + e);;
		} 
	}

}
