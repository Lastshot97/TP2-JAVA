
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseWindowListener extends WindowAdapter {
	
	private Frame fenetre;
	
	public CloseWindowListener(Frame fenetre) {
		this.fenetre = fenetre;
	}
	
	public void windowClosing (WindowEvent e){
		fenetre.dispose();
	}

}
