import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import puisQuatre.Puis4;

public class JouerListener implements ActionListener {
	private MenuFrame mf;
	
	public JouerListener(MenuFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Puiss4Frame(new Puis4(7,6,1));
		mf.dispose();
	}

}
