
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
		
		Font f = new Font(Font.SERIF, Font.PLAIN, 16);
		
		Button jouer = new Button ("Nouvelle partie");		
		jouer.setLocation(370, 277);
		jouer.setSize(150, 50);
		jouer.setBackground(new Color(32, 40, 191));
		jouer.setFont(f);
		this.add(jouer);
	    jouer.addActionListener(new JouerListener(this, "7x8", modele));
		
		Button regle = new Button ("Regle");		
		regle.setLocation(370, 370);
		regle.setSize(150, 50);
		regle.setBackground(new Color(21, 27, 127));
		regle.setFont(f);
		this.add(regle);
	    
		Button parametre = new Button ("Parametre");		
		parametre.setLocation(370, 462);
		parametre.setSize(150, 50);
		parametre.setBackground(new Color(11, 13, 64));
		parametre.setFont(f);
		this.add(parametre);
		
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
			ic.setSize(LARGEUR, HAUTEUR);
			//ic.setVisible(false);
			this.add(ic);
		} catch(IOException e){
			e.printStackTrace();
		}		
		
	    this.addWindowListener(new CloseWindowListener(this));
	    		
		PlayMusic.play("menu.wav");
		this.setVisible(true);
	}
}
