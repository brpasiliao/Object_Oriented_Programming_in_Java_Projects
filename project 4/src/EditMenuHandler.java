import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * @author Bian Pasiliao
 * 
 * This class creates the event of searching for candles less than or greater than a select price
 * in response to selecting the search item from the edit menu in the GUI.
 *
 */

public class EditMenuHandler implements ActionListener {
	CandleGUI cgui;
   
	/**
	 * This method constructs an instance of a CandleGUI.
	 * 
	 * @param candlegui The CandleGUI we are setting the menu bar for
	 */
	
	public EditMenuHandler (CandleGUI candlegui) {
		cgui = candlegui;
	} //constructor

	/**
	 * This method specifies what to do when a menu item is selected.
	 */
	
	public void actionPerformed(ActionEvent event) {
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Search")) inputPrice(); 
	} //actionPerformed
	
	public void inputPrice() {
		if (cgui.candles == null) JOptionPane.showMessageDialog(null, "A file has not been selected.");
		
		else {
			float input = Float.parseFloat(JOptionPane.showInputDialog(null, "Please input candle price."));
			
			if (input <= 0) throw new IllegalArgumentException("Price can't be less than or equal to zero");
			cgui.printCandlesToGUI(input);
		} //else
		
	} //inputPrice

	
} //FileMenuHandler