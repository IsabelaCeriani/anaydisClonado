package anaydis.sort.benchmarks.mapBenchmarks;

import anaydis.search.ArrayMap;
import anaydis.search.MapType;
import anaydis.sort.Sorter;
import anaydis.sort.SorterProvider;
import anaydis.sort.SorterType;
import anaydis.sort.dataSetGenerators.StringDataSetGenerator;
import anaydis.sort.sorters.*;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;

public class MapProviderClass<K, V> implements SorterProvider {

    StringDataSetGenerator sdg = new StringDataSetGenerator();
    private final Map<MapType, Map> maps;

    {

        maps = new EnumMap<>(MapType.class);

//        maps.put(MapType.ARRAYMAP, new ArrayMap<K, V>(C));


    }




    @NotNull
    @Override
    public Iterable<Sorter> getAllSorters() {
        return null;
    }

    @NotNull
    @Override
    public Sorter getSorterForType(@NotNull SorterType sorterType) {
        return null;
    }
}

//
//public class SorterProviderClass implements SorterProvider {
//
////    private final Map<SorterType, Sorter> sorters = new EnumMap<>(SorterType.class);
//
//    private final Map<SorterType, Sorter> sorters;
//
//    {
//        sorters = new EnumMap<>(SorterType.class);
//        sorters.put(SorterType.BUBBLE, new BubbleSorter());
//        InsertionSorter insertionSorter = new InsertionSorter();
//        sorters.put(SorterType.SELECTION, new SelectionSorter());
//        sorters.put(SorterType.INSERTION, insertionSorter);
//        HSorter hSorter = new HSorter();
//        sorters.put(SorterType.H, hSorter);
//        sorters.put(SorterType.QUICK, new QuickSorter());
//        sorters.put(SorterType.SHELL, new ShellSorter(hSorter));
//        sorters.put(SorterType.QUICK_NON_RECURSIVE, new QuickNonRecursive());
//        sorters.put(SorterType.QUICK_CUT, new QuickCutOff(insertionSorter, 6));
//        sorters.put(SorterType.QUICK_MED_OF_THREE, new QuickMedianOfThree(insertionSorter, 6));
//        sorters.put(SorterType.QUICK_THREE_PARTITION, new QuickThreePartition());
//        sorters.put(SorterType.MERGE_BOTTOM_UP, new MergeBottomUp());
//        sorters.put(SorterType.MERGE_TOP_DOWN, new MergeTopDown());
//    }
//
//    @NotNull
//    @Override
//    public Iterable<Sorter> getAllSorters() {
//        return sorters.values();
//
//    }
//
//
//
//    @NotNull
//    @Override
//    public Sorter getSorterForType(@NotNull SorterType type) {
//        if(sorters.containsKey(type)) return sorters.get(type);
//        throw new IllegalArgumentException("Sorter type not yet implemented");
//    }