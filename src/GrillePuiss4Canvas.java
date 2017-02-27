import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import puisQuatre.Puis4;

public class GrillePuiss4Canvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Puis4 modele; 
	private int DIM_CASE;
	private int coordXgrille;
	private int coordYgrille;
	
	public GrillePuiss4Canvas(Puis4 modele) {
		this.modele = modele;		
	}
	
	public int getCoordXgrille() {
		return coordXgrille;
	}
	
	public int getCoordYgrille() {
		return coordYgrille;
	}
	
	public int getDimCase() {
		return DIM_CASE;
	}
	
	public void paint(Graphics g) {

	    this.setBackground(Color.GREEN);
	    
	    DIM_CASE = (((this.getWidth() / modele.getNbColonnes()) + (this.getHeight() / modele.getNbLignes())) / 4) ;
		coordXgrille = ((this.getWidth() - (modele.getNbColonnes() * DIM_CASE)) / 2);
		coordYgrille = ((this.getHeight() - (modele.getNbLignes() * DIM_CASE)) / 2);
		
	    g.setColor(Color.BLUE);
	    g.fillRect(coordXgrille, coordYgrille, DIM_CASE * modele.getNbColonnes() + 5, DIM_CASE * modele.getNbLignes() + 5);
	    
	    int coordXcase = coordXgrille;
	    int coordYcase = coordYgrille;
	    for (int ligne = modele.getNbLignes() - 1; ligne >= 0; ligne --){
	    	for (int col = 0; col < modele.getNbColonnes(); col ++){
	    		switch (modele.getPion(col, ligne)) {
	    		case Puis4.JOUEUR : 
	    			g.setColor(Color.RED);
	    			break;
	    		case Puis4.PROG :
	    			g.setColor(Color.YELLOW);
	    			break;
	    		case Puis4.VIDE :
	    			g.setColor(Color.WHITE);
	    			break;
	    		}	    			    		
	    		g.fillOval(coordXcase + 5, coordYcase + 5 , DIM_CASE - 5, DIM_CASE - 5);
	    		coordXcase = coordXcase + DIM_CASE; 		
	    	}
	    	coordXcase = coordXgrille;
	    	coordYcase = coordYcase + DIM_CASE;
	    }
	}
}
