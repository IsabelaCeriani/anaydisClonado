package anaydis.sort;

import anaydis.sort.listeners.TimePerformanceListener;
import org.assertj.core.data.Percentage;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class TimePerformanceTest {

    TimePerformanceListener timePerformanceListener = new TimePerformanceListener();


    @Test
    public void testReset(){
        timePerformanceListener.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timePerformanceListener.setTime();
        timePerformanceListener.reset();

        assertThat(timePerformanceListener.getStartTime()).isEqualTo(0);


    }


    @Test
    public void getTimeTester(){
        timePerformanceListener.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timePerformanceListener.setTime();
        timePerformanceListener.reset();

        timePerformanceListener.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timePerformanceListener.setTime();
        double time = timePerformanceListener.getTime();

        double expected = (1000+1000)/2;

        assertThat(time).isCloseTo(expected, withinPercentage(5 ));



    }

    @Test
    public void testSetTime(){
        timePerformanceListener.setTime();
    }
}
