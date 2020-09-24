package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeTopDown  extends AbstractSorter{
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size()-1);
    }

    <T> void sort(@NotNull Comparator<T> comparator,  List<T> list, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            sort(comparator, list, low, mid);
            sort(comparator, list, mid + 1, high);
            mergeInPlace(comparator, list, low, mid, high);
        }
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.MERGE_TOP_DOWN;
    }
}
