
import java.io.Serializable;


/**
 *
 * La classe Plateau sert à répresenter un plateau de jeu
 * (le placement des pions). C'est à dire ensemble de cellules (pions) qui consituent le damier.
 * La classe est seulment utilisé par
 * la classe Puis4 pour representer le jeu et pour l'analyse
 * alfa-beta.
 *   
 * 
 * Remarque : <ul>
 * <li>La classe implemente l'interface Serializable pour permettre une eventuelle sauvegarde de l'état du jeu.</ul>
 * @author Miguel Tomasena. <br />
 * @see Puis4
 */

class Plateau implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[][] t;
	private int nbLig;
	private int nbCol;
	public Plateau(int nbLig,int nbCol){ // initalisation jeu
		setNbLig(nbLig);
		setNbCol(nbCol);
		t = new int [nbLig][nbCol];
		for (int l=0; l<nbLig; l++){
			for (int c=0; c<nbCol; c++){
				t[l][c] = Puis4.VIDE;
			}
		}
	}
	public boolean estPossibleJouer(int ligne){
		int c = this.getNbCol()-1; // on cherche le dernier pion placé sur la ligne l
		while (c >= 0  && t[ligne][c] == Puis4.VIDE){
			c--;
		}
		if (c+1< this.getNbCol()) 
			return true;
			else return false;
	}
	
	public void jouer(int l, int qui){
		int c = this.getNbCol()-1; // on cherche le dernier pion placé sur la ligne l
		while (c >= 0  && t[l][c] == Puis4.VIDE){
			c--;
		}
		c++;		
		if (c < this.getNbCol()) { // on peut jouer
			t[l][c] =  qui;
		}
	}
	
	public boolean estPlain(){  // on verifie si le plateau est plain
		boolean plain = true;
		int c = this.getNbCol()-1;
		for (int l=0; l<this.getNbLig(); l++){
			if (t[l][c] == Puis4.VIDE && plain){
				plain = false;
			}
		}
		return plain;
	}
	public boolean estGagne(int l, int c, int qui){
		int i;
		int j;
		int nb;
		if (c>=3 && t[l][c] == qui && t[l][c-1] == qui && // alignement vertical
			 t[l][c-2] == qui && t[l][c-3] == qui)
			 return true;
		// alignement horizontal
		i = l;
		while (i>=0 && t[i][c] == qui){
			i--;
			}
		i++;
		nb = 0; // nb alignements
		while (i<this.nbLig && t[i][c] == qui){
		   i++;
		   nb++;
		   }
		if (nb >= 4)
			return true;				
		// alignement diag1
		i = l;
		j = c;
		while (i>=0 && j >=0 && t[i][j] == qui){
		  i--;
		  j--;
		  }
	  i++;
	  j++;
	  nb = 0;
	  while (i<this.getNbLig() && j<this.getNbCol() && t[i][j] == qui){
		 j++;
		 i++;
		 nb++;
		 }
	  if (nb >= 4)
		  return true;	
		  
		// alignement diag2
		i = l;
		j = c;
		while (i>=0 && j<this.getNbCol() && t[i][j] == qui){
		  i--;
		  j++;
		  }
	  i++;
	  j--;
	  nb = 0;
	  while (i<this.getNbLig() && j>=0 && t[i][j] == qui){
		 j--;
		 i++;
		 nb++;
		 }
	  if (nb >= 4)
			return true;
		 else
			return false;  // aucun alignement trouvé	  	     
	}
	public boolean estTermine() {
		return this.estPlain() || this.estGagne(Puis4.JOUEUR) || this.estGagne(Puis4.PROG);
	}

	public int getNbCol() {
		return nbCol;
	}


	public int getNbLig() {
		return nbLig;
	}

	private void setNbCol(int i) {
		nbCol = i;
	}

	private void setNbLig(int i) {
		nbLig = i;
	}

	public boolean estGagne(int qui) {
		boolean gagne = false;
		int l = 0;
		while (!gagne && l<this.getNbLig()){
			int c = this.getNbCol()-1; // on cherche le dernier pion placé sur la ligne l
			while (c >= 0  && t[l][c] == Puis4.VIDE){
				c--;
			}
			if (c>=0) gagne = this.estGagne(l,c,qui);
			l++;
		}
		return gagne;
		
	}
	
	public String toString() {
		String s = "";
		for (int c=this.getNbCol()-1;c>=0;c--){
			s = s + "\n";
			for (int l=0; l<this.getNbLig();l++){
				if (t[l][c]>=0) s = s + " ";
			   	s = s + t[l][c] + " ";
			}
		}
		return s;
	}

	public void dejouer(int ligne) {
		int c = this.getNbCol()-1; // on cherche le dernier pion placé sur la ligne l
		while (c >= 0  && t[ligne][c] == Puis4.VIDE){
			c--;
		}		
		if (c >= 0) { 
			t[ligne][c] =  Puis4.VIDE;
		}
		
	}

	public int[][] getT() {
		return t;
	}

	public void setT(int[][] is) {
		t = is;
	}

}
