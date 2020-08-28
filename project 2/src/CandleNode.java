/**
 * 
 * @author Bian Pasiliao
 * 
 * CandleNode is an object that can be part of linked lists
 * with one part that is data and the other part that points
 * to another node.
 *
 */

public class CandleNode {
	protected Candle data;
    protected CandleNode next;

    public CandleNode () {
    	data = null;
    	next = null;
    }
    
    public CandleNode (Candle c) {
        data = c;
        next = null;
    }

}