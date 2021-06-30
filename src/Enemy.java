import java.awt.*;
import java.awt.image.*;

class Enemy {
	
	private BufferedImage image = TileSheet.getTile(2, 0, 32);
	private int x;
	private int y;
	private int speed = 3;
	private Rectangle r;
	
	public Enemy() {
		x = (int) (Math.random() * (640 - 32) + 1);
		y = 0 - 32;
		r = new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		y += speed;
		if (y >= 480) {
			x = (int) (Math.random() * (640 - 32) + 1);
			y = 0 - 32;
		}
		r.move(x, y);
	}
	
	public void render(Graphics2D g) {
		g.drawImage(image, x, y, null);
	}
	
	public int getY() {
		return y;
	}
	
	public Rectangle getRectangle() {
		return r;
	}
	
}
