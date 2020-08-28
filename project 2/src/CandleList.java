/**
 * 
 * @author Bian Pasiliao
 * 
 * This abstract class defines a linked list for CandleNode with
 * an append method.
 *
 */

abstract class CandleList {
    
    CandleNode start;
    public CandleNode first;
    public CandleNode last;
    public int length = 0;

    /**
     * This method adds a node to their proper position depending
     * on whether it is sorted or not.
     * 
     * @param before The node before the position to insert new node
     * @param c The candle to be made into the new node
     */
    
    public void append (CandleNode before, Candle c) {
        CandleNode cn = new CandleNode(c);

        cn.next = before.next;
        before.next = cn;
        
        // If the last node is before the position of the new node,
        // then the new node must be the new last node.
        if (last == before) last = cn;
        
        length++;
        
    }
    
}

