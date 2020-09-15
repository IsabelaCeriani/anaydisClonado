package anaydis.sort.dataSetGenerators;

import anaydis.sort.DataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class IntegerDataSetGenerator implements DataSetGenerator<Integer> {
    @NotNull
    @Override
    public List<Integer> createAscending(int length) {
        List<Integer> ascendingIntegerList = new ArrayList<>(Collections.singletonList(length));
        for (int i = 0; i < length -1; i++) {
            ascendingIntegerList.add(i, i+1);
        }
        return ascendingIntegerList;
    }

    @NotNull
    @Override
    public List<Integer> createDescending(int length) {
        List<Integer> descendingIntegerList = new ArrayList<>(Collections.singletonList(length));
        for (int i = length -1; i > 0; i--) {
            descendingIntegerList.add(i);
        }
        return descendingIntegerList;
    }

    @NotNull
    @Override
    public List<Integer> createRandom(int length) {
        List<Integer> randomIntegerList = new ArrayList<>(Collections.singletonList(length));
        Random rand = new Random();
        for (int i = 0; i <length-1 ; i++) {
            randomIntegerList.add(i, rand.nextInt(length));
        }
        return randomIntegerList;
    }


    @NotNull
    @Override
    public Comparator<Integer> getComparator() {
        return Comparator.comparingInt(s -> s);
    }


}
