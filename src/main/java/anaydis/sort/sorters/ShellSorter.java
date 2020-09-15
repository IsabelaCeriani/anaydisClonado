package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class ShellSorter extends AbstractSorter {

    HSorter hSorter;


    public ShellSorter(HSorter sorter) {
        hSorter = sorter;
    }





    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        for (int gap = list.size() / 3; gap >= 1; gap /= 3) {
            hSorter.sort(comparator, list, gap);
        }
    }




    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SHELL;
    }
}
