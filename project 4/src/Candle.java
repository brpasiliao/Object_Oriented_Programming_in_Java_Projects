/**
 * 
 * @author Bian Pasiliao
 * 
 * The Candle class defines properties of a candle, including the height,
 * width, price, and whether it is lit or not. It also has the get and set
 * methods for each of those attributes.
 *
 */

public class Candle {
	public int height;
	public int width;
	public float price;
	public boolean isLit = false;
	
	/**
	 * This method constructs the instance of a Candle.
	 * 
	 * @param h The given height
	 * @param w The given width
	 * @param p The given price
	 */
	
	public Candle (int h, int w, float p) {
		height = h;
		width = w;
		price = p;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean getLit() {
		return isLit;
	}
	
	public void setLit(boolean isLit) {
		this.isLit = isLit;
	}
	
}