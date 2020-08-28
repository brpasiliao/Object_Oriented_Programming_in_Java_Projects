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
		setSize(400,200);
		setLocation(100, 100);
		setTitle("Candles");
		createFileMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setVisible(true);
	} //initialize
	
	/**
	 * This creates a menu bar that has a file menu with items to choose a file
	 * and to quit the program.
	 */
	
	private void createFileMenu() {
		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler fmh = new FileMenuHandler(this);

		item = new JMenuItem("Open"); 
		item.addActionListener(fmh);
		fileMenu.add(item);

		fileMenu.addSeparator(); 
		    
		item = new JMenuItem("Quit");  
		item.addActionListener(fmh);
		fileMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		
	} //createFileMenu
	
} //CandleGUI