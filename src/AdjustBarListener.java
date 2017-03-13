import java.awt.Label;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import puisQuatre.Puis4;

public class AdjustBarListener implements AdjustmentListener {

	private Puis4 m;
	private Label affNivLabel;
	public AdjustBarListener(Puis4 m, Label affNivLabel){
		this.m = m;
		this.affNivLabel = affNivLabel;
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		m.setNiveauJeu(e.getValue());
		affNivLabel.setText("niveau choisi : " + m.getNiveauJeu());
	}

}
