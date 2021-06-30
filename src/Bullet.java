import java.awt.*;
import java.awt.image.*;

class Bullet {
	
	private BufferedImage image = TileSheet.getTile(1, 0, 32);
	private int x;
	private int y;
	private int speed = 20;
	private Rectangle r;
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		r = new Rectangle(x + 12, y + 7, 6, 19);
	}
	
	public void tick() {
		y -= speed;
		r.move((int) r.getX(), (int) r.getY() - speed);
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
