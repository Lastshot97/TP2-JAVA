import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Cette classe associe un Listener au bouton "Regle" du menu principale
 * Rôle : ouvrir la boite de dialogue contenant les règles du jeu 
 */
public class RegleListener implements ActionListener {

	private MenuFrame menuFrame;

	public RegleListener(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new RegleDialog(menuFrame);
	}

}
