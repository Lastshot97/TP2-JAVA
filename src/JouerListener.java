import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class JouerListener implements ActionListener {
	private MenuFrame mf;
	private int nbrColone;
	private int nbrLigne;
	//private int niv;
	private Puis4 modele;
	public JouerListener(MenuFrame mf, String dimGrille, Puis4 modele) {
		this.mf = mf;
		this.nbrColone = Integer.valueOf(String.valueOf(dimGrille.charAt(0)));
		this.nbrLigne = Integer.valueOf(String.valueOf(dimGrille.charAt(dimGrille.length() - 1)));  // on recupère le chiffre à la fin du string
		//this.niv = niv;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Puiss4Frame(new Puis4(nbrLigne, nbrColone, modele.getNiveauJeu()));
		mf.dispose();
	}

}
