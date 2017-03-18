import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du boutton permettant de relancer une partie avec les même paramètres
 * 
 * @author Julien | Hugo
 *
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
