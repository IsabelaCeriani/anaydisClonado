package anaydis.sort.sortersTesters;

import anaydis.sort.SorterType;
import anaydis.sort.StringDataSetGenerator;
import anaydis.benchmarks.sortersBenchmarks.BenchResultsGenerator;
import anaydis.sort.dataSetGenerators.IntegerDataSetGenerator;
import anaydis.sort.listeners.OrderSorterListener;
import anaydis.sort.sorters.BubbleSorter;
import anaydis.sort.sorters.SorterProviderClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractSorterTester {

    SorterProviderClass sorterProviderClass = new SorterProviderClass();
    BubbleSorter bubbleSorter = (BubbleSorter) sorterProviderClass.getSorterForType(SorterType.BUBBLE);

    IntegerDataSetGenerator integerDataSetGenerator = new IntegerDataSetGenerator();
    StringDataSetGenerator stringDataSetGenerator = new StringDataSetGenerator();
    Comparator<Integer> integerComparator = integerDataSetGenerator.getComparator();
    Comparator<String> stringComparator = stringDataSetGenerator.getComparator();

    OrderSorterListener orderSorterListener = new OrderSorterListener();



    /** Tests sorter greater with integers*/
    @Test
    public void testGreaterInteger(){
        List<Integer> listToTest = new ArrayList<>();
        listToTest.add(0);
        listToTest.add(1);

        Assert.assertTrue(bubbleSorter.greater(integerComparator, listToTest, 1, 0));

    }

    /** Tests sorter  swap with integers */
    @Test
    public void testSwapInteger(){
        List<Integer> listToTest = new ArrayList<>();
        listToTest.add(0);
        listToTest.add(1);
        bubbleSorter.swap(listToTest, 0, 1);

        List<Integer> correctList = new ArrayList<>();
        correctList.add(1);
        correctList.add(0);

        assertThat(listToTest).isEqualTo(correctList);

    }


    @Test
    public void listenerGreater(){
        orderSorterListener.greater(2,3);
        assertThat(orderSorterListener.getGreaters()).isEqualTo(1);
    }
    @Test
    public void listenerSwap(){
        orderSorterListener.swap(2,3);
        assertThat(orderSorterListener.getSwaps()).isEqualTo(1);
    }

    @Test
    public void orderSorterListens(){
        List<Integer> randomIntegerList = integerDataSetGenerator.createDescending(100);
        bubbleSorter.addSorterListener(orderSorterListener);
        bubbleSorter.greater(integerComparator, randomIntegerList, 3, 4);
        bubbleSorter.greater(integerComparator, randomIntegerList, 3, 4);
        bubbleSorter.greater(integerComparator, randomIntegerList, 3, 4);
        bubbleSorter.swap( randomIntegerList, 3, 4);

        assertThat(orderSorterListener.getOrder()).isEqualTo(4);
        bubbleSorter.removeSorterListener(orderSorterListener);

    }

    @Test
    public void testOrderSorterListensSort(){
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        List<Integer> descending = integerDataSetGenerator.createDescending(100);
        bubbleSorter.addSorterListener(orderSorterListener);
        bubbleSorter.sort(integerComparator, descending);

        assertThat(orderSorterListener.getOrder()).isGreaterThan(100);

        bubbleSorter.removeSorterListener(orderSorterListener);

    }
    @Test
    public void testCalculateAverge(){
        int[] integers = {10, 4};
        BenchResultsGenerator benchResultsGenerator = new BenchResultsGenerator();


        assertThat(benchResultsGenerator.calculateAverage(integers)).isEqualTo(7);

    }

    /** Tests greater with String*/
    @Test
    public void testGreaterString(){
        List<String> listToTest = new ArrayList<>();
        listToTest.add("a");
        listToTest.add("b");

        Assert.assertTrue(bubbleSorter.greater(stringComparator, listToTest, 1, 0));

    }

}
