package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickMedianOfThree extends QuickSorter {

    private final int medianValue;
    private final  InsertionSorter insertionSorter;

    public QuickMedianOfThree(InsertionSorter insertionSorter, int medianValue) {
        this.medianValue = medianValue;
        this.insertionSorter = insertionSorter;
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        hySort(comparator, list, 0, list.size()-1);

    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        if (r-l <= medianValue) return;
        swap(list, (l+r)/2, r-1);
        checkSwap(list,comparator, l, r-1);
        checkSwap(list,comparator, l, r);
        checkSwap(list,comparator, r-1, r);
        int i = partition(comparator, list, l+1, r-1);
        sort(comparator, list, l, i-1);
        sort(comparator, list, i+1, r);
    }



    public <T> void hySort(Comparator<T> comparator, List<T> list, int l, int h)
    {
        sort(comparator, list, l, h);
        insertionSorter.sort(comparator, list);
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_MED_OF_THREE;
    }
}
