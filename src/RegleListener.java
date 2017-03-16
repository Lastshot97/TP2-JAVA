import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegleListener implements ActionListener {

	private MenuFrame menuFrame;

	public RegleListener(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new RegleDialog(menuFrame);
	}

}
