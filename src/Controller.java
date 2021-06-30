import java.util.ArrayList;
import java.awt.*;

class Controller {
	
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public void tick() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
			if (bullets.get(i).getY() <= 0 - 32) {
				bullets.remove(i);
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < bullets.size(); j++) {
				if (enemies.get(i).getRectangle().intersects(bullets.get(j).getRectangle())) {
					enemies.remove(i);
					bullets.remove(j);
					return;
				}
			}
		}
	}
	
	public void render(Graphics2D g) {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
	}
	
	public void add(Bullet b) {
		bullets.add(b);
	}
	
	public void add(Enemy e) {
		enemies.add(e);
	}

}
