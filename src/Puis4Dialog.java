import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;

import javax.swing.JDialog;

import puisQuatre.Puis4;

public class Puis4Dialog extends JDialog{
	
	public Puis4Dialog(Frame maFrame, boolean aGagner){
		super(maFrame, "resultat de la partie", false);
		this.setSize(500, 500);
		this.setLocationRelativeTo(maFrame);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		String msg;
		if (aGagner){
			msg = "felicitation";
		}else{
			msg = "essaye encore";
		}
		Label l1 = new Label(msg);
		this.add(l1, BorderLayout.CENTER);
		
		Panel mesButtons = new Panel();
		Button fermer = new Button("fermer");
		Button rejouer = new Button("rejouer");
		mesButtons.add(fermer);
		mesButtons.add(rejouer);
		this.add(mesButtons, BorderLayout.SOUTH);		
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Puis4 m = new Puis4();
		Puiss4Frame f1 = new Puiss4Frame(m);
		Puis4Dialog d1 = new Puis4Dialog(f1, true);
		Puis4Dialog d2 = new Puis4Dialog(f1, false);
	}
}
