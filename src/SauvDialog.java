import java.awt.*;
import java.io.IOException;

import puisQuatre.Puis4;

/**
 * Fenetre de dialogue permettant de choisir le nom du fichier de sauvegarde
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
		this.setLayout(new BorderLayout());
		
		Label nomSauv = new Label("Choissiser le nom de votre sauvegarde");
		nomSauv.setForeground(Color.WHITE);
		
		TextField selectNomSauv = new TextField();
		selectNomSauv.setBackground(Color.DARK_GRAY);
		selectNomSauv.setForeground(Color.LIGHT_GRAY);
		
		Button sauvegarder = new Button("Sauvegarder");
		sauvegarder.addActionListener(new SauvListener(this, modele, selectNomSauv));
		sauvegarder.setBackground(Color.LIGHT_GRAY);
		sauvegarder.setForeground(Color.DARK_GRAY);
				
		Panel centre = new Panel(new GridLayout(3, 1));
		centre.add(new Panel());
		centre.add(selectNomSauv);
		centre.add(new Panel());
		this.add(nomSauv, BorderLayout.NORTH);
		this.add(centre, BorderLayout.CENTER);
		this.add(sauvegarder, BorderLayout.SOUTH);
		
		this.addWindowListener(new CloseWindowListener(this));
		
		this.setBackground(Color.GRAY);
		this.setVisible(true);
	}
}
