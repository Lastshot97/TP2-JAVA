import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import puisQuatre.Puis4;


/**
 * Ecouteur permettant de lancer une boite de dialogue demandant le nom de la sauvegarde à effectuée
 * 
 * @author Julien | Hugo
 *
 */
public class ChoixSauvListener implements ActionListener {
	
	private Frame puiss4Frame;
	private Puis4 modele;

	public ChoixSauvListener(Puiss4Frame puiss4Frame, Puis4 modele) {
		this.puiss4Frame = puiss4Frame;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Logger.log(Logger.DEBUG, "Click sur Sauvegarde");
		
		try {
			new SauvDialog(puiss4Frame, modele);
		} catch (IOException e) {
			Logger.log(
				Logger.IMPORTANT,
				"echec de la création d'une boite de dialogue : " + e.toString()
				);
		}

	}

}
