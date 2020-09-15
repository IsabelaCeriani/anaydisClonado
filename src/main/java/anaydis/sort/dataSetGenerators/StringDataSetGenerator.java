package anaydis.sort.dataSetGenerators;

import anaydis.sort.DataSetGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class StringDataSetGenerator implements DataSetGenerator<String> {

    @NotNull
    @Override
    public List<String> createAscending(int length) {
        List<String> ascendingStringList =  new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String generatedString = generateString();
            ascendingStringList.add(generatedString);
        }
        Collections.sort(ascendingStringList);
        return ascendingStringList;
    }

    @NotNull
    private String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 4;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @NotNull
    @Override
    public List<String> createDescending(int length) {
        List<String> descendingStringList = new ArrayList<>(Collections.singletonList(Collections.singletonList(length).toString()));
        for (int i = 0; i < length-1; i++) {
            String generatedString = generateString();
            descendingStringList.add(generatedString);
        }
        descendingStringList.sort(Collections.reverseOrder());
        return descendingStringList;
    }

    @NotNull
    @Override
    public List<String> createRandom(int length) {
        List<String> randomStringList = new ArrayList<>(Collections.singletonList(Collections.singletonList(length).toString()));
        for (int i = 0; i < length-1; i++) {
            String generatedString = generateString();
            randomStringList.add(generatedString);
        }
        return randomStringList;
    }

    @NotNull
    @Override
    public Comparator<String> getComparator() {
        return String::compareToIgnoreCase;
    }
}
