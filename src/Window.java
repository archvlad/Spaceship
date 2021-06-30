import javax.swing.*;
import java.awt.*;

class Window {

	private JFrame frame;
	private Canvas canvas;
	
	public Window() {
		frame = new JFrame();
		canvas = new Canvas();
		canvas.setSize(640, 480);
		canvas.addKeyListener(new KeyInput());
		canvas.addMouseListener(new MouseInput());
		canvas.addMouseMotionListener(new MouseInput());
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game");
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

}
