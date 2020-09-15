package anaydis.sort;

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
