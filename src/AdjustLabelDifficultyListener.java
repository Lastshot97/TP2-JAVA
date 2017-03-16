import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdjustLabelDifficultyListener implements AdjustmentListener {

	private JLabel difficulte;
	
	public AdjustLabelDifficultyListener(JLabel getDifficulte) {
		this.difficulte = getDifficulte;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent a) {
		switch (a.getValue()) {
		case 1 :
			difficulte.setIcon(new ImageIcon("etoile.png"));
			break;
		case 2 :		
			difficulte.setIcon(new ImageIcon("2etoile.png"));
			break;
		case 3 :
			difficulte.setIcon(new ImageIcon("3etoile.png"));
			break;
		case 4 :
			difficulte.setIcon(new ImageIcon("4etoile.png"));
			break;
		case 5 :
			difficulte.setIcon(new ImageIcon("5etoile.png"));
			break;
		}

	}

}
