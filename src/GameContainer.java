import java.awt.*;
import java.awt.image.*;

class GameContainer {
	
	private GameManager gm;
	private Window w;
	private BufferStrategy bs;
	private Graphics2D g;
	
	public GameContainer(GameManager gm) {
		setGameManager(gm);
		w = new Window();
	}
	
	public void start() {
		long previous = System.currentTimeMillis();
		long current = 0;
		int elapsed = 0;
		long timer = previous;
		int ticks = 0;
		int frames = 0;
		w.getCanvas().requestFocus();
		while (true) {
			current = System.currentTimeMillis();
			elapsed += current - previous;
			previous = current;
			while (elapsed >= 1000.0 / 20) {
				tick();
				render();
				ticks++;
				frames++;
				elapsed -= 1000.0 / 20;
			}
			try {
				Thread.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println(String.format("ticks = %3d frames = %3d", ticks, frames));
				ticks = 0;
				frames = 0;
				timer += 1000;
			}
		}
	}
	
	public void setGameManager(GameManager gm) {
		this.gm = gm;
	}
	
	public GameManager getGameManager() {
		return gm;
	}
	
	private void tick() {
		gm.tick();
	}
	
	private void render() {
		bs = w.getCanvas().getBufferStrategy();
		if (bs == null) {
			w.getCanvas().createBufferStrategy(2);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		gm.render(g);
		g.dispose();
		bs.show();
	}

}
