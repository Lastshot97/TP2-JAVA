import java.awt.*;

import puisQuatre.Puis4;


public class Puiss4Frame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private static final int LARGEUR = 800;
	private static final int HAUTEUR = 500;
	private Puis4 modele;
	// Method
	public Puiss4Frame(Puis4 modele) {
		this.modele = modele;
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		
		Canvas grillePuiss4Canvas = new GrillePuiss4Canvas(modele);
	    Button abandonner = new Button ("Abandonner");
	    
	    this.add(grillePuiss4Canvas,BorderLayout.CENTER);
	    this.add(abandonner,BorderLayout.SOUTH);
	    
	    this.addWindowListener(new CloseWindowListener(this));
	    
		this.setVisible(true);
	}
}
