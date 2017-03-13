import puisQuatre.Puis4;

public class WaitThread extends Thread {

	private Puis4 modele;
	
	private static int nbrProg = 0;
	
	public WaitThread(Puis4 modele) {
		this.modele = modele;
	}

	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//if (! modele.estTermine()){
			modele.progJoue();
			nbrProg ++;
			PlaySound.jeton();
		//}
	}
	
	public int getNbrProg(){
		return nbrProg;
	}
}
