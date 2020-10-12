package anaydis.sort;

import anaydis.sort.quijote.OccurrencesCounter;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestQuijote {

    OccurrencesCounter occurrencesCounter = new OccurrencesCounter();

    public TestQuijote() throws FileNotFoundException {
    }

//    @Test
//    public void testThatitCounts() throws IOException {
//        occurrencesCounter.count();
//        Integer ocurrencias  = (Integer) occurrencesCounter.getOccurrences().get("y");
//        Assert.assertTrue(ocurrencias > 6);
//    }

}
