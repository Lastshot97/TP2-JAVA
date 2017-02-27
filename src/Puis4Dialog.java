import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import puisQuatre.Puis4;
import java.awt.Dialog;

public class Puis4Dialog extends Dialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Puis4Dialog(Puiss4Frame frame, boolean aGagner, Puis4 modele){
		super(frame, "PARTIE TERMINEE", false);
		this.setSize(Puiss4Frame.getLargeur() / 4, Puiss4Frame.getHauteur() / 4);
		this.setLocationRelativeTo(frame);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		String msg;
		if (aGagner){
			msg = "You Win !";
		}else{
			msg = "Try Again ...";
		}
		
		Label l1 = new Label(msg);
		this.add(l1, BorderLayout.CENTER);
		
		Panel mesButtons = new Panel();
		Button fermer = new Button("Fermer");
		Button rejouer = new Button("Rejouer");
		mesButtons.add(fermer);
		mesButtons.add(rejouer);
		this.add(mesButtons, BorderLayout.SOUTH);	
		
		fermer.addActionListener(new GameCloser(frame,this));
		rejouer.addActionListener(new replayGame(this,modele));
		
		this.setModal(true);
		this.setVisible(true);
	}
}
