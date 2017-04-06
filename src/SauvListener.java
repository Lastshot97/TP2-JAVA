import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import puisQuatre.Puis4;

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
	private TextField selectNomSauv;
	private SauvDialog sauvDialog;
	private Puis4 modele;
	
	public SauvListener(SauvDialog sauvDialog, Puis4 modele, TextField selectNomSauv) {
		this.selectNomSauv = selectNomSauv;
		this.sauvDialog = sauvDialog;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ObjectOutputStream oos;
		String nomSauv = selectNomSauv.getText();
		System.out.println("wow : " + nomSauv);
		try {
			// traite les noms de fichiers invalides
			if(nomSauv.length() < 1){ 
				throw new Exception("nom invalide : " + nomSauv);  // TODO faire une exception personalisé
			}
			oos = new ObjectOutputStream(new FileOutputStream(nomSauv + ".pw4"));
			oos.writeObject(modele);
			oos.close();
			PlaySound.sauvegarde();
			Logger.log(Logger.DEBUG, "Sauvegarde de la partie sous le nom : " + nomSauv);
		} catch (IOException ioe) {
			Logger.log(Logger.IMPORTANT, "Echec de la création de la sauvegarde");
		} catch (Exception e) {
			Logger.log(Logger.IMPORTANT, e.getMessage());
		} finally {  
			// même si la sauvegarde n'est pas effectuée, on ferme le boite de dialog
			sauvDialog.dispose();
		}		
	}

}
