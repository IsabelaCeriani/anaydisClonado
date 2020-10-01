package anaydis.sort.benchmarkTesters;

import anaydis.sort.SorterType;
import anaydis.sort.benchmarks.BenchResult;
import anaydis.sort.benchmarks.DataArrangement;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class BenchResultTester {

    int[] ints = {5,5,5};
//    (int dataSize, int timesExecuted, DataArrangement dataArrangement, SorterType sorterType, int orderPerformance, double timePerformance)
    BenchResult benchResult = new BenchResult(10, 1, DataArrangement.RANDOM, SorterType.QUICK_CUT, 3, 3);

    @Test
    public void testCalculateAverage(){
        int average = benchResult.calculateAverage(ints);
        assertThat(average).isEqualTo(5);
    }
}
