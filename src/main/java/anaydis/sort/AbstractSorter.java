package anaydis.sort;

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
abstract class AbstractSorter implements ObservableSorter {

    protected SorterType sorterType;
    private final List<SorterListener> listeners;

    protected AbstractSorter() {
        sorterType = null;
        listeners = new ArrayList<>();
    }

    //returns true if the element at minIndex < j
    <T> boolean greater(Comparator<T> comparator, List<T> list, int minIndex, int j) {
        return comparator.compare(list.get(minIndex), list.get(j)) > 0;
    }


    <T> void swap(List<T> list, int i, int min) {
        T obj =  list.get(i);
        list.set(i, list.get(min));
        list.set(min, obj);

    }

    public void addSorterListener(@NotNull SorterListener listener){
        listeners.add(listener);
    }

    public void removeSorterListener(@NotNull final SorterListener listener){
        listeners.remove(listener);
    }
}
