package alg;

import java.util.Comparator;


/**
 * VertexRecord
 * 
 * Simple class to represent the record of a vertex
 * for use in Prim's algorithm and Dijkstra's algorithm
 * in a priority queue.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 24, 2015
 */
public class VertexRecord {

    public static class VRComparator implements Comparator<VertexRecord>{
        public int compare(VertexRecord u, VertexRecord v) {
            return v.distance - u.distance;
        }
    }

    /**
     * Which vertex is this?
     */
    public final int id;

    /**
     * The (current) upper bound on distance.
     */
    private int distance;

    /**
     * Plain constructor
     */
    public VertexRecord(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getDistance() { return distance; }
    
    @Override
    public boolean equals(Object other) {
        if (! (other instanceof VertexRecord)) return false;
        else return id == ((VertexRecord) other).id;
    }
    
    @Override
    public String toString() {
        return "VR (" + id + ") " + distance;
    }

}
