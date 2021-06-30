import java.awt.*;
import java.awt.image.*;

class GameManager {
	
	Background b = new Background();
	Player p = new Player();
	
	public void tick() {
		p.tick();
		b.tick();
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 640 , 480);
		b.render(g);
		p.render(g);
	}	
	
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		GameContainer gc = new GameContainer(gm);
		gc.start();
	}

}
