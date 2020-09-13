package anaydis.sort;

import anaydis.sort.SorterType;
import anaydis.sort.AbstractSorter;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class HSorter extends AbstractSorter {


    public <T> void sort(Comparator<T> comparator, List<T> list){
        sort(comparator, list, 1);
    }



    /**
     * H-Sort list. Basically a BubbleSort in sets of elements separated by h
     */
    public <T> void sort(Comparator<T> comparator, List<T> list, int h) {
        int l = 0;
        for (int i = l + h; i < list.size(); i++) {
            for (int j = i; j >0 ; j -=h) {
                if (greater(comparator, list, j-h, j)) {
                    swap(list, j, j - h);
                }
            }


        }

    }



    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.H;
    }




}
