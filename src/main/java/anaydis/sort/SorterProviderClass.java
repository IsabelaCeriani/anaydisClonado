package anaydis.sort;


import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;

import java.util.Map;


public class SorterProviderClass implements SorterProvider{

//    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);

    private final Map<SorterType, Sorter> sorters;

    {
        sorters = new EnumMap<>(SorterType.class);
        sorters.put(SorterType.BUBBLE, new BubbleSorter());
        sorters.put(SorterType.SELECTION, new SelectionSorter());
        sorters.put(SorterType.INSERTION, new InsertionSorter());
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
