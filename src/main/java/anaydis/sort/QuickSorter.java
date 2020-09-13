package anaydis.sort;


import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickSorter  extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK;
    }
}
