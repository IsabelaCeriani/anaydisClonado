package anaydis.sort;


import anaydis.sort.sorters.QuickCutOff;
import anaydis.sort.sorters.QuickNonRecursive;
import anaydis.sort.sorters.QuickSorter;
import anaydis.sort.sorters.*;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;

import java.util.Map;


public class SorterProviderClass implements SorterProvider{

//    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);

    private final Map<SorterType, Sorter> sorters;

    {
        sorters = new EnumMap<>(SorterType.class);
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
        InsertionSorter insertionSorter = new InsertionSorter();
        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.INSERTION, insertionSorter);
        HSorter hSorter = new HSorter();
        sorters.put(SorterType.H, hSorter);
        sorters.put(SorterType.QUICK, new QuickSorter());
        sorters.put(SorterType.SHELL, new ShellSorter(hSorter));
        sorters.put(SorterType.QUICK_NON_RECURSIVE, new QuickNonRecursive());
        sorters.put(SorterType.QUICK_CUT, new QuickCutOff(insertionSorter, 6));
        sorters.put(SorterType.QUICK_MED_OF_THREE, new QuickMedianOfThree(insertionSorter, 6));
    }

    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return sorters.values();

    }



    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType type) {
        if(sorters.containsKey(type)) return sorters.get(type);
        throw new IllegalArgumentException("Sorter type not yet implemented");
    }
}
