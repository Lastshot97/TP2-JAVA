import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Classe permettant de sauvegarder le cour actuelle de la partie
 * 
 * attention : supprime la sauvegarde précédente
 * 
 * @author Julien | Hugo
 * @see ChargerListener
 *
 */
public class SauvListener implements ActionListener {
	private Puis4 modele;
	
	public SauvListener(Puis4 modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("sauvegarde.pw4"));
			oos.writeObject(modele);
			oos.close();
			//PlaySound.sauvegarde();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
