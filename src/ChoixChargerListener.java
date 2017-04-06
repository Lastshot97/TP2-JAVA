import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * Ecouteur permettant de lancer une boite de dialogue demandant le nom de la sauvegarde à effectuée
 * 
 * @author Julien | Hugo
 *
 */
public class ChoixChargerListener implements ActionListener {
	
	private MenuFrame mf;

	public ChoixChargerListener(MenuFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Logger.log(Logger.DEBUG, "Click sur Charger");
		
		try {
			new ChargerDialog(mf);
		} catch (IOException e) {
			Logger.log(
				Logger.IMPORTANT,
				"echec de la création d'une boite de dialogue : " + e.toString()
				);
		}

	}

}