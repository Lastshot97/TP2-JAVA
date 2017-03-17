import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import puisQuatre.Puis4;
/*
 * Cette classe permet d'associé un Listener au bouton "Abandonner" de la fenêtre de jeu
 * Rôle : relancer une partie avec les mêmes paramètres
 */
public class ButtonAbandonListener implements ActionListener {

	private Puis4 modele;
	private GrillePuiss4Canvas grille;
	
	public ButtonAbandonListener(Puis4 modele, GrillePuiss4Canvas grille) {
		this.modele = modele;
		this.grille = grille;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(), modele.getNiveauJeu());
		grille.repaint();
	}
}
