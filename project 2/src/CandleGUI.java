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
	static UnsortedCandleList candles;
	static SortedCandleList candles2;
	
	/**
	 * This method constructs an instance of a CandleGUI.
	 * 
	 * @param list The unsorted list
	 * @param list2 The sorted list
	 */
	
	public CandleGUI (UnsortedCandleList list, SortedCandleList list2) {
		candles = list;
		candles2 = list2;
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
	 * This method transfers the information of the lists to the JFrame.
	 */
	
	public void printCandlesToGUI() {
		initialize();
		
		Container contentPane = frame.getContentPane();
		TextArea unsortedCandles = new TextArea();
		TextArea sortedCandles = new TextArea();
		contentPane.add(unsortedCandles);
		contentPane.add(sortedCandles);
		
		CandleNode cnUnsorted = candles.first.next;
		CandleNode cnSorted = candles2.first.next;
		
		for (int i = 0; i < candles.length; i++) {
			unsortedCandles.append(cnUnsorted.data.getHeight() + ", " 
					+ cnUnsorted.data.getWidth() + ", " 
					+ cnUnsorted.data.getPrice() + "\n");
			sortedCandles.append(cnSorted.data.getHeight() + ", " 
					+ cnSorted.data.getWidth() + ", " 
					+ cnSorted.data.getPrice() + "\n");
			
			cnUnsorted = cnUnsorted.next;
			cnSorted = cnSorted.next;
		}
		
		frame.setVisible(true);
	}
}