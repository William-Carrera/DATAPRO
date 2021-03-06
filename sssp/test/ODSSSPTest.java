package test;

import org.junit.Test;

import alg.DijkstraSSSP;

public class ODSSSPTest extends SSSPTest {

    protected void reset() {
        ssspAlg = new DijkstraSSSP(true);
    } 

    @Test(timeout=55000)
    public void tooBigForBF() {
        runSSSP("tooBigForBF",0, 46918.84);
    }
    @Test
    public void wikipedia() {
        runSSSP("simple-english-wikipedia",73621, 5993786.0);
    }

}
