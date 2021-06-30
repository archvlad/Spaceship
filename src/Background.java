import java.awt.*;
import java.awt.image.*;

class Background {

	BufferedImage space = ImageLoader.load("res/space.png");	
	private int y;
	
	public void tick() {
		y += 2;
		if (y == 480) {
			y = 0;
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(space, 0, y, null);
		g.drawImage(space, 0, y - 480, null);
	}

}
