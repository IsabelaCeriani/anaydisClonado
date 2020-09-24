package anaydis.sort.benchmarks;


import anaydis.sort.SorterProviderClass;
import anaydis.sort.SorterType;
import anaydis.sort.dataSetGenerators.IntegerDataSetGenerator;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.listeners.OrderSorterListener;
import anaydis.sort.listeners.TimePerformanceListener;
import anaydis.sort.sorters.QuickCutOff;
import anaydis.sort.sorters.ShellSorter;


import java.util.Comparator;
import java.util.List;

public class BenchResultsGenerator {

    final SorterProviderClass sorterProviderClass = new SorterProviderClass();
    final IntegerDataSetGenerator integerDataSetGenerator = new IntegerDataSetGenerator();

    Comparator<Integer> integerComparator = integerDataSetGenerator.getComparator();


    public  BenchResult createBenchResult(int nSize, DataArrangement dataArrangement, int timesExecuted, SorterType sorterType){
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        TimePerformanceListener timePerformanceListener = new TimePerformanceListener();
        final List<Integer> integers = integerDataSetGenerator.createRandom(nSize);
        ObservableSorter observableSorter = (ObservableSorter) sorterProviderClass.getSorterForType(sorterType);

        observableSorter.addSorterListener(orderSorterListener);


        int [] orderPerformance = new int[timesExecuted];

        int counter = 0;
        while(counter <timesExecuted){
            timePerformanceListener.start();
            observableSorter.sort(integerComparator, integers);
            orderPerformance[counter] = orderSorterListener.getOrder();
            timePerformanceListener.setTime();
            timePerformanceListener.reset();
            counter++;
        }

        double timePerformance = timePerformanceListener.getTime();

        observableSorter.removeSorterListener(orderSorterListener);
        observableSorter.removeSorterListener(timePerformanceListener);

        return new BenchResult(nSize, timesExecuted, dataArrangement, sorterType, calculateAverage(orderPerformance), timePerformance);
    }

    public  BenchResult createBenchResultForHIncrement(int nSize, DataArrangement dataArrangement, int timesExecuted, int[] h){
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        TimePerformanceListener timePerformanceListener = new TimePerformanceListener();


        final List<Integer> integers = integerDataSetGenerator.createRandom(nSize);
        ShellSorter observableSorter =  (ShellSorter) sorterProviderClass.getSorterForType(SorterType.SHELL);

        observableSorter.addSorterListener(orderSorterListener);

        int [] orderPerformance = new int[timesExecuted];

        int counter = 0;

        while(counter <timesExecuted){
            timePerformanceListener.start();
            observableSorter.sort(integerComparator, integers, h);
            orderPerformance[counter] = orderSorterListener.getOrder();
            timePerformanceListener.setTime();
            timePerformanceListener.reset();
            counter++;
        }

        double timePerformance = timePerformanceListener.getTime();

        observableSorter.removeSorterListener(orderSorterListener);
        observableSorter.removeSorterListener(timePerformanceListener);

        return new HBenchResult(nSize, timesExecuted, dataArrangement, calculateAverage(orderPerformance), timePerformance, h);
    }

    public int calculateAverage(int [] results){
        int average = 0;
        for (int result: results) {
            average+= result;
        }
        return average/results.length;
    }

    public  BenchResult createBenchResultForMPerformance(int nSize, DataArrangement dataArrangement, int timesExecuted, int M){
        TimePerformanceListener timePerformanceListener = new TimePerformanceListener();
        final List<Integer> integers = integerDataSetGenerator.createRandom(nSize);
        QuickCutOff sorter = (QuickCutOff) sorterProviderClass.getSorterForType(SorterType.QUICK_CUT);
        sorter.setCutIndex(M);

        int counter = 0;
        while(counter <timesExecuted){
            timePerformanceListener.start();
            sorter.sort(integerComparator, integers);
            timePerformanceListener.setTime();
            timePerformanceListener.reset();
            counter++;
        }

        double timePerformance = timePerformanceListener.getTime();

        return new QuickCutOffBenchResult(nSize, timesExecuted, dataArrangement, 0, timePerformance, M);
    }


}
