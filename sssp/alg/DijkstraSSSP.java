package alg;

import impl.HeapPriorityQueue;
import impl.OHPQWrapper;
import impl.OptimizedHeapPriorityQueue;
import adt.PriorityQueue;
import adt.WeightedGraph;

/**
 * DijkstraSSSP
 * 
 * An implementation of Dijkstra's algorithm for
 * computing the single-source shortest paths of a graph
 * given a source.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 29, 2015
 */
public class DijkstraSSSP implements SSSP {

    private boolean optimized;
    
    public DijkstraSSSP(boolean optimized) { this.optimized = optimized; }
    public DijkstraSSSP() { this.optimized = false; }
    
    private PriorityQueue<VertexRecord> setUpWorklist(VertexRecord[] records, WeightedGraph g) {
        if (optimized) {
            // this extra array is a hack....
            HPAVertexRecord[] hpaRecords = new HPAVertexRecord[records.length];
            for (int i = 0; i < g.numVertices(); i++)
                records[i] = hpaRecords[i] = new HPAVertexRecord(i, Integer.MAX_VALUE);
            // this wrapper is a hack...
            return new OHPQWrapper(new OptimizedHeapPriorityQueue<HPAVertexRecord>(hpaRecords, new HPAVertexRecord.HPAVRComparator()));
        }
        
        for (int i = 0; i < g.numVertices(); i++)
            records[i] = new VertexRecord(i, Double.POSITIVE_INFINITY);
        return new HeapPriorityQueue<VertexRecord>(records, new VertexRecord.VRComparator());

    }

    
    /**
     * Compute the shortest paths in a given tree from
     * a given source to all over vertices.
     * @param g The given graph
     * @param source The vertex from which to compute paths
     * @return A set of edges constituting the tree of shortest
     * paths.
     */
    public int[] sssp(WeightedGraph g, int source) {
        VertexRecord[] distanceBounds = new VertexRecord[g.numVertices()];
        int[] parents = new int[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++) {
            //distanceBounds[i] = new VertexRecord(i, Double.POSITIVE_INFINITY);
            parents[i] = -1;
        }
        PriorityQueue<VertexRecord> pq = setUpWorklist(distanceBounds, g);
                //new HeapPriorityQueue<VertexRecord>(distanceBounds, new VertexRecord.VRComparator());
        distanceBounds[source].setDistance(0);
        pq.increaseKey(distanceBounds[source]);
          //add code here in part C
        return parents;
    }

    

}
