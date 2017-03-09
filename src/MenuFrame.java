import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

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
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);
		
		Button jouer = new Button ("Jouer !");
	    this.add(jouer,BorderLayout.CENTER);
	    jouer.addActionListener(new JouerListener(this));
	    
	    this.addWindowListener(new CloseWindowListener(this));
	    
		this.setVisible(true);
	}

}
