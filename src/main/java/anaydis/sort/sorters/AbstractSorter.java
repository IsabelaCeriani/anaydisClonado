package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
public abstract class AbstractSorter implements ObservableSorter {

    protected SorterType sorterType;
    private final List<SorterListener> listeners;

    protected AbstractSorter() {
        sorterType = null;
        listeners = new ArrayList<>();
    }

    //returns true if the element at minIndex < j
    public <T> boolean greater(@NotNull Comparator<T> comparator, List<T> list, int minIndex, int j) {
        return comparator.compare(list.get(minIndex), list.get(j)) > 0;
    }


    public <T> void swap(@NotNull List<T> list, int i, int min) {
        T obj =  list.get(i);
        list.set(i, list.get(min));
        list.set(min, obj);

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



    }

    <T> void checkSwap(List<T> list, @NotNull Comparator<T> comparator, int left, int right){
        if(greater(comparator, list, left, right))
            swap(list, left, right);

    }


    public void addSorterListener(@NotNull SorterListener listener){
        listeners.add(listener);
    }

    public void removeSorterListener(@NotNull final SorterListener listener){
        listeners.remove(listener);
    }
}
