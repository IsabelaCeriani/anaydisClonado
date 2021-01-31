package anaydis.sort.benchmarks.mapBenchmarks;

import anaydis.search.Map;
import anaydis.sort.dataSetGenerators.StringDataSetGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MapGenerator {



    private File file;
    private Map<String, Integer> ocurrencesMap;

    public MapGenerator(Map map, String file){
        this.ocurrencesMap = map;
        this.file = new File(file);
    }

    public void getOcurrencesMap() throws FileNotFoundException {
        if(ocurrencesMap.isEmpty()) fillOccurrencesMap(ocurrencesMap);
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
    public void getSearchMap(Map<String, Integer> searchMap) throws FileNotFoundException {
        if(searchMap.isEmpty()) fillSearchMap(searchMap);
    }

    private void fillSearchMap(Map<String, Integer> reversedMap) throws FileNotFoundException {
        for (Iterator<String> it = ocurrencesMap.keys(); it.hasNext(); ) {
            String word = it.next();
            reversedMap.put(word, ocurrencesMap.get(it.next()));
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
