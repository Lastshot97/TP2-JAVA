import java.awt.*;
import java.io.IOException;

import puisQuatre.Puis4;

/**
 * Fenetre de dialogue permettant de choisir les paramètres d'une nouvelles partie
 * 
 * les deux paramètres réglables sont :
 * - la difficulté de l'ordinateur
 * - les dimensions de la grille
 * 
 * @author Julien | Hugo
 *
 */
public class SauvDialog extends Dialog {

	private static final long serialVersionUID = 1L;
	
	public SauvDialog(Frame fenetreJeu, Puis4 modele) throws IOException {
		super(fenetreJeu, "Sauvegarde", true);
		
		this.setSize(400,300);
		this.setLocationRelativeTo(fenetreJeu);
		this.setResizable(true);
		this.setLayout(new GridLayout(3, 1));
		
		Label difficulte = new Label("Choissiser le nom de votre sauvegarde");
		
		TextField selectNomSauv = new TextField();
		
		Button jouer = new Button("Sauvegarder");
		jouer.addActionListener(new SauvListener(this, modele, selectNomSauv));
				
		this.add(difficulte);
		this.add(selectNomSauv);
		this.add(jouer);
		
		this.addWindowListener(new CloseWindowListener(this));
		
		this.setVisible(true);
	}
}
