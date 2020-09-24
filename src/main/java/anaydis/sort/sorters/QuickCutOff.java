package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class QuickCutOff extends QuickSorter {


    private final InsertionSorter insertionSorter;
    private  int cutIndex;




    public QuickCutOff(InsertionSorter insertionSorter, int cutIndex) {
        this.insertionSorter = insertionSorter;
        this.cutIndex = cutIndex;
    }


    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        int right = list.size()-1;
        int left = 0;
        sort(comparator, list, left, right);
    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int left, int right) {
        if (right - left <= cutIndex) {
            insertionSorter.sort(comparator, list);
            return;
        }
        if(right <= left) return;
        int i = partition(comparator, list, left, right);
        sort(comparator, list, left, i - 1);
        sort(comparator, list, i + 1, right);

    }

    public void setCutIndex(int cutIndex) {
        this.cutIndex = cutIndex;
    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_CUT;
    }
}
