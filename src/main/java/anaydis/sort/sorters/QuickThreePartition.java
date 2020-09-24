package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickThreePartition extends AbstractSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
            sort(comparator, list, 0, list.size()-1);
    }



    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right){
        if (right<=left) return;

        int lIndex = left;
        int rIndex = right;
        int i = left+1;


        while (i <= rIndex) {
            if (greater(comparator, list, left, i)) {

                swap(list, i++, lIndex++);
            }
            else  if (greater(comparator, list, i, left)){
                swap(list, rIndex--, i);
            }else {
                i++;
            }
        }


        sort(comparator, list, left, lIndex-1);
        sort(comparator, list, rIndex+1, right);


    }




    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_THREE_PARTITION;
    }
}
