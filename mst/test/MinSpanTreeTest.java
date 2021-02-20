package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import adt.WeightedGraph;
import adt.WeightedGraph.WeightedEdge;
import alg.MinSpanTree;
import impl.WeightedGraphFactory;

public abstract class MinSpanTreeTest {

    protected MinSpanTree mstAlg;
    
    protected abstract void reset();
    private void graphFileTest(String file, int target) {
        reset();
        WeightedGraph g = WeightedGraphFactory.weightedUndirectedALGraphFromFile(file);
        int totalWeight = 0;
        for (WeightedEdge e : mstAlg.minSpanTree(g)) {
            totalWeight += e.weight;
        }
        //assertEquals(target, totalWeight, 0.01);
        assertEquals(target, totalWeight);
    }
    @Test
    public void big() {
        graphFileTest("big",4628);
    }
    
    @Test
    public void simple() {
        graphFileTest("simple",6);
    }
    
    @Test
    public void simpleFullyConnected() {
        graphFileTest("simple-fully-connected",6);
    }
    
    @Test
    public void longPathShortPath() {
        graphFileTest("long-path-short-path",51);
    }
    
    @Test
    public void minimal() {
        graphFileTest("minimal",1);
    }
    
    
    
}
