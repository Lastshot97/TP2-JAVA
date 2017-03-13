import java.awt.*;

public class MenuFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1328756640538025065L;
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	
	public MenuFrame() {
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.GRAY);
		
		Label nivLabel = new Label("niveau :");
		Scrollbar nivScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 1, 2, 1, 9);
		Label affNivLabel = new Label("niveau choisi : " + nivScrollbar.getValue());  //TODO mettre à jour
		Panel nivPanel = new Panel(new GridLayout(1, 3));
		nivPanel.add(nivLabel);
		nivPanel.add(nivScrollbar);
		nivPanel.add(affNivLabel);
		
		Label dimLabel = new Label("choisisez les dimensions de la grille");
		Choice dimChoice = new Choice();
		dimChoice.add("7 x 8");
		dimChoice.add("8 x 9");
		dimChoice.add("9 x 10");
		Panel dimPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
		dimPanel.add(dimLabel);
		dimPanel.add(dimChoice);
		
		Button jouer = new Button ("Jouer !");
		
		this.add(nivPanel);
		this.add(dimPanel);
		this.add(jouer);
	    jouer.addActionListener(new JouerListener(this, dimChoice.getSelectedItem(), nivScrollbar.getValue()));
	    
	    this.addWindowListener(new CloseWindowListener(this));
	    
	    
		this.setVisible(true);
	}

}
