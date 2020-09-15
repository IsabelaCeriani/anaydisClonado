package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class HSorter extends AbstractSorter {




//    public <T> void sort(Comparator<T> comparator, List<T> list,int l, int r, int h) {
//        for (int i = l + h; i < r; i++) {
//            for (int j = i; j >=l+h ; j -=h) {
//                if (greater(comparator, list, j-h, j)) {
//                    swap(list, j, j - h);
//                }
//            }
//
//
//        }
//
//    }

    public <T> void sort(@NotNull Comparator<T> comparator,@NotNull List<T> list, int gap) {
        for (int j = gap; j < list.size(); j++) {
            for (int i = j - gap; i >= 0; i -= gap) {
                if (greater(comparator, list, i + gap, i)) break;
                swap(list, i + gap, i);
            }

        }
    }


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
            sort(comparator, list, 1);

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.H;
    }




}
