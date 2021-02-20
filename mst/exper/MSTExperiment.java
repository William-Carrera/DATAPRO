package exper;

import impl.WeightedGraphFactory;
import adt.WeightedGraph;
import alg.KruskalMinSpanTree;
import alg.MinSpanTree;
import alg.PrimMinSpanTree;

public class MSTExperiment {

    private static int KRUSKAL = 0, PRIM = 1,
            UNOPT = 0, OPT = 1,
            ADJLIST = 0, ADJMAT = 1,
            SPARSE = 0, MEDIUM = 1, DENSE = 2;
    
    public static long[][][][] runExperiment(int numVertices, int runs) {
        long[][][][] results = new long[2][2][2][3];
        for (int i = 0; i < runs; i++) {
            runExperimentOnGraph(WeightedGraphFactory.weightedUndirectedALGraphRandom(numVertices, 3 * numVertices), SPARSE, results);
            runExperimentOnGraph(WeightedGraphFactory.weightedUndirectedALGraphRandom(numVertices, numVertices * numVertices / 3), MEDIUM, results);
            runExperimentOnGraph(WeightedGraphFactory.weightedUndirectedALGraphRandom(numVertices, 3 * numVertices * numVertices / 4), DENSE, results);
        }
        for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++)
            for (int k = 0; k < 2; k++) for (int m = 0; m < 3; m++) 
                results[i][j][k][m]/=runs;
        return results;
    }

    private static void runExperimentOnGraph(WeightedGraph graph, int density, long[][][][] results) {
        runExperimentOnGraphRep(graph, density, ADJLIST, results);
        runExperimentOnGraphRep(WeightedGraphFactory.weightedUndirectedAMGraphCopy(graph), density, ADJMAT, results);
    }

    private static void runExperimentOnGraphRep(WeightedGraph graph, int density, int rep, long[][][][] results) {
        results[KRUSKAL][UNOPT][rep][density] += timeRun(new KruskalMinSpanTree(0, 0), graph);
        results[KRUSKAL][OPT][rep][density] += timeRun(new KruskalMinSpanTree(1, 2), graph);
        results[PRIM][UNOPT][rep][density] += timeRun(new PrimMinSpanTree(false), graph);
        results[PRIM][OPT][rep][density] += timeRun(new PrimMinSpanTree(true), graph);
    }

    private static long timeRun(MinSpanTree mster, WeightedGraph graph) {
        long fore = System.nanoTime();
        mster.minSpanTree(graph);
        long aft = System.nanoTime();
        return aft - fore;
    }

    public static void main(String[] args) {
        runExperiment(100, 5);
        long[][][][] results = runExperiment(100, 5);
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJLIST][SPARSE] + "&" +
                results[KRUSKAL][OPT][ADJLIST][SPARSE] + "&&" +
                results[PRIM][UNOPT][ADJLIST][SPARSE] + "&" +
                results[PRIM][OPT][ADJLIST][SPARSE] + "\\\\");
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJMAT][SPARSE] + "&" +
                results[KRUSKAL][OPT][ADJMAT][SPARSE] + "&&" +
                results[PRIM][UNOPT][ADJMAT][SPARSE] + "&" +
                results[PRIM][OPT][ADJMAT][SPARSE] + "\\\\ \\\\");
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJLIST][MEDIUM] + "&" +
                results[KRUSKAL][OPT][ADJLIST][MEDIUM] + "&&" +
                results[PRIM][UNOPT][ADJLIST][MEDIUM] + "&" +
                results[PRIM][OPT][ADJLIST][MEDIUM] + "\\\\");
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJMAT][MEDIUM] + "&" +
                results[KRUSKAL][OPT][ADJMAT][MEDIUM] + "&&" +
                results[PRIM][UNOPT][ADJMAT][MEDIUM] + "&" +
                results[PRIM][OPT][ADJMAT][MEDIUM] + "\\\\ \\\\");
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJLIST][DENSE] + "&" +
                results[KRUSKAL][OPT][ADJLIST][DENSE] + "&&" +
                results[PRIM][UNOPT][ADJLIST][DENSE] + "&" +
                results[PRIM][OPT][ADJLIST][DENSE] + "\\\\");
        System.out.println("&" + results[KRUSKAL][UNOPT][ADJMAT][DENSE] + "&" +
                results[KRUSKAL][OPT][ADJMAT][DENSE] + "&&" +
                results[PRIM][UNOPT][ADJMAT][DENSE] + "&" +
                results[PRIM][OPT][ADJMAT][DENSE] + "\\\\");
         }
    
}
