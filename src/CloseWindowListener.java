import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseWindowListener extends WindowAdapter {
	
	private Window fenetre;
	
	public CloseWindowListener(Window fenetre) {
		this.fenetre = fenetre;
	}
	
	public void windowClosing (WindowEvent e){
		fenetre.dispose();
	}

}
