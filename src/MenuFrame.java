
import java.awt.*;

import puisQuatre.Puis4;


public class MenuFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1328756640538025065L;
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	
	public MenuFrame(Puis4 modele) {
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.GRAY);
		
		Label nivLabel = new Label("niveau :");
		Scrollbar nSB = new Scrollbar(Scrollbar.HORIZONTAL, 1, 1, 1, 5);

		Label affNivLabel = new Label("niveau choisi : 1 ");
		Panel nivPanel = new Panel(new GridLayout(1, 3));
		nivPanel.add(nivLabel);
		nivPanel.add(nSB);
		nivPanel.add(affNivLabel);
		
		nSB.addAdjustmentListener(new AdjustBarListener(modele,affNivLabel));
		
		Label dimLabel = new Label("choisisez les dimensions de la grille");
		Choice dimChoice = new Choice();
		dimChoice.add("6 x 7");
		dimChoice.add("7 x 8");
		dimChoice.add("8 x 9");
		Panel dimPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
		dimPanel.add(dimLabel);
		dimPanel.add(dimChoice);
		
		Button jouer = new Button ("Jouer !");
		
		this.add(nivPanel);
		this.add(dimPanel);
		this.add(jouer);
	    jouer.addActionListener(new JouerListener(this, dimChoice.getSelectedItem(),modele));
	    
	    this.addWindowListener(new CloseWindowListener(this));
	    
		this.setVisible(true);
	}
}
