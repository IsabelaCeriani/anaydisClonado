package anaydis.benchmarks.sortersBenchmarks;

import anaydis.sort.SorterType;

public class QuickCutOffBenchResult extends BenchResult {

    int M;
    public QuickCutOffBenchResult(int nSize, int timesExecuted, DataArrangement dataArrangement, int orderPerformance, double timePerformance, int M) {
        super(nSize, timesExecuted, dataArrangement, SorterType.QUICK_CUT, orderPerformance, timePerformance);
        this.M = M;
    }

    public String toString(){
        return "nSize= " + dataSize + "\n" + "Times executed= " + timesExecuted + "\n" + "Data arrangement= " +
                dataArrangement + "\n" + "Sorter type= " + sorterType + "\n" + "Order= " + orderPerformance + "\n"
                + "Time= " + timePerformance + "\n" + "M value = " + M;
    }

}
