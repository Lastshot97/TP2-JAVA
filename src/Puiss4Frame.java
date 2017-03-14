import java.awt.*;

import puisQuatre.Puis4;


public class Puiss4Frame extends Frame  {
	
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	private Button abandonner;
	private Button goMenu;
	private GrillePuiss4Canvas grille;
	
	// Method
	public Puiss4Frame(Puis4 modele) {	
		
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new BorderLayout());
		PlayMusic.play("jeu.wav");

		grille = new GrillePuiss4Canvas(modele,this);	
		
	    abandonner = new Button ("Abandonner");
	    abandonner.setBackground(new Color(133,133,133));
	    
	    goMenu = new Button ("Retour au Menu");	
	    goMenu.setBackground(new Color(133,133,133));
	    
	    Panel bottom = new Panel();
	    bottom.setLayout(new GridLayout(1,5));
	    bottom.setPreferredSize(new Dimension(LARGEUR,30));
	    bottom.add(new Panel()); bottom.add(abandonner); bottom.add(new Panel()); bottom.add(goMenu); bottom.add(new Panel());

	    bottom.setBackground(Color.DARK_GRAY);
	      
	    this.add(grille, BorderLayout.CENTER);
	    this.add(bottom, BorderLayout.SOUTH);
	    
	    abandonner.addActionListener(new ButtonAbandonListener(modele, grille));
	    goMenu.addActionListener(new goMenuListener(this, modele));
	    grille.addMouseListener(new grillePuiss4Listener(modele, grille)); 
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
