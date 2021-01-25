package anaydis.sort.benchmarkTesters;

import anaydis.sort.SorterType;
import anaydis.sort.benchmarks.sortersBenchmarks.BenchResult;
import anaydis.sort.benchmarks.sortersBenchmarks.BenchResultsGenerator;
import anaydis.sort.benchmarks.sortersBenchmarks.DataArrangement;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.listeners.OrderSorterListener;
import anaydis.sort.sorters.SorterProviderClass;

public class SorterPerformanceTesting {


    public static void main(String[] args) {

        BenchResultsGenerator benchResultsGenerator = new BenchResultsGenerator();
        final SorterProviderClass sorterProviderClass = new SorterProviderClass();
        OrderSorterListener orderSorterListener = new OrderSorterListener();

        final ObservableSorter hSorter = (ObservableSorter) sorterProviderClass.getSorterForType(SorterType.H);
        hSorter.addSorterListener(orderSorterListener);

        int[] firstIncrements = {1, 8, 23, 77, 281, 1073, 4193, 16577};
        int[] secondIncrements = {1, 4, 13, 40, 121, 364, 1093, 3280 ,9841};

//        BenchResult hbenchResult1 = benchResultsGenerator.createBenchResultForHIncrement(100, DataArrangement.RANDOM, 20,firstIncrements);
//        BenchResult hbenchResult2 = benchResultsGenerator.createBenchResultForHIncrement(1000, DataArrangement.RANDOM, 20,firstIncrements);
//        BenchResult hbenchResult3 = benchResultsGenerator.createBenchResultForHIncrement(10000, DataArrangement.RANDOM, 20,firstIncrements);
//
//        BenchResult hbenchResult4 = benchResultsGenerator.createBenchResultForHIncrement(100, DataArrangement.RANDOM, 20,secondIncrements);
//        BenchResult hbenchResult5 = benchResultsGenerator.createBenchResultForHIncrement(1000, DataArrangement.RANDOM, 20,secondIncrements);
//        BenchResult hbenchResult6 = benchResultsGenerator.createBenchResultForHIncrement(10000, DataArrangement.RANDOM, 20,secondIncrements);
//
//        System.out.println("Bench result 1: \n" + hbenchResult4.toString() + "\n\n" +
//                            "Bench result 2: \n" + hbenchResult5 + "\n\n" +
//                             "Bench result 3: \n" + hbenchResult6.toString());
//


        BenchResult mPerformance1 = benchResultsGenerator.createBenchResultForMPerformance(1000, DataArrangement.RANDOM, 20, 3);
//        BenchResult mPerformance2 = benchResultsGenerator.createBenchResultForMPerformance(10000, DataArrangement.RANDOM, 20, 7);
//        BenchResult mPerformance3 = benchResultsGenerator.createBenchResultForMPerformance(100000, DataArrangement.RANDOM, 20, 7);
//        BenchResult mPerformance4 = benchResultsGenerator.createBenchResultForMPerformance(1000000, DataArrangement.RANDOM, 20, 7);

        System.out.println("Bench result 1: \n" + mPerformance1.toString()
//                + "\n\n" +
//                            "Bench result 2: \n" + mPerformance2 + "\n\n" +
//                            "Bench result 3: \n" + mPerformance3.toString() + "\n\n"
                        //+
//                            "Bench result 4: \n" + mPerformance4.toString()
        );



    }
}
