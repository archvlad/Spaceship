import java.awt.event.*;

class KeyInput extends KeyAdapter {
	
	private static boolean[] keys = new boolean[256];
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public static boolean getKey(int code) {
		return keys[code];
	}

}
