package impl;

import adt.PriorityQueue;
import alg.VertexRecord;
import alg.HPAVertexRecord;

/**
 * Java's type rules don't allow OptimizedHeapPriorityQueue<HPAVertexRecord>
 * to be treated as a subtype of PriorityQueue<VertexRecord>. You can see why
 * with a method like insert(), since that would allow a non-HPAVertexRecord
 * to be inserted into the OptimizedHeapPriorityQueue, which expects HeapPositionAwares.
 * This class is the hack to get around that: It's a wrapper to make
 * an OptimizedHeapPriorityQueue<HPAVertexRecord> masquerade as a
 * PriorityQueue<VertexRecord>.
 * 
 * @author tvandrun
 *
 */

public class OHPQWrapper implements PriorityQueue<VertexRecord> {

    private OptimizedHeapPriorityQueue<HPAVertexRecord> internal;
    
    public OHPQWrapper(OptimizedHeapPriorityQueue<HPAVertexRecord> internal) {
        this.internal = internal;
    }
    
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    // Can't do, but never need to
    public void insert(VertexRecord key) {
        throw new UnsupportedOperationException();
    }

    public VertexRecord max() {
        return internal.max();
    }

    public VertexRecord extractMax() {
        return internal.extractMax();
    }

    public boolean contains(VertexRecord key) {
        return internal.contains((HPAVertexRecord) key);
    }

    public void increaseKey(VertexRecord key) {
        internal.increaseKey((HPAVertexRecord) key);
        
    }

    public void decreaseKey(VertexRecord key) {
        internal.decreaseKey((HPAVertexRecord) key);
    }

    

}
