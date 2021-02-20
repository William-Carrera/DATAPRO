package alg;

import adt.WeightedGraph;

/**
 * BellmanFordSSSP
 * 
 * An implementation of the Bellman-Ford algorithm for
 * computing the single-source shortest paths of a graph
 * given a source.
 * 
 * @author Thomas VanDrunen
 * CSCI 345, Wheaton College
 * June 23, 2015
 */
public class BellmanFordSSSP implements SSSP {

    /**
     * Compute the shortest paths in a given tree from
     * a given source to all over vertices.
     * @param g The given graph
     * @param source The vertex from which to compute paths
     * @return A set of edges constituting the tree of shortest
     * paths as an array of parents.
     */
    public int[] sssp(WeightedGraph g, int source) {
        double[] distanceBounds = new double[g.numVertices()];
        int[] parents = new int[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++) {
            distanceBounds[i] = Double.POSITIVE_INFINITY;
            parents[i] = -1;
        }
        //Add code here in part B
         return parents;
    }

}
