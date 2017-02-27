import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class replayGame implements ActionListener {

	private Puis4 modele;
	private Puis4Dialog dialogFrame;
	
	public replayGame(Puis4Dialog dialogFrame, Puis4 modele) {
		this.modele = modele;
		this.dialogFrame = dialogFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialogFrame.dispose();
		modele.nouveauJeu(modele.getNbColonnes(), modele.getNbLignes(),modele.getNiveauJeu());
	}

}
