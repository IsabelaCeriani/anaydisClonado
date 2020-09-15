package anaydis.sort.sorters;


import anaydis.sort.sorters.AbstractSorter;
import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickSorter  extends AbstractSorter {

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {
        if(right <= left) return;
        int i = partition(comparator, list, left, right);
        sort(comparator, list, left, i - 1);
        sort(comparator, list, i + 1, right);

    }
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int right = list.size()-1;
        int left = 0;
        sort(comparator, list, left, right);
    }








    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK;
    }
}
