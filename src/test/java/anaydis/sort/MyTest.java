package anaydis.sort;
import anaydis.sort.benchmarks.BenchResultsGenerator;
import anaydis.sort.listeners.OrderSorterListener;
import anaydis.sort.sorters.QuickCutOff;
import anaydis.sort.sorters.QuickSorter;
import anaydis.sort.sorters.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyTest extends SorterTest {

    BubbleSorter bubbleSorter = new BubbleSorter();
    SelectionSorter selectionSorter = new SelectionSorter();
    InsertionSorter insertionSorter = new InsertionSorter();
    HSorter hSorter = new HSorter();
    ShellSorter shellSorter = new ShellSorter(hSorter);
    QuickSorter quickSorter = new QuickSorter();
    QuickCutOff quickCutOff = new QuickCutOff(insertionSorter, 6);
    QuickThreePartition quickThreePartition = new QuickThreePartition();
    MergeTopDown mergeTopDown = new MergeTopDown();
    MergeBottomUp mergeBottomUp = new MergeBottomUp();

    DataSetGenerator<Integer> integerDataSetGenerator=  createIntegerDataSetGenerator();
    Comparator<Integer> integerComparator = integerDataSetGenerator.getComparator();

    DataSetGenerator<String> stringDataSetGenerator=  createStringDataSetGenerator();
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
        insertionSorter.addSorterListener(orderSorterListener);
        insertionSorter.greater(integerComparator, randomIntegerList, 3, 4);
        insertionSorter.greater(integerComparator, randomIntegerList, 3, 4);
        insertionSorter.greater(integerComparator, randomIntegerList, 3, 4);
        insertionSorter.swap( randomIntegerList, 3, 4);

        assertThat(orderSorterListener.getOrder()).isEqualTo(4);
        insertionSorter.removeSorterListener(orderSorterListener);

    }

    @Test
    public void testOrderSorterListensSort(){
        OrderSorterListener orderSorterListener = new OrderSorterListener();
        List<Integer> descending = integerDataSetGenerator.createDescending(100);
        insertionSorter.addSorterListener(orderSorterListener);
        insertionSorter.sort(integerComparator, descending);

        assertThat(orderSorterListener.getOrder()).isGreaterThan(100);

        insertionSorter.removeSorterListener(orderSorterListener);

    }
    @Test
    public void testCalculateAverge(){
        int[] integers = {10, 4};
        BenchResultsGenerator benchResultsGenerator = new BenchResultsGenerator();


        assertThat(benchResultsGenerator.calculateAverage(integers)).isEqualTo(7);

    }


    @Test
    public void testShellSorterAverageCaseWithInteger(){
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(100);
        shellSorter.sort(integerComparator, randomIntegerList);

        assertThat(randomIntegerList).isSorted();

    }


    @Test
    public void testShellSorterAverageCaseWithString(){
        List<String> randomStringList = stringDataSetGenerator.createRandom(36);
        shellSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();

    }
    /** Test H with different gap Integer generator. */
    @Test
    public void testHWithIntegerGenerator() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(36);
        hSorter.sort(stringComparator, randomStringList, 1);
        assertThat(randomStringList).isSorted();
    }
    /** Test H with different gap Integer generator. */
    @Test
    public void testHGappedWithIntegerGenerator() {
        int[] incs = { 1391376, 463792, 198768, 86961, 33936, 13776, 4592, 1968, 861, 336, 112, 48, 21, 7, 3, 1};
        List<Integer> randomInteger = integerDataSetGenerator.createRandom(10);
        shellSorter.sort(integerComparator, randomInteger, incs);
        assertThat(randomInteger).isSorted();
    }

    @Test
    public void testShellSorterBestCaseWithString(){
        List<String> randomStringList = stringDataSetGenerator.createAscending(44);
        shellSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();

    }



    @Test
    public void testShellSorterWorstCaseWithString(){
        List<String> randomStringList = stringDataSetGenerator.createDescending(10);
        shellSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();

    }

    @Test
    public void testQuickSorterAverageCaseWithString(){
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        quickSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();

    }


    @Test
    public void testQuickSorterAverageCaseWithInteger(){
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        quickSorter.sort(integerComparator, randomIntegerList);

        assertThat(randomIntegerList).isSorted();

    }

    @Test
    public void testQuickCutoffSorterAverageCaseWithInteger(){
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        quickCutOff.sort(integerComparator, randomIntegerList);

        assertThat(randomIntegerList).isSorted();

    }
    @Test
    public void testBubbleBestCaseInteger() {
        List<Integer> ascendingIntegerList = integerDataSetGenerator.createAscending(500);
        bubbleSorter.sort(integerComparator, ascendingIntegerList);


        assertThat(ascendingIntegerList).isSorted();
    }

    /** Tests greater with String*/
    @Test
    public void testGreaterString(){
        List<String> listToTest = new ArrayList<>();
        listToTest.add("a");
        listToTest.add("b");

        Assert.assertTrue(bubbleSorter.greater(stringComparator, listToTest, 1, 0));

    }

    /** Tests greater with Integer*/
    @Test
    public void testSwapString(){
        List<String> listToTest = new ArrayList<>();
        listToTest.add("a");
        listToTest.add("b");
        bubbleSorter.swap(listToTest, 0, 1);

        List<String> correctList = new ArrayList<>();
        correctList.add("b");
        correctList.add("a");

        assertThat(listToTest).isEqualTo(correctList);
    }

    /** Test best case for BubbleSorter with a StringList. */
    @Test
    public void testBubbleBestCaseString() {
        List<String> ascendingStringList = stringDataSetGenerator.createAscending(5000);
        bubbleSorter.sort(stringComparator, ascendingStringList);

        assertThat(ascendingStringList).isSorted();
    }


    /** Test worst case for BubbleSorter with an IntegerList.. */
    @Test
    public void testBubbleWorstCaseInteger() {
        List<Integer> descendingIntegerList = integerDataSetGenerator.createDescending(5000);
        bubbleSorter.sort(integerComparator, descendingIntegerList);

        assertThat(descendingIntegerList).isSorted();
    }

    /** Test worst case for BubbleSorter with an StringList.. */
    @Test
    public void testBubbleWorstCaseString() {
        List<String> descendingStringList = stringDataSetGenerator.createDescending(10);
        bubbleSorter.sort(stringComparator, descendingStringList);
        assertThat(descendingStringList).isSorted();
    }

    /** Test average case for BubbleSorter with an IntegerList... */
    @Test
    public void testBubbleAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(5000);
        bubbleSorter.sort(integerComparator, randomIntegerList);

        assertThat(randomIntegerList).isSorted();
    }
    /** Test average case for BubbleSorter with a StringList... */
    @Test
    public void testBubbleAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        bubbleSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();

    }

    /** Test best case for SelectionSorter with an IntegerList.... */
    @Test
    public void testSelectionBestCaseInteger() {
        List<Integer> ascendingIntegerList = integerDataSetGenerator.createAscending(5000);
        selectionSorter.sort(integerComparator, ascendingIntegerList);

        assertThat(ascendingIntegerList);
    }
    /** Test best case for SelectionSorter with an StringList.... */
    @Test
    public void testSelectionBestCaseString() {
        List<String> ascendingStringList = stringDataSetGenerator.createAscending(10);
        selectionSorter.sort(stringComparator, ascendingStringList);
        assertThat(ascendingStringList).isSorted();
    }

    /** Test worst case for SelectionSorter with an IntegerList.... */
    @Test
    public void testSelectionWorstCaseInteger() {
        List<Integer> descendingIntegerList = integerDataSetGenerator.createDescending(5000);
        selectionSorter.sort(integerComparator, descendingIntegerList);

        assertThat(descendingIntegerList).isSorted();

    }
    /** Test worst case for SelectionSorter with a StringList.... */
    @Test
    public void testSelectionWorstCaseString() {
        List<String> descendingStringList = stringDataSetGenerator.createDescending(10);
        selectionSorter.sort(stringComparator, descendingStringList);
        assertThat(descendingStringList).isSorted();
    }

    /** Test average case for SelectionSorter with an IntegerList..... */
    @Test
    public void testSelectionAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(5000);
        selectionSorter.sort(integerComparator, randomIntegerList);

        assertThat(randomIntegerList).isSorted();
    }
    /** Test average case for SelectionSorter with a StringList..... */
    @Test
    public void testSelectionAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        selectionSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();
    }

    /** Test best case for InsertionSorter with an IntegerList...... */
    @Test
    public void testInsertionBestCaseInteger() {
        List<Integer> ascendingIntegerList = integerDataSetGenerator.createAscending(5000);
        insertionSorter.sort(integerComparator, ascendingIntegerList);

        assertThat(ascendingIntegerList).isSorted();
    }
    /** Test best case for InsertionSorter with a StringList....... */
    @Test
    public void testInsertionBestCaseString() {
        List<String> ascendingStringList = stringDataSetGenerator.createAscending(10);
        insertionSorter.sort(stringComparator, ascendingStringList);
        assertThat(ascendingStringList).isSorted();
    }

    /** Test worst case for InsertionSorter with an IntegerList...... */
    @Test
    public void testInsertionWorstCaseInteger() {
        List<Integer> descendingIntegerList = integerDataSetGenerator.createDescending(5000);
        insertionSorter.sort(integerComparator,descendingIntegerList);

        assertThat(descendingIntegerList).isSorted();
    }
    /** Test worst case for InsertionSorter with a StringList....... */
    @Test
    public void testInsertionWorstCaseString() {
        List<String> descendingStringList = stringDataSetGenerator.createDescending(10);
        insertionSorter.sort(stringComparator, descendingStringList);
        assertThat(descendingStringList).isSorted();

    }

    /** Test average case for InsertionSorter with an IntegerList.... */
    @Test
    public void testInsertionAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        insertionSorter.sort(integerComparator, randomIntegerList);


        assertThat(randomIntegerList).isSorted();
    }
    /** Test average case for InsertionSorter with a StringList...... */
    @Test
    public void testInsertionAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        insertionSorter.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();
    }
    @Test
    public void testQuickThreePartitionAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        quickThreePartition.sort(integerComparator, randomIntegerList);


        assertThat(randomIntegerList).isSorted();
    }
    @Test
    public void testQuickThreePartitionAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        quickThreePartition.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();
    }

    @Test
    public void testMergeTopDownPartitionAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        mergeTopDown.sort(integerComparator, randomIntegerList);


        assertThat(randomIntegerList).isSorted();
    }
    /** Test average case for InsertionSorter with a StringList...... */
    @Test
    public void testMergeTopDownThreePartitionAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        mergeTopDown.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();
    }

    @Test
    public void testMergeBottomUpPartitionAverageCaseInteger() {
        List<Integer> randomIntegerList = integerDataSetGenerator.createRandom(10);
        mergeBottomUp.sort(integerComparator, randomIntegerList);


        assertThat(randomIntegerList).isSorted();
    }
    /** Test average case for InsertionSorter with a StringList...... */
    @Test
    public void testMergeBottomUpThreePartitionAverageCaseString() {
        List<String> randomStringList = stringDataSetGenerator.createRandom(10);
        mergeBottomUp.sort(stringComparator, randomStringList);
        assertThat(randomStringList).isSorted();
    }

}
