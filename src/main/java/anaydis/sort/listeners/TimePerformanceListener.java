package anaydis.sort.listeners;

import anaydis.sort.gui.SorterListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TimePerformanceListener implements SorterListener {

    private double startTime;
    private Set<Double> timesCalculated = new HashSet<Double>();


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
        double total = 0;
        double timesRunned = 0;
        for (Double time: timesCalculated) {
            total+=time;
            timesRunned++;
        }
        wipeData();

        return (total/timesRunned);
    }

    //sets start time to 0
    public void reset(){

        startTime = 0;
    }

    //resets all data stored in the listener
    public void wipeData(){
        reset();
        for(Double time : timesCalculated) time = null;
    }

    public double getStartTime() {
        return startTime;
    }
}
