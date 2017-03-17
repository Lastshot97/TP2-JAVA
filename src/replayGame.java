import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import puisQuatre.Puis4;
/*
 * Cette classe associe un Listener au bouton "rejouer" de la fenêtre de dialogue victoire/défaite
 * Rôle : fermer la boîte de dialogue et relancer une partie avec les mêmes paramètres
 */
public class replayGame implements ActionListener {

	private Puis4 modele;
	private Puis4Dialog dialogFrame;
	private GrillePuiss4Canvas grille;
	
	public replayGame(Puis4Dialog dialogFrame, Puis4 modele, GrillePuiss4Canvas grille) {
		this.modele = modele;
		this.dialogFrame = dialogFrame;
		this.grille = grille;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialogFrame.dispose();
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(),modele.getNiveauJeu());
		grille.repaint();	
	}

}
