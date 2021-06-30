import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class ImageLoader {

	public static BufferedImage load(String filename) {
		BufferedImage image = null;
		File fileImage = new File(filename);
		try {
			image = ImageIO.read(fileImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

}
