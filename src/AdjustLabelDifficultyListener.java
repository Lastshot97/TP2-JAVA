import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/*
 * Cette classe à pour but de modifier l'image du label "getDifficulte" en fonction de la valeur du scrollbar "setDifficulte"
 * La difficulté est fixé à 5 maximum
 */
public class AdjustLabelDifficultyListener implements AdjustmentListener {

	private JLabel difficulte;
	
	public AdjustLabelDifficultyListener(JLabel getDifficulte) {
		this.difficulte = getDifficulte;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent a) {
		try{
		switch (a.getValue()) {
		case 1 :
			difficulte.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("etoile.png"))));
			break;
		case 2 :		
			difficulte.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("2etoile.png"))));
			break;
		case 3 :
			difficulte.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("3etoile.png"))));
			break;
		case 4 :
			difficulte.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("4etoile.png"))));
			break;
		case 5 :
			difficulte.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("5etoile.png"))));
			break;
		}
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
