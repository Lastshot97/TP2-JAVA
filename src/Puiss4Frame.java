import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import puisQuatre.Puis4;


public class Puiss4Frame extends Frame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
		private static final int LARGEUR = 900;
		private static final int HAUTEUR = 600;
		private Puis4 modele;
		private GrillePuiss4Canvas grillePuiss4Canvas ;
		
		// Method
		public Puiss4Frame(Puis4 modele) {
			this.modele = modele;
			modele.addObserver(this);
			
			this.setTitle("Puissance 4");
			this.setSize(LARGEUR,HAUTEUR);
			this.setLayout(new BorderLayout());
			this.setBackground(Color.GRAY);
			
			grillePuiss4Canvas = new GrillePuiss4Canvas(modele);
		    Button abandonner = new Button ("Abandonner");
		      
		    this.add(grillePuiss4Canvas,BorderLayout.CENTER);
		    this.add(abandonner,BorderLayout.SOUTH);
		    
		    abandonner.addActionListener(new goMenuListener(this));
		    grillePuiss4Canvas.addMouseListener(new grillePuiss4Listener(modele,grillePuiss4Canvas));
		    this.addWindowListener(new CloseWindowListener(this));
		    
			this.setVisible(true);
		}
		
		public static int getLargeur(){
			return LARGEUR;
		}
		
		public static int getHauteur(){
			return HAUTEUR;
		}

		@Override
		public void update(Observable obs, Object obj) {
			grillePuiss4Canvas.repaint();
			if (modele.estTermine()){
				new Puis4Dialog(this,modele.estJoueurGagne(),modele);
			}		
		}
}
