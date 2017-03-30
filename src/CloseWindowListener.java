import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Ecouteur permettant de fermer une Window ( frame et dialog confondue )
 * 
 * @author Julien | Hugo
 * @see Window
 */
public class CloseWindowListener extends WindowAdapter {
	
	private Window fenetre;
	
	public CloseWindowListener(Window fenetre) {
		this.fenetre = fenetre;
	}
	
	public void windowClosing (WindowEvent e){
		Logger.log(Logger.DEBUG, "fermeture de la fenêtre : " + fenetre);
		fenetre.dispose();
	}

}
