package anaydis.benchmarks.sortersBenchmarks;

import anaydis.sort.SorterType;

public class HBenchResult extends BenchResult {

    int[] hIncrement;
    public HBenchResult(int nSize, int timesExecuted, DataArrangement dataArrangement, int orderPerformance, double timePerformance, int[] h) {
        super(nSize, timesExecuted, dataArrangement, SorterType.SHELL, orderPerformance, timePerformance);
        this.hIncrement = h;
    }

    public String toString(){
        return "nSize: " + dataSize + "\n" + "Times executed: " + timesExecuted + "\n" + "Data arrangement: " +
                dataArrangement + "\n" + "Sorter type: " + sorterType + "\n" + "Order: " + orderPerformance + "\n"
                + "Time: " + timePerformance + "\n" + "H sequence: " + arrayToString(hIncrement);
    }

    public String arrayToString(int[] array){
        String string = "{ ";
        for (int i = 0; i < array.length-1; i++) {
            string += array[i] + ", ";
        }

        return string+= array[array.length-1]+" }";
    }

}
