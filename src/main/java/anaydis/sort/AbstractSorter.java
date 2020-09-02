package anaydis.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Abstract sorter: all sorter implementations should subclass this class.
 */
abstract class AbstractSorter implements Sorter {

    protected SorterType sorterType;

    protected AbstractSorter() {
        sorterType = null;
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


}
