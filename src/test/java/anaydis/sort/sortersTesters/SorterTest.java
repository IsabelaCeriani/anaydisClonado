package anaydis.sort.sortersTesters;

import anaydis.sort.AbstractSorterTest;
import anaydis.sort.DataSetGenerator;
import anaydis.sort.SorterProvider;
import anaydis.sort.sorters.SorterProviderClass;
import anaydis.sort.dataSetGenerators.IntegerDataSetGenerator;
import anaydis.sort.dataSetGenerators.StringDataSetGenerator;

/**
 * Sorter tests should subclass this abstract implementation
 */
abstract class SorterTest extends AbstractSorterTest {

    @Override protected DataSetGenerator<String> createStringDataSetGenerator() {
        return new StringDataSetGenerator();
    }

    @Override protected DataSetGenerator<Integer> createIntegerDataSetGenerator() {
        return new IntegerDataSetGenerator();
    }

    @Override protected SorterProvider getSorterProvider() {
        return new SorterProviderClass();
    }
}
