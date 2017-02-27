import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCloser implements ActionListener {

	private Puiss4Frame principalFrame;
	private Puis4Dialog dialogFrame;
	
	public GameCloser(Puiss4Frame principalFrame, Puis4Dialog dialogFrame) {
		this.principalFrame = principalFrame;
		this.dialogFrame = dialogFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		principalFrame.dispose();
		dialogFrame.dispose();
	}

}