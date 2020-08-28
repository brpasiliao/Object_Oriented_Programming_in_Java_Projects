import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * 
 * @author Bian Pasiliao
 * 
 * This class creates events, particularly choosing a file or quitting the program, in response
 * to selecting items from a menu in the GUI.
 *
 */

public class FileMenuHandler implements ActionListener {
	JFrame jf;
	UnsortedCandleList candles = new UnsortedCandleList();
	SortedCandleList candles2 = new SortedCandleList();
   
	/**
	 * This method constructs an instance of a CandleGUI.
	 * 
	 * @param jframe The CandleGUI we are setting the menu bar for
	 */
	
	public FileMenuHandler (JFrame jframe) {
		jf = jframe;
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
		
		//Reads each line of the input file until there are no more lines.
		while (line !=null) {
			StringTokenizer tokens = new StringTokenizer (line, ",");
			
			//Add the Candle to the arrays because it is valid.
			if (tokens.countTokens() == 3) {
				int h = Integer.parseInt(tokens.nextToken());
				int w = Integer.parseInt(tokens.nextToken());
				float p = Float.parseFloat(tokens.nextToken());
				Candle c = new Candle(h, w, p);
				candles.add(c);
				candles2.add(c);
			}
			
			//Print to the console because the Candle is not valid.
			else System.out.println(line);
			
			line = file.readLine();
		} //while
		file.close();
    	
		Container contentPane = jf.getContentPane();
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
		} //for
		
		jf.setVisible(true); 
    } //readSource
	
} //FileMenuHandler