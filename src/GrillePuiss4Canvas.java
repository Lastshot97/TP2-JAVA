import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import puisQuatre.Puis4;

public class GrillePuiss4Canvas extends Canvas {
	private static final long serialVersionUID = 1L;

	private Puis4 modele; 
	private int DIM_CASE;
	private int coordXgrille;
	private int coordYgrille;
	private Puiss4Frame frame;

	public GrillePuiss4Canvas(Puis4 modele, Puiss4Frame frame) {
		this.modele = modele;
		this.frame = frame;
	}
	
	public int getCoordXgrille() {
		return coordXgrille;
	}
	
	public int getDimCase() {
		return DIM_CASE;
	}
	
	public void paint(Graphics g) {
	    this.setBackground(Color.BLACK);
		DIM_CASE = (((this.getWidth() / modele.getNbColonnes()) + (this.getHeight() / modele.getNbLignes())) / 3) ;
		coordXgrille = ((this.getWidth() - (modele.getNbColonnes() * DIM_CASE)) / 2);
		coordYgrille = ((this.getHeight() - (modele.getNbLignes() * DIM_CASE)) / 2);
	    		
		grille(true); 
	}
	
	public void joue(int colonne, boolean estJoueur) throws Exception{
		Graphics g = this.getGraphics();
		Color piont;
		if (estJoueur){
			piont = Color.RED;
		}else{
			piont = Color.YELLOW;
		}
		for (int y = coordYgrille; y < coordYgrille + getLigne(colonne) * DIM_CASE; y += DIM_CASE / 2){
			g.setColor(piont);
			g.fillOval((coordXgrille + (DIM_CASE * colonne)) + 5, y + 5, DIM_CASE - 5, DIM_CASE - 5);
			grille(false); 
			
			Thread.sleep(50);
			
			g.setColor(this.getBackground());
			g.fillOval((coordXgrille + (DIM_CASE * colonne)) +4, y +4, DIM_CASE - 2, DIM_CASE - 2);
		}
		grille(true);
		PlaySound.jeton();
		
		if (modele.estTermine()){
			new Puis4Dialog(frame,modele,this);
		} 
	}
	
	public int getLigne(int colonne){
		int ligne = (modele.getNbLignes() - 1);
		while(modele.getPion(colonne, ligne) == Puis4.VIDE && ligne > 0){
			ligne--;
		}
		return (modele.getNbLignes() - 1) - ligne;
	}
	
	public void grille(boolean bool){
		
		Graphics g = this.getGraphics();
		Graphics2D g2 = (Graphics2D)g;
		
		int coordXcase = coordXgrille;
	    int coordYcase = coordYgrille;
		
		Rectangle rect = new Rectangle(coordXgrille,  coordYgrille, DIM_CASE * modele.getNbColonnes() + 5, DIM_CASE * modele.getNbLignes() + 5);
		Area area = new Area(rect);
		
		for (int ligne = modele.getNbLignes() - 1; ligne >= 0; ligne --){
	    	for (int col = 0; col < modele.getNbColonnes(); col ++){
	    		
	    		Ellipse2D spot = new Ellipse2D.Float(
	                    (float) coordXcase + 5,
	                    (float) coordYcase + 5,
	                    (float) DIM_CASE - 5,
	                    (float) DIM_CASE - 5);
	    		
	    		area.subtract(new Area(spot)); 
	    		
	    		if (bool){
	    			switch (modele.getPion(col, ligne)) {
	    			case Puis4.JOUEUR : 
	    				g2.setColor(Color.RED);	    			
	    				g2.fillOval(coordXcase + 5, coordYcase + 5 , DIM_CASE - 5, DIM_CASE - 5);
	    				break;
	    			case Puis4.PROG :
	    				g2.setColor(Color.YELLOW);  
	    				g2.fillOval(coordXcase + 5, coordYcase + 5 , DIM_CASE - 5, DIM_CASE - 5);
	    				break;
	    			}	
	    		}    		    		
	    		coordXcase = coordXcase + DIM_CASE;	    		
	    	}
	    	coordXcase = coordXgrille;
	    	coordYcase = coordYcase + DIM_CASE;	        
		} 
		g2.setColor(Color.BLUE);
        g2.fill(area);
	}
}
