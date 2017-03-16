
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseWindowListener extends WindowAdapter {
	
	private Window fenetre;
	
	public CloseWindowListener(Frame f) {
		this.fenetre = f;
	}
	
	public CloseWindowListener(Dialog d) {
		this.fenetre = d;
	}

	public void windowClosing (WindowEvent e){
		fenetre.dispose();
	}

}
