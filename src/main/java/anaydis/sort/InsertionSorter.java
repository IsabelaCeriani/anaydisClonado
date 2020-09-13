package anaydis.sort;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;


import java.util.Comparator;
import java.util.List;

public class InsertionSorter extends AbstractSorter {

    public InsertionSorter() {
        this.sorterType = getType();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if(greater(comparator, list, j-1, j)) {
                    swap(list, j, j -1);
                } else{
                    break;
                }
            }
        }
    }


    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.INSERTION;
    }
}
