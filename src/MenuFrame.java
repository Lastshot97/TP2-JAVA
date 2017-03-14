
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;


import puisQuatre.Puis4;


public class MenuFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1328756640538025065L;
	private static final int LARGEUR = 900;
	private static final int HAUTEUR = 600;
	
	public MenuFrame(Puis4 modele) {
		this.setTitle("Menu Puissance 4");
		this.setSize(LARGEUR,HAUTEUR);
		this.setResizable(false);
		this.setLayout(null);
		
		// change l'icone de la fenetre
		try{
			Image icon = ImageIO.read(this.getClass().getResourceAsStream("icon.png"));
			this.setIconImage(icon);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		// change le fond de la fenetre
		try{
			Image fond = ImageIO.read(this.getClass().getResourceAsStream("fond.png"));
			ImageCanvas ic = new ImageCanvas(fond);
			ic.setSize(400, 400);
			//ic.setVisible(false);
			this.add(ic);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		Button jouer = new Button ("Nouvelle partie");		
		jouer.setLocation(350, 277);
		jouer.setSize(150, 50);
		this.add(jouer);
	    jouer.addActionListener(new JouerListener(this, "7x8", modele));
		
		Button regle = new Button ("Regle");		
		regle.setLocation(350, 370);
		regle.setSize(150, 50);
		this.add(regle);
	    
		Button parametre = new Button ("Parametre");		
		parametre.setLocation(350, 462);
		parametre.setSize(150, 50);
		this.add(parametre);
		
	    this.addWindowListener(new CloseWindowListener(this));
	    
		
		PlayMusic.play("menu.wav");
		this.setVisible(true);
	}
}
