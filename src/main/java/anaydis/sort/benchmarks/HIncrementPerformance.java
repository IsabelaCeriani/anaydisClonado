package anaydis.sort.benchmarks;

import anaydis.sort.SorterProviderClass;
import anaydis.sort.SorterType;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.listeners.OrderSorterListener;

public class HIncrementPerformance {


    public static void main(String[] args) {

        BenchResultsGenerator benchResultsGenerator = new BenchResultsGenerator();
        final SorterProviderClass sorterProviderClass = new SorterProviderClass();
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        final ObservableSorter hSorter = (ObservableSorter) sorterProviderClass.getSorterForType(SorterType.H);
        hSorter.addSorterListener(orderSorterListener);

        int[] firstIncrements = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] secondIncrements = {1, 4, 13, 40, 121, 364, 1093, 3280 ,9841};

        BenchResult benchResult1 = benchResultsGenerator.createBenchResultForHIncrement(100, DataArrangement.RANDOM, 20,firstIncrements);
        BenchResult benchResult2 = benchResultsGenerator.createBenchResultForHIncrement(1000, DataArrangement.RANDOM, 20,firstIncrements);
        BenchResult benchResult3 = benchResultsGenerator.createBenchResultForHIncrement(10000, DataArrangement.RANDOM, 20,firstIncrements);

        BenchResult benchResult4 = benchResultsGenerator.createBenchResultForHIncrement(100, DataArrangement.RANDOM, 20,secondIncrements);
        BenchResult benchResult5 = benchResultsGenerator.createBenchResultForHIncrement(1000, DataArrangement.RANDOM, 20,secondIncrements);
        BenchResult benchResult6 = benchResultsGenerator.createBenchResultForHIncrement(10000, DataArrangement.RANDOM, 20,secondIncrements);

        System.out.println("Bench result 1: \n" + benchResult1.toString() + "\n\n" +
                            "Bench result 2: \n" + benchResult2 + "\n\n" +
                             "Bench result 3: \n" + benchResult3.toString());




        // h =1
//        BenchResult benchResult = benchResultsGenerator.createBenchResult(100, DataArrangement.RANDOM, 20, SorterType.H);
//        BenchResult benchResult2 = benchResultsGenerator.createBenchResult(1000, DataArrangement.RANDOM, 20, SorterType.H);
//        BenchResult benchResult3 = benchResultsGenerator.createBenchResult(10000, DataArrangement.RANDOM, 20, SorterType.H);





    }
}
