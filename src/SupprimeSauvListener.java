import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SupprimeSauvListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Logger.log(Logger.DEBUG, "clique sur 'supprimer les sauvegardes'");;
		Path pLocal = Paths.get("");
		Path pAbsolue = pLocal.toAbsolutePath();
		File dossier = new File(pAbsolue.toString());
	    File[] listeDesFichiers = dossier.listFiles();
	    for ( File f : listeDesFichiers ) {
		    if (f.isFile() && (f.getName().endsWith(".pw4"))) {
		    	Logger.log(Logger.IMPORTANT, "suppression de la sauvegarde : " + f.getName());;
		    	f.delete();
		    }
	    }
	}
}
