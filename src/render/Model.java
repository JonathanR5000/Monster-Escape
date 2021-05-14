package render;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Model extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage texture;
	
	/**Creates a rectangle model
	 * @param width - Rectangle width
	 * @param height - Rectangle height
	 * @param fileName - Texture file name
	 */
	public Model(int width, int height, String fileName) {
		super(width, height);
		if(fileName != null) {
			try {
				this.texture = ImageIO.read(new File("Resources/Sprites/"+fileName+".png"));
			} catch(IOException e) {
				System.err.println("[Render][Model]: Exception loading Model " + fileName);
				texture = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			}
		}
	}
	
	private Model(int w, int h, BufferedImage texture) {
		super(w, h);
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	// Flips the image when it turns left
	public Model flipTexture() {
		int h = texture.getHeight();
		int w = texture.getWidth();
		BufferedImage rotated = new BufferedImage(w, h, texture.getType());
		
		for(int x = 0; x < w; x++) {
			for(int y = 0; y < h; y++) {
				rotated.setRGB(x, y, texture.getRGB(w - 1 - x, y));
			}
		}
		return new Model(this.width, this.height, rotated);
	}
}