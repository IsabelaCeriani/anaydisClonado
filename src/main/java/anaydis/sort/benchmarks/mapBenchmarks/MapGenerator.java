package anaydis.sort.benchmarks.mapBenchmarks;

import anaydis.search.Map;
import anaydis.sort.dataSetGenerators.StringDataSetGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MapGenerator {



    private File file;
    private Map map;

    public MapGenerator(Map map, String file){
        this.map = map;
        this.file = new File(file);
    }

    public void getOcurrencesMap() throws FileNotFoundException {
        if(map.isEmpty()) fillOccurrencesMap(map);
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

    private void fillSearchMap(Map<String, Integer> ocurrencesMap) throws FileNotFoundException {
        for (Iterator<String> it = ocurrencesMap.keys(); it.hasNext(); ) {
            String word = it.next();
            reverseString(word);

        }

    }

    private void reverseString(String word){

    }




}
