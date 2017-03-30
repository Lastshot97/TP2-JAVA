import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

/**
 * Ecouteur permettant de relançer une partie après que la fin de la précedente
 * 
 * @author Julien | Hugo
 * @see Puis4Dialog
 *
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
		Logger.log(Logger.DEBUG, "Click sur le bouton 'rejouer' ");
		dialogFrame.dispose();
		Logger.log(Logger.DEBUG, "Fermeture de la fenêtre de dialogue");
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(),modele.getNiveauJeu());
		Logger.log(Logger.DEBUG, "Nouvelle partie. Difficulté : " + modele.getNiveauJeu() + " - Taille grille : " + modele.getNbColonnes() + "x" + modele.getNbLignes());
		PlayMusic.play("jeu.wav", true);
		grille.repaint();	
	}

}
