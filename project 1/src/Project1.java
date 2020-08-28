import java.util.*;

/**
 * 
 * @author Bian Pasiliao
 * 
 * This program displays a list of candles arranged by price onto a GUI. It reads a file that 
 * consists of Candles, filters out invalid candles, sorts the array of valid candles by price, 
 * then displays the data using CandleGUI.
 *
 */

public class Project1 {
	
	public static void main(String args[]) {
		
		Candle[] candles = new Candle[20];
		Candle[] candles2 = new Candle[20];
		
		int numberOfCandles = filterCandles("input.txt", candles, candles2);
		
		sort(candles2, numberOfCandles);
		
		CandleGUI gui = new CandleGUI(candles, candles2, numberOfCandles);
		gui.printCandlesToGUI();
		
	}
	
	/**
	 * This method converts the data from the input file into two copies of
	 * arrays which contain valid candles.
	 * 
	 * @param filename The name of the input file to be read
	 * @param array The candle array that will be left unsorted
	 * @param array2 The second candle array that will be sorted
	 * @return The length of the subarray, so no nulls are counted
	 */
	
	private static int filterCandles(String filename, Candle[] array, Candle[] array2) {
		TextFileInput file = new TextFileInput(filename);
		int num = 0;
		String line = file.readLine();
		
		//Reads each line of the input file until the arrays are filled up
		//or there are no more lines.
		while (num < array.length && line !=null) {
			StringTokenizer tokens = new StringTokenizer (line, ",");
			
			//Add the Candle to the arrays because it is valid
			if (tokens.countTokens() == 3) {
				int h = Integer.parseInt(tokens.nextToken());
				int w = Integer.parseInt(tokens.nextToken());
				float p = Float.parseFloat(tokens.nextToken());
				Candle c = new Candle(h, w, p);
				array[num] = c;
				array2[num++] = c;
			}
			//Print to the console because the Candle is not valid
			else System.out.println(line);
			
			line = file.readLine();
		}
		//Shows what the issue is when the arrays are filled up
		if (line != null) {
			System.out.println("File contains too many numbers.");
			System.out.println("This program can process only " + array.length + " numbers.");
			System.exit(1);
		}
		file.close();
		return num;
	}
	
	/**
	 * This sorts the array of candles by price using selection sort
	 * 
	 * @param candles The array of candles to be sorted
	 * @param num The length of the subarray
	 */
	
	private static void sort(Candle[] candles, int num) {
		//Only until second to last element because last element will
		//already be sorted
		for (int i = 0; i < num-1; i++) {
			int indexLowest = i;

			//Starts after i to avoid repetition of comparison
			for (int j = i+1; j < num; j++) {
				if (candles[j].getPrice() < candles[indexLowest].getPrice())
					indexLowest = j;
			}
			
			//Swap place with lowest number
			if (candles[i] != candles[indexLowest]) {
				Candle temp = candles[i];
				candles[i] = candles[indexLowest];
				candles[indexLowest] = temp;
			}
		}
	}	
}
