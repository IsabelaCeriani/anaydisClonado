package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class MergeBottomUp extends AbstractSorter{
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
            sort(comparator, list, 0, list.size()-1);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {
        for (int middle = 1; middle <= right-left; middle*=2){
            final int doubledMiddle = middle*2;
            for (int low = left; low <= right-middle; low += doubledMiddle){
                final int high = Math.min(low-left+doubledMiddle-1, right);
                mergeInPlace(comparator, list, low, low+middle-1, high);
            }
        }
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.MERGE_BOTTOM_UP;
    }
}
