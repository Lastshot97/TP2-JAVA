import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
/**
 * classe qui affiche une image en tant que fond d'écran contenue dans un canvas
 * 
 * @author Julien | Hugo
 * @see MenuFrame
 */
public class ImageCanvas extends Canvas{

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	public ImageCanvas(Image image){
		this.image = image;
	}
	
	public void paint(Graphics g){
		Logger.log(Logger.ALL, "affichage d'une image en tant que fond d'écran");
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
