import java.awt.image.*;

class TileSheet {
	
	private static BufferedImage tileSheet = ImageLoader.load("res/tilesheet.png");
	
	public static BufferedImage getTile(int x, int y, int size) {
		return tileSheet.getSubimage(x * size, y * size, size, size);
	}

}
