import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
/*
 * Cette classe sert à dessiner le fond d'écran pour le menu principale
 */
public class ImageCanvas extends Canvas{

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	public ImageCanvas(Image image){
		this.image = image;
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
