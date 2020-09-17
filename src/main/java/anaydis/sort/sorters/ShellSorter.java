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
//    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
//        for (int gap = list.size()/3; gap >= 1; gap /= 3) {
//            hSorter.sort(comparator, list, gap);
//        }
//    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int h;
        for (h = 1; h <= (list.size())/9; h = 3*h+1);
        for (h = 1; h >= 1; h = 3*h + 1) {
            hSorter.sort(comparator, list, h);
        }
    }

    public <T> void sort(@NotNull Comparator<T> comparator,@NotNull List<T> list, int[] sequence) {
        for (int j : sequence) {
            int h = j;
            for (; h <= (list.size()) / 9; h = 3 * h + 1) ;
            for (h = 1; h >= 1; h = 3 * h + 1) {
                for (int z = h; z < list.size(); z++) {
                    for (int i = z - h; i >= 0; i -= h) {
                        if (greater(comparator, list, i + h, i)) break;
                        swap(list, i + h, i);
                    }

                }
            }
        }

        }







    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SHELL;
    }
}
