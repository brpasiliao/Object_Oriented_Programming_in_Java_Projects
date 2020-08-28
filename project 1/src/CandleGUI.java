import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Bian Pasiliao
 * 
 * The CandleGUI class defines a JFrame that will present two candle arrays
 * in such a way that the list of unsorted candles is on the right of the frame
 * and the list of sorted candles is on the left side of the frame.
 *
 */

public class CandleGUI extends JFrame {
	static JFrame frame;
	static Candle[] candles;
	static Candle[] candles2;
	static int numberOfCandles;
	
	/**
	 * This method constructs an instance of a CandleGUI.
	 * 
	 * @param array The unsorted array
	 * @param array2 The sorted array
	 * @param num The subarray length
	 */
	
	public CandleGUI (Candle[] array, Candle[] array2, int num) {
		candles = array;
		candles2 = array2;
		numberOfCandles = num;
	}
	
	/**
	 * This sets the basic properties of the JFrame.
	 */
	
	public static void initialize() {
		frame = new JFrame();
		frame.setSize(400,200);
		frame.setLocation(100, 100);
		frame.setTitle("Candles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,2));
	}
	
	/**
	 * This method transfers the information of the arrays to the JFrame.
	 */
	
	public void printCandlesToGUI() {
		initialize();
		
		Container contentPane = frame.getContentPane();
		TextArea unsortedCandles = new TextArea();
		TextArea sortedCandles = new TextArea();
		contentPane.add(unsortedCandles);
		contentPane.add(sortedCandles);
		
		for (int i = 0; i < numberOfCandles; i++) {
			unsortedCandles.append(candles[i].getHeight() + ", " 
					+ candles[i].getWidth() + ", " 
					+ candles[i].getPrice() + "\n");
			sortedCandles.append(candles2[i].getHeight() + ", " 
					+ candles2[i].getWidth() + ", " 
					+ candles2[i].getPrice() + "\n");
		}
		frame.setVisible(true);
	}
}