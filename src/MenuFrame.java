import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.util.Observable;
import java.util.Observer;

public class MenuFrame extends Frame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1328756640538025065L;
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	private MenuModel m;
	private Label affNivLabel;
	
	public MenuFrame() {
		MenuModel m = new MenuModel();
		this.setTitle("Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setLayout(new GridLayout(3, 1));
		this.setBackground(Color.GRAY);
		
		Label nivLabel = new Label("niveau :");
		Scrollbar nSB = new Scrollbar(Scrollbar.HORIZONTAL, 1, 5, 1, 20);
		Label affNivLabel = new Label("niveau choisi : ");  // TODO mettre à jour
		Panel nivPanel = new Panel(new GridLayout(1, 3));
		nivPanel.add(nivLabel);
		nivPanel.add(nSB);
		nivPanel.add(affNivLabel);
		
		MenuListener e = new MenuListener(nSB, m);
		nSB.addAdjustmentListener(e);
		
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
	    jouer.addActionListener(new JouerListener(this, dimChoice.getSelectedItem(), m.getNiveau()));
	    
	    this.addWindowListener(new CloseWindowListener(this));
	    
	    
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("jupdate");  // FIXME
		affNivLabel.setText("niveau choisi TEST : " + m.getNiveau());	// FIXME
		
	}

}
