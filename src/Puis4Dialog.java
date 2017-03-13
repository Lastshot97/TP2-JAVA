import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import puisQuatre.Puis4;
import java.awt.Dialog;
import java.awt.Panel;

public class Puis4Dialog extends Dialog{
	
	private static final long serialVersionUID = 1L;

	public Puis4Dialog(Puiss4Frame frame, Puis4 modele, GrillePuiss4Canvas grille){		
		super(frame, "PARTIE TERMINEE", false);

		JLabel endGame;
		
		if (modele.estJoueurGagne()){		
			endGame = new JLabel(new ImageIcon("D:/Pictures/Projets/YouWin.jpg"));		
			this.setSize(280,270);
		} else{
			endGame = new JLabel(new ImageIcon("D:/Pictures/Projets/TryAgain.jpg"));
			this.setSize(420,270);
		}
		
		this.setLocationRelativeTo(frame);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setLayout(new BorderLayout());
		
		this.add(endGame, BorderLayout.CENTER);
		
		Panel mesButtons = new Panel();
		Button fermer = new Button("Fermer");
		Button rejouer = new Button("Rejouer");
		mesButtons.add(fermer);
		mesButtons.add(rejouer);
		this.add(mesButtons, BorderLayout.SOUTH);	
		
		fermer.addActionListener(new GameCloser(frame,this));
		rejouer.addActionListener(new replayGame(this,modele,grille));
		
		this.setVisible(true);
	}
}
