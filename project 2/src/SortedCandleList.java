/**
 * 
 * @author Bian Pasiliao
 * 
 * SortedCandleList is a type of CandleList that sorts the candles
 * by price. 
 *
 */

public class SortedCandleList extends CandleList {
	
    public SortedCandleList () {
        start = new CandleNode();
        first = start;
        last = start;
    }

    /**
     * This method adds the new node to its proper position.
     * 
     * @param c The new candle
     */
    
    public void add (Candle c) {
        CandleNode before = first;
        
        // We cannot compare the price of a candle to a null candle.
        if (before.next != null) {
	        while (c.getPrice() > before.next.data.getPrice()) {
	            before = before.next; 
	            if (before.next == null) break;
	        }
	        
	        this.append(before, c);
        }
        
        // When the next node is null, the new node must go to the
        // end of the list.
        else this.append(last, c);
    }
}