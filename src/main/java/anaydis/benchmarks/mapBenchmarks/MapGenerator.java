package anaydis.benchmarks.mapBenchmarks;

import anaydis.search.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapGenerator {



    private File file;
    private Map<String, Integer> ocurrencesMap;

    public MapGenerator(Map map, String file){
        this.ocurrencesMap = map;
        this.file = new File(file);
    }

    public Map<String, Integer>  getOcurrencesMap() throws FileNotFoundException {
        if(ocurrencesMap.isEmpty()) fillOccurrencesMap(ocurrencesMap);
        return ocurrencesMap;
    }

    private void fillOccurrencesMap(Map<String, Integer> ocurrencesMap) throws FileNotFoundException {
        Scanner txt =  new Scanner(file);
        while (txt.hasNext()){
            String word = txt.next();
            int count = 1;
            if(ocurrencesMap.containsKey(word)) {
                count = ocurrencesMap.get(word)+1;
            }
                ocurrencesMap.put(word,count);

        }
        txt.close();

    }
    public List<String> getReversedList(int mapSize) throws FileNotFoundException {
        List<String> reversedKeys = new ArrayList<>();
        if(!ocurrencesMap.isEmpty()) fillReversedList(reversedKeys, mapSize);
        return reversedKeys;
    }

    private void fillReversedList(List<String> list, int mapSize) throws FileNotFoundException {
        for (int i = 0; i < mapSize; i++) {
        for (Iterator<String> it = ocurrencesMap.keys(); it.hasNext(); ) {
            String word = it.next();
            reverseString(word);
            list.add(word);
        }
        }

    }

    private void reverseString(String word){
        String reversed = "";
        for (int i = word.length()-1; i >= 0; i--) {
                reversed+=word.charAt(i);
        }
        word=reversed;
    }




}
