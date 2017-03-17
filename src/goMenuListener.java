import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import puisQuatre.Puis4;
/*
 * Cette classe permet d'associé un Listener au bouton "Retour au Menu" de la fenêtre de jeu
 * Rôle : fermer la fenêtre de jeu et lancer le Menu principale
 */
public class goMenuListener implements ActionListener {
	
	private Puiss4Frame principalFrame;
	private Puis4 modele;
	public goMenuListener(Puiss4Frame principalFrame, Puis4 modele) {
		this.principalFrame = principalFrame;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		principalFrame.dispose();
		new MenuFrame(modele);		
	}

}
