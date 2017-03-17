
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
 * Listener associé aux boutons "fermer" de toutes les fenêtres de l'application
 * Rôle : fermer la fenêtre courante
 */
public class CloseWindowListener extends WindowAdapter {
	
	private Window fenetre;
	
	public CloseWindowListener(Window fenetre) {
		this.fenetre = fenetre;
	}
	
	public void windowClosing (WindowEvent e){
		fenetre.dispose();
	}

}
