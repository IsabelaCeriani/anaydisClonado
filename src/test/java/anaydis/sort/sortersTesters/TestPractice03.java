package anaydis.sort.sortersTesters;


import anaydis.sort.SorterType;
import anaydis.sort.sortersTesters.SorterTest;
import org.junit.Test;

public class TestPractice03 extends SorterTest {

    /** Test H with Integer generator. */
    @Test
    public void testHWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 100);
    }
    @Test
    public void testQuickThreeWithIntegerGenerator() {
//        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
//        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
//        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }

    /** Test H with different gap Integer generator. */
    @Test
    public void testHGappedWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.H, 100);
    }

    /** Test H with String generator. */
    @Test public void testHWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.H, 10);
        testSorter(createStringDataSetGenerator(), SorterType.H, 50);
        testSorter(createStringDataSetGenerator(), SorterType.H, 100);
    }

    /** Test Shell with Integer generator. */
    @Test public void testShellWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.SHELL, 100);
    }

    /** Test Shell with String generator. */
    @Test public void testShellWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 10);
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 50);
        testSorter(createStringDataSetGenerator(), SorterType.SHELL, 100);
    }

    /** Test Quick with Integer generator. */
    @Test public void testQuickWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK, 100);
    }

    /** Test Quick with String generator. */
    @Test public void testQuickWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK, 100);
    }

    @Test public void testQuickNonRecursiveWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100);
    }

    @Test public void testQuickNonRecursiveWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_NON_RECURSIVE, 100);
    }
    /** Test QuickCutoff with Integer generator. */
    @Test public void testQuickCutWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_CUT, 100);
    }

    /** Test QuickCutoff with String generator. */
    @Test public void testQuickCutWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_CUT, 100);
    }

    /** Test QuickMedianOfThree with Integer generator. */
    @Test public void testQuickMedianOfThreeWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }

    /** Test QuickCutoff with String generator. */
    @Test public void testQuickMedianOfThreeCutWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 10);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 50);
        testSorter(createStringDataSetGenerator(), SorterType.QUICK_MED_OF_THREE, 100);
    }


    @Test public void testQuickThreePartitionWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.QUICK_THREE_PARTITION, 100);
    }

    @Test public void testQuickThreePartitionWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }


    /** Test QuickCutoff with String generator. */
    @Test public void testMergeTopDownCutWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }


    @Test public void testMergeTopDownWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_TOP_DOWN, 100);
    }

    /** Test QuickCutoff with String generator. */
    @Test public void testMergeBottomupOfThreeCutWithStringGenerator() {
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createStringDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }


    @Test public void testMergeBottomUpWithIntegerGenerator() {
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 10);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 50);
        testSorter(createIntegerDataSetGenerator(), SorterType.MERGE_BOTTOM_UP, 100);
    }

}
