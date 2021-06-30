import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

class Player {
	
	private BufferedImage image = TileSheet.getTile(0, 0, 32);
	private int x;
	private int y;
	private Controller c = new Controller();
	private boolean canShoot = true;
	private int speed = 10;
	
	public Player() {
		for (int i = 0; i < 5; i++) {
			c.add(new Enemy());
		}
	}
	
	double timer = 0;
	boolean shooting = false;
	double ms = 0.05;
	public void tick() {
		if (KeyInput.getKey(KeyEvent.VK_W) && KeyInput.getKey(KeyEvent.VK_D)) {
			y -= speed / Math.sqrt(2);
			x += speed / Math.sqrt(2);
		} else if (KeyInput.getKey(KeyEvent.VK_W) && KeyInput.getKey(KeyEvent.VK_A)) {
			y -= speed / Math.sqrt(2);
			x -= speed / Math.sqrt(2);
		} else if (KeyInput.getKey(KeyEvent.VK_S) && KeyInput.getKey(KeyEvent.VK_D)) {
			y += speed / Math.sqrt(2);
			x += speed / Math.sqrt(2);
		} else if (KeyInput.getKey(KeyEvent.VK_S) && KeyInput.getKey(KeyEvent.VK_A)) {
			y += speed / Math.sqrt(2);
			x -= speed / Math.sqrt(2);
		} else if (KeyInput.getKey(KeyEvent.VK_W)) {
			y -= speed;
		} else if (KeyInput.getKey(KeyEvent.VK_S)) {
			y += speed;
		} else if (KeyInput.getKey(KeyEvent.VK_A)) {
			x -= speed;
		} else if (KeyInput.getKey(KeyEvent.VK_D)) {
			x += speed;
		}
		if (x < 0) {
			x = 0;
		}
		if (x > 640 - 32) {
			x = 640 - 32;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > 480 - 32) {
			y = 480 - 32;
		}
		if (KeyInput.getKey(KeyEvent.VK_SPACE)) {
			shooting = true;
		}
		if (!KeyInput.getKey(KeyEvent.VK_SPACE)) {
			shooting = false;
		}
		if (shooting) {
			timer = Math.round(timer * 100) / 100.0;
			System.out.println(timer);
			if (timer % 0.2 == 0) {
				c.add(new Bullet(x, y));
				timer = 0;
			}	
			timer += ms;
		} else {
			if (timer % 0.2 != 0) {
				timer += ms;
				timer = Math.round(timer * 100) / 100.0;
			} else {
				timer = 0;
			}
		}
		c.tick();
	}
	
	public void render(Graphics2D g) {
		g.drawImage(image, x, y, null);
		c.render(g);
	}

}
