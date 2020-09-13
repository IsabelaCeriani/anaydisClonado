package anaydis.sort.benchmarks;

import anaydis.sort.SorterType;

public class BenchResult {

    int dataSize;
    int timesExecuted;
    DataArrangement dataArrangement;
    SorterType sorterType;
    int orderPerformance;
    int timePerformance;


    public BenchResult(int dataSize, int timesExecuted, DataArrangement dataArrangement, SorterType sorterType, int orderPerformance, int timePerformance) {
        this.dataSize = dataSize;
        this.timesExecuted = timesExecuted;
        this.dataArrangement = dataArrangement;
        this.sorterType = sorterType;
        this.orderPerformance = orderPerformance;
        this.timePerformance = timePerformance;
    }
}
