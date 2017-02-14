import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import puisQuatre.Puis4;

public class GrillePuiss4Canvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 800;
	private static final int DIM_CARRE = 100;
	private Puis4 modele;
	
	public GrillePuiss4Canvas(Puis4 modele) {
		this.modele = modele;
	}
	
	public void paint(Graphics g) {
	    this.setSize(LARGEUR, HAUTEUR);
	    this.setBackground(Color.GREEN);

	    int coordXcarre = ((LARGEUR - (modele.getNbColonnes() * DIM_CARRE)) / 2);
	    int coordYcarre = ((HAUTEUR - (modele.getNbLignes() * DIM_CARRE)) / 2);
	    
	    g.setColor(Color.BLUE);
	    g.fillRect(coordXcarre, coordYcarre, DIM_CARRE * modele.getNbColonnes(), DIM_CARRE * modele.getNbLignes());
	    
	    for (int ligne = 0; ligne < modele.getNbLignes(); ligne ++){
	    	for (int col = 0; col < modele.getNbColonnes(); col++){
	    		g.setColor(Color.WHITE);
	    		g.fillOval(coordXcarre + 10, coordYcarre + 10, DIM_CARRE - 20, DIM_CARRE - 20);
	    		coordXcarre = coordXcarre + DIM_CARRE; 		
	    	}
	    	coordXcarre = ((LARGEUR - (modele.getNbColonnes() * DIM_CARRE)) / 2);
	    	coordYcarre = coordYcarre + DIM_CARRE;
	    }
	}
}
