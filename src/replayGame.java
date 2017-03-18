import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		dialogFrame.dispose();
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(),modele.getNiveauJeu());
		PlayMusic.play("jeu.wav", true);
		grille.repaint();	
	}

}
