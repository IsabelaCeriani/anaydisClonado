package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import anaydis.sort.gui.ObservableSorter;
import anaydis.sort.gui.SorterListener;
import anaydis.sort.listeners.OrderSorterListener;
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
        for (SorterListener listener: listeners) {
            if(listener instanceof OrderSorterListener) listener.greater(minIndex, j);
        }
        return comparator.compare(list.get(minIndex), list.get(j)) > 0;

    }

    public <T> boolean greaterOfTwoLists(@NotNull Comparator<T> comparator, List<T> a, List<T> b, int aIndex, int bIndex) {
        for (SorterListener listener: listeners) {
            if(listener instanceof OrderSorterListener) listener.greater(aIndex, bIndex);
        }
        return comparator.compare(a.get(aIndex), b.get(bIndex)) > 0;

    }




    public <T> void swap(@NotNull List<T> list, int i, int min) {
        for (SorterListener listener: listeners) {
            if(listener instanceof OrderSorterListener) listener.swap(i, min);
        }


        T obj =  list.get(i);
        list.set(i, list.get(min));
        list.set(min, obj);

    }



    <T> void checkSwap(List<T> list, @NotNull Comparator<T> comparator, int left, int right){
        for (SorterListener listener: listeners) {
            if(listener instanceof OrderSorterListener) listener.greater(left, right);
        }
        if(greater(comparator, list, left, right)) {
            swap(list, left, right);
            for (SorterListener listener: listeners) {
                if(listener instanceof OrderSorterListener) listener.swap(left, right);
            }
        }
    }


    public <T>void mergeInPlace(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;


        List<T> leftAux = new ArrayList<>(n1);
        List<T> rightAux = new ArrayList<>(n2);

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftAux.add(list.get(left+i));
        }
        for (int j=0; j < n2; j++) {
            rightAux.add(list.get(middle+j+1));
        }

        int i = 0, j = 0;
        int k = left;

        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (greaterOfTwoLists(comparator, rightAux, leftAux, j, i)) {
                list.set(k,  leftAux.get(i));
                i++;
            } else {
                list.set(k, rightAux.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            list.set(k,  leftAux.get(i));
            i++;
            k++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            list.set(k, rightAux.get(j));
            j++;
            k++;
        }
    }


    public void addSorterListener(@NotNull SorterListener listener){
        listeners.add(listener);
    }

    public void removeSorterListener(@NotNull final SorterListener listener){
        listeners.remove(listener);
    }
}
