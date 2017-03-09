
import java.awt.event.*;
import puisQuatre.Puis4;

public class grillePuiss4Listener extends MouseAdapter {

	private Puis4 modele;
	private GrillePuiss4Canvas grille;
	
	private static int nbrJoueur = 0;
	
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
		WaitThread waitThread = new WaitThread(modele);
		
		for (int i = 0; i < tabCoord.length; i++){
			if (coordXsouris >= tabCoord[i] && coordXsouris <= tabCoord[i] + DimCase){
				System.out.println(nbrJoueur);
				System.out.println(waitThread.getNbrProg());
				if (nbrJoueur == waitThread.getNbrProg()){
					modele.joueurJoue(i);
					nbrJoueur ++;
					PlaySound.jeton();
					waitThread.start();
				}			
			}
		}				
	}
}
