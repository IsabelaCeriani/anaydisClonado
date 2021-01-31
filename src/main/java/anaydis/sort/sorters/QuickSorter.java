package anaydis.sort.sorters;


import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickSorter  extends AbstractSorter {

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {
        if(right <= left) return;
        int i = partition(comparator, list, left, right);
        sort(comparator, list, left, i - 1);
        sort(comparator, list, i + 1, right);

    }
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int right = list.size()-1;
        int left = 0;
        sort(comparator, list, left, right);
    }

    public<T> int partition(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {
        int i = left-1;
        int j = right;

        while(true) {
            while(greater(comparator, list, right,++i)){
                if (i == right)
                    break;
            }
            while(greater(comparator, list, --j,right )) {
                if (j == left)
                    break;
            }
            if (i >= j)
                break;

            swap(list, i, j);

        }
        swap(list, i, right);
        return i;
//        int pivot = right;
//        int i = left-1;
//
//        for (int j = left; j < right; j++) {
//            if (greater(comparator, list, pivot, j)) {
//                i++;
//
//                swap(list, i, j);
//
//            }
//        }
//
//        swap(list, i+1, right);
//
//
//        return i+1;



    }








    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK;
    }
}
