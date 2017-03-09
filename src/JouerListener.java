import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class JouerListener implements ActionListener {
	private MenuFrame mf;
	private int nbrColone;
	private int nbrLigne;
	private int niv;
	
	public JouerListener(MenuFrame mf, String dimGrille, int niv) {
		this.mf = mf;
		this.nbrColone = Integer.valueOf(String.valueOf(dimGrille.charAt(0)));
		this.nbrLigne = Integer.valueOf(String.valueOf(dimGrille.charAt(dimGrille.length() - 1)));  // on recupère le chiffre à la fin du string
		this.niv = niv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Puiss4Frame(new Puis4(nbrLigne, nbrColone, niv));
		mf.dispose();
	}

}
