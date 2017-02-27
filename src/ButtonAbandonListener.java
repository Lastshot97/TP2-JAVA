import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class ButtonAbandonListener implements ActionListener {

	private Puis4 modele;
	
	public ButtonAbandonListener(Puis4 modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(), modele.getNiveauJeu());
	}

}
