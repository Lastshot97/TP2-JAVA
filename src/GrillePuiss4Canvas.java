import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import puisQuatre.Puis4;

/**
 * Cette classe permet la représentation graphique de la grille 
 * 
 * Elle est constituée des méthodes :
 * - paint() : calcul les coordonnées (X, Y) de la grille et dessine la grille
 * - grille(int colonneJouer, int ligneJouer) : dessine la grille et les pions s'y trouvant sauf celui aux coordonnées (colonneJouer, ligneJouer)
 * - joue(int colonne) : dessine un pion à différent intervalle sur l'axe des Y afin de simuler la chute d'un jeton

 * @author Julien | Hugo
 *
 */
public class GrillePuiss4Canvas extends Canvas {
	private static final long serialVersionUID = 1L;

	private Puis4 modele; 
	private int DIM_CASE;
	private int coordXgrille;
	private int coordYgrille;
	private Puiss4Frame frame;
	private Image image;

	public GrillePuiss4Canvas(Puis4 modele, Puiss4Frame frame, Image image) {
		this.modele = modele;
		this.frame = frame;
		this.image = image;
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

		g.drawImage(image, 0, 0, null);		
		grille(-1,-1); 
	}
	
	public void joue(int colonne, boolean estJoueur) throws Exception{
		Graphics g = this.getGraphics();
		int ligne = (modele.getNbLignes() - 1) - getLigne(colonne); // nombre de ligne vide en partant du haut de la colonne
		Color pion;
		
		if (estJoueur){
			pion = Color.RED;
		}else{
			pion = Color.YELLOW;
		}

		for (int y = coordYgrille; y < coordYgrille + ligne * DIM_CASE; y += (3*DIM_CASE) / 4){
			//On parcourt l'axe des Y avec un pas de (3*DIM_CASE) / 4 jusqu'à arriver au coordonnée de la dernière case vide
			g.setColor(pion);
			g.fillOval((coordXgrille + (DIM_CASE * colonne)) + 5, y + 5, DIM_CASE - 5, DIM_CASE - 5);
			// On dessine un ovale
			grille(colonne,getLigne(colonne)); 
			// On dessine la grille et les pions qui la compose excepté le pion que l'on joue
			Thread.sleep(60);
			g.drawImage(image, 0, 0, null);
			// On dessine l'image de fond afin d'effacer l'ovale avant de le redessiner 			
		}
		grille(-1,-1); 
		// On dessine la grille et les pions qui la compose (en incluant cette fois-ci le pion "courant"
		PlaySound.jeton();
	
		if (modele.estTermine()){
			// On test si la partie est terminé après avoir joué, si c'est le cas on appelle la fenêtre de victoire (ou défaite)
			new Puis4Dialog(frame,modele,this);
		} 
	}
	
	public int getLigne(int colonne){
		// But : Calcul le nombre de ligne vide à parcourir
		int ligne = (modele.getNbLignes() - 1);
		while(modele.getPion(colonne, ligne) == Puis4.VIDE && ligne > 0){
			ligne--;
		}
		return ligne;
	}
	
	public void grille(int colonneJouer, int ligneJouer){
		
		Graphics g = this.getGraphics();
		Graphics2D g2 = (Graphics2D)g;
		
		int coordXcase = coordXgrille;
	    int coordYcase = coordYgrille;
		
		Rectangle rect = new Rectangle(coordXgrille,  coordYgrille, DIM_CASE * modele.getNbColonnes() + 5, DIM_CASE * modele.getNbLignes() + 5);
		Area area = new Area(rect);
		// On définit une nouvelle zone, un rectangle, représentant notre grille
		
		for (int ligne = modele.getNbLignes() - 1; ligne >= 0; ligne --){ // On parcourt chaque ligne de la grille
	    	for (int col = 0; col < modele.getNbColonnes(); col ++){ // et chaque colonne
	    		
	    		Ellipse2D spot = new Ellipse2D.Float(
	                    (float) coordXcase + 5,
	                    (float) coordYcase + 5,
	                    (float) DIM_CASE - 5,
	                    (float) DIM_CASE - 5);
	    		
	    		area.subtract(new Area(spot)); 
	    		// On soustrait une zone de forme elliptique à notre zone principale, représentant ainsi une case dela grille
	    		
	    		if (!(col == colonneJouer && ligne == ligneJouer)){ // On dessine toutes les pièces jouées sauf celle à la case indiquée			
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
	    		// On obtient les coordonnées de la case voisine suivante en ajoutant au coordonnée actuelle la largeur de la case		
	    	}
	    	coordXcase = coordXgrille;
	    	// On réactulaise la coordonnée X de la case à celle de la première case de chaque ligne
	    	coordYcase = coordYcase + DIM_CASE;	
	    	// On obtient les coordonnées de la case du dessous en ajoutant au coordonnée actuelle la hauteur de la case
		} 
		g2.setColor(Color.BLUE);
        g2.fill(area);
	}
}
