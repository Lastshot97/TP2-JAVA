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
		
		Label nomSauv = new Label("Choissiser le nom de votre sauvegarde");
		nomSauv.setForeground(Color.WHITE);
		
		TextField selectNomSauv = new TextField();
		selectNomSauv.setBackground(Color.BLACK);
		selectNomSauv.setForeground(Color.LIGHT_GRAY);
		
		Button sauvegarder = new Button("Sauvegarder");
		sauvegarder.addActionListener(new SauvListener(this, modele, selectNomSauv));
		sauvegarder.setBackground(Color.LIGHT_GRAY);
		sauvegarder.setForeground(Color.BLACK);
				
		this.add(nomSauv);
		this.add(selectNomSauv);
		this.add(sauvegarder);
		
		this.addWindowListener(new CloseWindowListener(this));
		
		this.setBackground(Color.GRAY);
		this.setVisible(true);
	}
}
