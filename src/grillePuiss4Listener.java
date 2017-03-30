
import java.awt.event.*;

import puisQuatre.Puis4;
/**
 * Cette classe à pour but de déterminer dans quelle colonne on joue en fonction des coordonnées du clique de la souris
 * 
 * Elle contient les méthodes :
 * - getCoordCol() : crée un tableau contenant les coordonnées X pour chaque colonne
 * - mousePressed(MouseEvent e) : parcourt le tableau obtenu grâce à getCoordCol() et vérifie si on est dans
 *   l'intervalle [tab[i], tab[i + DIM_CASE]. Si c'est le cas elle appelle à JoueurJoue(i) du modèle et à joue(i) du Canvas
 * 
 * @author Julien | Hugo
 * @see GrillePuiss4Canvas
 *
 */
public class grillePuiss4Listener extends MouseAdapter {

	private Puis4 modele;
	private GrillePuiss4Canvas grille;
	
	public grillePuiss4Listener(Puis4 modele, GrillePuiss4Canvas grillePuiss4Canvas) {
		this.modele = modele;
		this.grille = grillePuiss4Canvas;
	}
	
	public int[] getCoordCol() {
		int tabCoord[] = new int[modele.getNbColonnes()];
		int coordcase = grille.getCoordXgrille();
		for (int i = 0; i < tabCoord.length; i++){
			tabCoord[i] = coordcase + (i * grille.getDimCase());
		}
		return tabCoord;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int coordXsouris = e.getX();
		int DimCase = grille.getDimCase();
		int[] tabCoord = getCoordCol();
		boolean estFini;
		for (int i = 0; i < tabCoord.length; i++){
			if (coordXsouris >= tabCoord[i] && coordXsouris <= tabCoord[i] + DimCase){
				if(modele.estPossibleJouer(i)){
					Logger.log(Logger.DEBUG, "clique à la colone : " + i + " coordonnée : " + coordXsouris);
					modele.joueurJoue(i);
					estFini = modele.estJoueurGagne();
					try {					
						grille.joue(i,true);
						if (!estFini){ // Comme le joueur joue avant, on test si il a gagné avant de faire jouer le programme
							grille.joue(modele.progJoue(), false);
						}
					} catch (Exception e1) {
						Logger.log(Logger.IMPORTANT, "echec un joueur n'as pas pu jouer" + e);;
					}		
				}
			}
		}
	}
}
