import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class goMenuListener implements ActionListener {
	
	private Puiss4Frame principalFrame;
	
	public goMenuListener(Puiss4Frame principalFrame) {
		this.principalFrame = principalFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		principalFrame.dispose();
		new MenuFrame();
	}

}
