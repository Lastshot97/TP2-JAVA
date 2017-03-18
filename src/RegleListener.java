import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Ecouteur permetant de lancer la boite de dialogue affichant les règles
 * 
 * @author Julien | Hugo
 *
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
