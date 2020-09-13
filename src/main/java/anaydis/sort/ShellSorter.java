package anaydis.sort;

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
        int l = 0; //left
        int r = list.size(); //right

        for (int h = 1; h <= (r-l)/9 ; h= 3+h+1) {
            for ( ; h > 0; h /= 3) {
                hSorter.sort(comparator, list,h);
            }
        }

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SHELL;
    }
}
