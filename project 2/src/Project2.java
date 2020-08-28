import java.util.StringTokenizer;

/**
 * 
 * @author Bian Pasiliao
 * 
 * This program displays a list of candles arranged by price onto a GUI. It reads a file that 
 * consists of Candles, filters out invalid candles, adds them to unsorted and sorted linked lists, 
 * then displays the data using CandleGUI.
 *
 */

public class Project2 {
	
	public static void main(String[] args) {
		UnsortedCandleList candles = new UnsortedCandleList();
		SortedCandleList candles2 = new SortedCandleList();
		
		filterCandles("input.txt", candles, candles2);
				
		CandleGUI gui = new CandleGUI(candles, candles2);
		gui.printCandlesToGUI();
	}
	
	/**
	 * This method converts the data from the input file and adds them to the lists.
	 * 
	 * @param filename The name of the input file to be read
	 * @param list The list that leaves candles unsorted 
	 * @param list2 The list that sorts candles 
	 */
	
	private static void filterCandles(String filename, UnsortedCandleList list, SortedCandleList list2) {
		TextFileInput file = new TextFileInput(filename);
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
				list.add(c);
				list2.add(c);
			}
			
			//Print to the console because the Candle is not valid.
			else System.out.println(line);
			
			line = file.readLine();
		}


		file.close();
	}
}