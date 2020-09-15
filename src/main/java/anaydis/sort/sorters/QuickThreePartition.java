package anaydis.sort.sorters;

import anaydis.sort.sorters.AbstractSorter;
import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickThreePartition extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_THREE_PARTITION;
    }
}
