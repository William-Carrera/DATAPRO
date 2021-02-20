package test;

import alg.PrimMinSpanTree;

public class OPMSTTest extends MinSpanTreeTest {

    protected void reset() {
        mstAlg = new PrimMinSpanTree(true);
    }

}
