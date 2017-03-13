import java.util.Observable;

public class MenuModel extends Observable{
	private int niveau;
	
	public MenuModel(){
		this.niveau = 1;
	}
	
	public int getNiveau(){
		return niveau;
	}
	
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
		this.setChanged();
		this.notifyObservers();
	}

}
