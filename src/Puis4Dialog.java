import java.awt.BorderLayout;
import java.awt.Button;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import puisQuatre.Puis4;

//import puisQuatre.Puis4;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Panel;
import java.io.IOException;
/**
 * Boite de dialogue  s'ouvrant lorsque la partie est terminée
 * 
 * Une image de victoire est affichée en cas de victoire et inversement
 * affiche le résultat de la partie et propose de :
 * - fermer le jeu
 * - rejouer avec les mêmes paramètres
 * - retourner au menu
 * 
 * @author Julien | Hugo
 * @see Puiss4Frame
 *
 */
public class Puis4Dialog extends Dialog{
	
	private static final long serialVersionUID = 1L;

	public Puis4Dialog(Puiss4Frame frame, Puis4 modele, GrillePuiss4Canvas grille){		
		super(frame, "PARTIE TERMINEE", false);

		JLabel endGame;  // JLABEL ?
		Image tryAgain = null;
		Image winner = null;
		try{
			tryAgain = ImageIO.read(this.getClass().getResourceAsStream("TryAgain.jpg"));
			winner = ImageIO.read(this.getClass().getResourceAsStream("YouWin.jpg"));
		} catch (IOException e){
			Logger.log(Logger.IMPORTANT, "Erreur lors de la lecture des images de la classe PuisDialog" + e);
		}
		if (modele.estJoueurGagne()){
			Logger.log(Logger.IMPORTANT,"Le joueur gagane");
			PlayMusic.play("win.wav", false);  // TODO implementer
			endGame = new JLabel(new ImageIcon(winner));	// FIXME mettre une valeur local	
			this.setSize(280,270);
		} else{
			Logger.log(Logger.IMPORTANT,"Le joueur perd");
			PlayMusic.play("lose.wav", false);  //TODO implementer
			endGame = new JLabel(new ImageIcon(tryAgain));
			this.setSize(420,270);
		}
		
		this.setLocationRelativeTo(frame);
		this.setModalityType(DEFAULT_MODALITY_TYPE);
		this.setLayout(new BorderLayout());
		
		this.add(endGame, BorderLayout.CENTER);
		
		Panel mesButtons = new Panel();
		Button fermer = new Button("Fermer");
		Button menu = new Button("menu");
		Button rejouer = new Button("Rejouer");
		mesButtons.add(fermer);
		mesButtons.add(menu);
		mesButtons.add(rejouer);
		this.add(mesButtons, BorderLayout.SOUTH);	
		
		fermer.addActionListener(new GameCloser(frame,this));
		menu.addActionListener(new goMenuListener(frame, modele));
		rejouer.addActionListener(new replayGame(this,modele,grille));
		
		this.setVisible(true);
	}
}
