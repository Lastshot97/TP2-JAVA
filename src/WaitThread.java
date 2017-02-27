import puisQuatre.Puis4;

public class WaitThread extends Thread {

	private Puis4 modele;
	
	public WaitThread(Puis4 modele) {
		this.modele = modele;
	}

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modele.progJoue();
	}
}
