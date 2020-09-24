package anaydis.sort.benchmarks;

import anaydis.sort.SorterType;

public class BenchResult {

    protected int dataSize;
    protected int timesExecuted;
    protected DataArrangement dataArrangement;
    protected SorterType sorterType;
    protected int orderPerformance;
    protected double timePerformance;


    public BenchResult(int dataSize, int timesExecuted, DataArrangement dataArrangement, SorterType sorterType, int orderPerformance, double timePerformance) {
        this.dataSize = dataSize;
        this.timesExecuted = timesExecuted;
        this.dataArrangement = dataArrangement;
        this.sorterType = sorterType;
        this.orderPerformance = orderPerformance;
        this.timePerformance = timePerformance;
    }



    public String toString(){
        return "nSize= " + dataSize + "\n" + "Times executed= " + timesExecuted + "\n" + "Data arrangement= " +
                dataArrangement + "\n" + "Sorter type= " + sorterType + "\n" + "Order= " + orderPerformance + "\n"
                + "Time= " + timePerformance;
    }

    public int calculateAverage(int [] results){
        int average = 0;
        for (int result: results) {
            average+= result;
        }
        return average/results.length;
    }


}
