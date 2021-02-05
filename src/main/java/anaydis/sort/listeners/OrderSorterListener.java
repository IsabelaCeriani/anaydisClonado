package anaydis.sort.listeners;

import anaydis.sort.gui.SorterListener;

public class OrderSorterListener implements SorterListener {


    private int greaters;
    private int swaps;

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
            greaters++;
    }

    @Override
    public void swap(int i, int j) {
        swaps++;
    }

    public int getOrder(){
        return greaters + swaps;
    }

    public int getGreaters() {
        return greaters;
    }

    public int getSwaps() {
        return swaps;
    }

    public void reset(){
        greaters=0;
        swaps = 0;
    }
}
