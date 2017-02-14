import java.awt.*;

public class Puiss4Frame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributes
	private static final int LARGEUR = 800;
	private static final int HAUTEUR = 500;
	
	// Method
	public Puiss4Frame() {
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		
		this.setVisible(true);
	}
}
