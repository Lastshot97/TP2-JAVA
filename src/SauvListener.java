import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//import puisQuatre.Puis4;
/*
 * Cette classe associe un Listener au bouton "Sauvegarder" de la fenêtre du jeu
 * Rôle : sauvegarder le modèle du jeu 
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
			PlaySound.sauvegarde();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
