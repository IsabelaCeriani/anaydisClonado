package anaydis.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class SelectionSorter extends AbstractSorter {

    public SelectionSorter() {
        this.sorterType = getType();
    }

    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int min;
        for (int i = 0; i < list.size(); i++) {
            min = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (greater(comparator, list, min, j)) {
                    min = j;
                }
            }

                swap(list, i, min);
            }

        }




    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.SELECTION;
    }
}
