import java.awt.*;

import javax.swing.JButton;

import puisQuatre.Puis4;


public class Puiss4Frame extends Frame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	private GrillePuiss4Canvas grille;
	
	// Method
	public Puiss4Frame(Puis4 modele) {	
		
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new BorderLayout());

		grille = new GrillePuiss4Canvas(modele,this);	
	    Button abandonner = new Button ("Abandonner");
	      
	    this.add(grille,BorderLayout.CENTER);
	    this.add(abandonner,BorderLayout.SOUTH);
	    
	    abandonner.addActionListener(new ButtonAbandonListener(modele,grille));
	    grille.addMouseListener(new grillePuiss4Listener(modele,grille)); 
	    this.addWindowListener(new CloseWindowListener(this));
	    
		this.setVisible(true);
	}
	
	public int getLargeur(){
		return LARGEUR;
	}
	
	public int getHauteur(){
		return HAUTEUR;
	}
}
