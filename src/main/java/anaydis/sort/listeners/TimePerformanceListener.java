package anaydis.sort.listeners;

import anaydis.sort.gui.SorterListener;

import java.util.ArrayList;
import java.util.List;

public class TimePerformanceListener implements SorterListener {

    private double startTime;
    private List<Double> timesCalculated = new ArrayList<>();

    @Override
    public void box(int from, int to) {

    }

    @Override
    public void copy(int from, int to, boolean copyToAux) {

    }

    @Override
    public void equals(int i, int j) {

    }

    @Override
    public void greater(int i, int j) {

    }

    @Override
    public void swap(int i, int j) {

    }


    public void start(){
         startTime = System.currentTimeMillis();
    }

    //adds time taken for 1 run to timesCalculated (in milli seconds)
    public void setTime(){
        double time = (System.currentTimeMillis()-startTime);
        timesCalculated.add(time);
    }

    //return the average time taken for n amounts of runs. (in seconds)
    public double getTime(){
        double average = 0;
        double timesRunned = 0;
        for (Double time: timesCalculated) {
            average+=time;
            timesRunned++;
        }

        return average/timesRunned;
    }

    //sets start time to 0
    public void reset(){
        startTime = 0;
    }
}
