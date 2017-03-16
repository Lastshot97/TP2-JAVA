import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class ButtonNewGameListener implements ActionListener {

	private Puis4 modele;
	private Frame menu;
	
	public ButtonNewGameListener(Frame menu, Puis4 modele) {
		this.modele = modele;
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new NewGameDialog(menu, modele);
	}

}
