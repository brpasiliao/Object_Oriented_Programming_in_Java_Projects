/**
 * 
 * @author Bian Pasiliao
 * 
 * UnortedCandleList is a type of CandleList that lists the candle
 * data unsorted.
 *
 */

public class UnsortedCandleList extends CandleList {
    
    public UnsortedCandleList () {
        start = new CandleNode();
        first = start;
        last = start;
    }

    /**
     * This method adds the new node to the end of the list.
     * 
     * @param c The new candle
     */
    
    public void add (Candle c) {
        this.append(last, c);
    }
    
}