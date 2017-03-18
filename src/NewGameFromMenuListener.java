import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollBar;

import puisQuatre.Puis4;

/**
 * Ecouteur permettant de lancer une nouvelle partie depuis la fenêtre de dialogue des paramètres
 * 
 * @author Julien | Hugo
 *
 */
public class NewGameFromMenuListener implements ActionListener {

	private JScrollBar difficulte;
	private JComboBox<String> tailleGrille;
	private Frame menu;
	private JDialog dialog;
	
	public NewGameFromMenuListener(JScrollBar difficulte, JComboBox<String> tailleGrille, Frame menu,
			JDialog dialog) {
		this.difficulte = difficulte;
		this.tailleGrille = tailleGrille;
		this.menu = menu;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new Puiss4Frame (new Puis4(
				Integer.parseInt(
						String.valueOf(
								((String) tailleGrille.getSelectedItem()).charAt(0))),
				Integer.parseInt(
						String.valueOf(
								((String) tailleGrille.getSelectedItem()).charAt(4))),
				difficulte.getValue()
				));
		menu.dispose();
	    dialog.dispose();
	}

}
