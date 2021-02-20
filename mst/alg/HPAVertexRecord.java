package alg;


import java.util.Comparator;

import impl.HeapPositionAware;

/**
 * HPAVertexRecord
 * 
 * Simple class to represent the record of a vertex
 * for use in Prim's algorithm and Dijkstra's algorithm
 * in a priority queue, modified so that it is aware
 * of its position in a heap.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 24, 2015
 */
public class HPAVertexRecord extends VertexRecord implements HeapPositionAware {
    
    // Having to rewrite this comparator is a hack....
    public static class HPAVRComparator implements Comparator<HPAVertexRecord>{
        public int compare(HPAVertexRecord u, HPAVertexRecord v) {
            return v.getDistance() - u.getDistance();
        }
    }
   

    /**
     * Where this thing is in the priority queue
     */
    private int pos;

    public HPAVertexRecord(int id, int distance) {
        super(id, distance);
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }
    public int getPosition() {
        return pos;
    }

    
    @Override
    public String toString() {
        return super.toString() + "[" + pos + "]";
    }

}
