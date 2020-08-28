import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author Bian Pasiliao
 * 
 * This class creates the events of choosing a file or quitting the program, in response
 * to selecting open or quit from the file menu in the GUI.
 *
 */

public class FileMenuHandler implements ActionListener {
	CandleGUI cgui;

	/**
	 * This method constructs an instance of a CandleGUI.
	 * 
	 * @param candlegui The CandleGUI we are setting the menu bar for

	 */
	
	public FileMenuHandler (CandleGUI candlegui) {
		cgui = candlegui;
	} //constructor

	/**
	 * This method specifies what to do when a menu item is selected.
	 */
	
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open")) openFile(); 
		else if (menuName.equals("Quit")) System.exit(0);
	} //actionPerformed

	/**
	 * This method lets the user choose a file from their computers.
	 */
	
    private void openFile() {
    	JFileChooser chooser;
    	int status;
    	chooser = new JFileChooser();
    	status = chooser.showOpenDialog(null);
    	if (status == JFileChooser.APPROVE_OPTION) readSource(chooser.getSelectedFile());
    	else JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    /**
     * This method converts the data from the input file, adds them to the lists, and prints
     * them onto the JFrame.
     * 
     * @param chosenFile The input file chosen to be read from
     */
    
    private void readSource(File chosenFile) {
    	String chosenFileName = chosenFile.getName();
    	TextFileInput file = new TextFileInput(chosenFileName);
		String line = file.readLine();
		
		cgui.candles = new UnsortedCandleList();
		cgui.candles2 = new SortedCandleList();
		
		//Reads each line of the input file until there are no more lines.
		while (line !=null) {
			StringTokenizer tokens = new StringTokenizer (line, ",");
			
			//Add the Candle to the arrays because it is valid.
			if (tokens.countTokens() == 3) {
				int h = Integer.parseInt(tokens.nextToken());
				int w = Integer.parseInt(tokens.nextToken());
				float p = Float.parseFloat(tokens.nextToken());
				Candle c = new Candle(h, w, p);
				cgui.candles.add(c);
				cgui.candles2.add(c);
			}
			
			//Print to the console because the Candle is not valid.
			else System.out.println(line);
			
			line = file.readLine();
		} //while
		file.close();
		cgui.printCandlesToGUI(cgui.candles2.last.data.getPrice());
    	
    } //readSource
	
} //FileMenuHandler