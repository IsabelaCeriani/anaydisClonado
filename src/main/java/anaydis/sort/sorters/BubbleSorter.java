package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BubbleSorter extends AbstractSorter {

    public BubbleSorter() {
        this.sorterType = getType();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        boolean isSorted = false;
        int lastUnsorted = list.size()-1;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                 if(greater(comparator,list, i, i+1)) {
                     swap(list, i, i + 1);
                     isSorted = false;
                 }
            }
            lastUnsorted--;

        }
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.BUBBLE;
    }
}
