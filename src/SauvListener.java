import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import puisQuatre.Puis4;

public class SauvListener implements ActionListener {
	private Puis4 modele;
	
	public SauvListener(Puis4 modele) {
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("sauvegarde.pw4"));
			oos.writeObject(modele);
			oos.close();
			// TODO rajouter un son comfirmant la sauvegarde ( en plus des sons bouttons )
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
