import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Fenetre de dialogue permettant de choisir le fichier de sauvegarde à charger
 * 
 * @author Julien | Hugo
 *
 */
public class ChargerDialog extends Dialog {

	private static final long serialVersionUID = 1L;
	
	/**
	 * procedure qui ajoute comme choix les fichiers locaux .pw4
	 * (fichiers de sauvegarde)
	 * 
	 * @param c : le composant où l'on va ajouter des choix de nom de fichier
	 */
	public void ajouterFichierSauvegarde(Choice c){
		Path pLocal = Paths.get("");
		Path pAbsolue = pLocal.toAbsolutePath();
		File dossier = new File(pAbsolue.toString());
	    File[] listeDesFichiers = dossier.listFiles();
	    for ( File f : listeDesFichiers ) {
		    if (f.isFile() && (f.getName().endsWith(".pw4"))) {
		    	String nomSansExtension = (f.getName()).substring(0, (f.getName().length() - 4));
		    	c.add(nomSansExtension);
		    }
	    }
	}

	
	public ChargerDialog(MenuFrame fenetreMenu) throws IOException {
		super(fenetreMenu, "Chargement d'une ancienne partie", true);

		this.setSize(400,300);
		this.setLocationRelativeTo(fenetreMenu);
		this.setResizable(true);
		this.setLayout(new BorderLayout());

		Label text = new Label("Choissiser le nom de la sauvegarde à charger");
		text.setForeground(Color.WHITE);

		Choice nomSauv = new Choice();
		ajouterFichierSauvegarde(nomSauv);
		
		Button charger = new Button("Charger");
		charger.setForeground(Color.CYAN);
		charger.setBackground(new Color(11, 13, 64));
		charger.addActionListener(new ChargerListener(fenetreMenu, nomSauv));

		this.add(text, BorderLayout.NORTH);
		this.add(nomSauv, BorderLayout.CENTER);
		this.add(charger, BorderLayout.SOUTH);

		this.addWindowListener(new CloseWindowListener(this));
		
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(true);
	}
}
