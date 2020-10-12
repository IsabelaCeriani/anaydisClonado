package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickThreePartition extends QuickSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
            quickSort(comparator, list, 0, list.size()-1);
    }



    public <T> int partition (@NotNull Comparator<T> comparator, @NotNull List<T> list, int low, int high) {
        int pivot = high;
        int i = (low - 1);

        for (int j = low; j < high ; j++){
            if (greater(comparator, list, pivot, j)) {
                i++;
                swap(list, j, i); }
        }

        swap(list, i+1, high);
        return (i + 1);
    }



    <T> void quickSort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int low, int high) {
        if (low < high) {
            int pi = partition(comparator, list, low, high);
            quickSort(comparator, list, low, pi - 1);
            quickSort(comparator, list, pi + 1, high);
        }
    }




    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_THREE_PARTITION;
    }


}
