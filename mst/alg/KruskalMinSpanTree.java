package alg;

import impl.StrippedDownSet;
import impl.WeightedGraphFactory;
import impl.HeapPriorityQueue;
import impl.ArrayForestDisjointSet;
import adt.DisjointSet;
import adt.PriorityQueue;
import adt.Set;
import adt.WeightedGraph;
import adt.WeightedGraph.WeightedEdge;

import java.util.Comparator;

/**
 * KruskalMinSpanTree
 * 
 * Implementation of Kruskal's algorithm for computing
 * the minimum spanning tree of a graph.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 23, 2015
 */
public class KruskalMinSpanTree implements MinSpanTree {

    private int findStrategy;
    private int unionStrategy;
    
    public KruskalMinSpanTree(int findStrategy, int unionStrategy) {
        this.findStrategy = findStrategy;
        this.unionStrategy = unionStrategy;
    }

    public KruskalMinSpanTree() { this(0, 0); }
    
    /**
     * Compute the minimum spanning tree of a given graph.
     * @param g The given graph
     * @return A set of the edges in the minimum spanning tree
     */
    public Set<WeightedEdge> minSpanTree(WeightedGraph g) {
        Set<WeightedEdge> treeEdges = new StrippedDownSet<WeightedEdge>(g.numVertices());
        WeightedEdge[] allEdges = new WeightedEdge[g.numEdges()];
        int i = 0;
        for (WeightedEdge we : g.edges())
            allEdges[i++] = we;
        alg.Sorts.countingSort(allEdges, new Sorts.ToInteger<WeightedEdge>() {
            public int v(WeightedEdge item) {
                return item.weight;
            }
        });
        
        DisjointSet vertexConnections = new ArrayForestDisjointSet(g.numVertices(), findStrategy, unionStrategy);
        
         //Add code here in part B
        
        return treeEdges;
    }

    public static void main(String[] args) {

            WeightedGraph g = WeightedGraphFactory.weightedUndirectedALGraphFromFile("simple");
            double totalWeight = 0.0;
            KruskalMinSpanTree kmst = new KruskalMinSpanTree();
            for (WeightedEdge e : kmst.minSpanTree(g)) {
                totalWeight += e.weight;
                System.out.println(e);
            }
            System.out.println(totalWeight);

    }    
    
}
