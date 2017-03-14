import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class ImageCanvas extends Canvas{
	private Image image;
	
	public ImageCanvas(Image image){
		this.image = image;
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
