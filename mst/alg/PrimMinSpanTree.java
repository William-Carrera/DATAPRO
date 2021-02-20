package alg;

import impl.StrippedDownSet;
import impl.HeapPriorityQueue;
import impl.OHPQWrapper;
import impl.OptimizedHeapPriorityQueue;
import adt.PriorityQueue;
import adt.Set;
import adt.WeightedGraph;
import adt.WeightedGraph.WeightedEdge;

/**
 * PrimMinSpanTree
 * 
 * Implementation of Prim's algorithm for computing
 * the minimum spanning tree of a graph.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 24, 2015
 */
public class PrimMinSpanTree implements MinSpanTree {

    private boolean optimized;

    public PrimMinSpanTree(boolean optimized) { this.optimized = optimized; }
    public PrimMinSpanTree() { this.optimized = false; }
    
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
            records[i] = new VertexRecord(i, Integer.MAX_VALUE);
        return new HeapPriorityQueue<VertexRecord>(records, new VertexRecord.VRComparator());

    }
    
    /**
     * Compute the minimum spanning tree of a given graph.
     * @param g The given graph
     * @return A set of the edges in the minimum spanning tree
     */
    public Set<WeightedEdge> minSpanTree(WeightedGraph g) {
        VertexRecord[] records = new VertexRecord[g.numVertices()];
        PriorityQueue<VertexRecord> pq = setUpWorklist(records, g);
        Set<WeightedEdge> mstEdges = new StrippedDownSet<WeightedEdge>(g.numVertices());
        int[] parents = new int[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++)
            parents[i] = -1;
        
         //Add code here in part C
        return mstEdges;
    }

}
