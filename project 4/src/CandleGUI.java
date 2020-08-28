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
	UnsortedCandleList candles;
	SortedCandleList candles2;
	
	JMenuBar menuBar = new JMenuBar();
	Container contentPane = getContentPane();
	
	/**
	 * This method constructs an instance of a CandleGUI.
	 */
	
	public CandleGUI () {
		initialize();
	} //constructor
	
	/**
	 * This sets the basic properties of the JFrame.
	 */
	
	public void initialize() {
		setSize(400,400);
		setLocation(100, 100);
		setTitle("Candles");
		createFileMenu();
		createEditMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setVisible(true);
	} //initialize
	
	/**
	 * This creates the file menu with items to choose a file
	 * and to quit the program.
	 */
	
	public void createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);

		JMenuItem open, quit;
		open = new JMenuItem("Open"); 
		open.addActionListener(fmh);
		fileMenu.add(open);
		fileMenu.addSeparator(); 
		quit = new JMenuItem("Quit");  
		quit.addActionListener(fmh);
		fileMenu.add(quit);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		
	} //createFileMenu
	
	/**
	 * This creates the edit menu with an item to search for 
	 * specific candles
	 */
	
	public void createEditMenu() {
		JMenu editMenu = new JMenu("Edit");
		EditMenuHandler emh = new EditMenuHandler(this);
		
		JMenuItem search = new JMenuItem("Search");
		search.addActionListener(emh);
		editMenu.add(search);
		
		menuBar.add(editMenu);
	} //createEditMenu
	
	/**
	 * This method adds the candles to the GUI based on the price
	 * 
	 * @param price Only candles less than or equal to this will be displayed
	 */
	
	public void printCandlesToGUI(float price) {
		contentPane.removeAll();
		TextArea unsortedCandles = new TextArea();
		TextArea sortedCandles = new TextArea();
		contentPane.add(unsortedCandles);
		contentPane.add(sortedCandles);
		
		unsortedCandles.append("Unsorted Candles:\n");
		sortedCandles.append("Sorted Candles:\n");
		
		CandleNode cnUnsorted = candles.first.next;
		CandleNode cnSorted = candles2.first.next;
		for (int i = 0; i < candles.length; i++) {
			if (cnUnsorted.data.getPrice() <= price) 
				unsortedCandles.append(cnUnsorted.data.getHeight() + ", " 
						+ cnUnsorted.data.getWidth() + ", " 
						+ cnUnsorted.data.getPrice() + "\n");
			if (cnSorted.data.getPrice() <= price)
				sortedCandles.append(cnSorted.data.getHeight() + ", " 
						+ cnSorted.data.getWidth() + ", " 
						+ cnSorted.data.getPrice() + "\n");
				
			cnUnsorted = cnUnsorted.next;
			cnSorted = cnSorted.next;
		} //for
		
		setVisible(true);
    }
	
} //CandleGUI