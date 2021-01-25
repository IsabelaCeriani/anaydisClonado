package anaydis.sort.benchmarks.mapBenchmarks;


import anaydis.search.Map;
import anaydis.sort.listeners.TimePerformanceListener;

import java.io.FileNotFoundException;

public class MapBenchamrkGenerator {

//    TimePerformanceListener timePerformanceListener = new TimePerformanceListener();
//    StringDataSetGenerator sdg = new StringDataSetGenerator();
//    ArrayMap<String, Integer> arrayMap = new ArrayMap<>(sdg.getComparator());
//    RandomizedTreeMap<String, Integer> randomizedTreeMap = new RandomizedTreeMap<>(sdg.getComparator());
//    OcuCounter  ocuArraymap= new OcuCounter(arrayMap, "/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/src/main/java/anaydis/sort/quijote/quijote.txt");
//    OcuCounter  ocuRandomizedTreeMap= new OcuCounter(randomizedTreeMap, "/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/src/main/java/anaydis/sort/quijote/quijote.txt");


    private TimePerformanceListener timePerformanceListener;
    private MapGenerator ocurrencesCounter;

    public MapBenchamrkGenerator(TimePerformanceListener timePerformanceListener, MapGenerator ocurrencesCounter) {
        this.timePerformanceListener = timePerformanceListener;
        this.ocurrencesCounter = ocurrencesCounter;
    }



    public void fillOccurrencesMap() throws FileNotFoundException {
        ocurrencesCounter.getOcurrencesMap();
    }

    public void fillSearchMap(Map map) throws FileNotFoundException {
        ocurrencesCounter.getSearchMap(map);
    }

    //calcula el tiempo promedio de insercion y busqueda del mapa
   public MapBenchResult generateBenchMark(Map searchMap, String[] words, int nSearches) throws FileNotFoundException {
            int count=0;
            fillSearchMap(searchMap);
            timePerformanceListener.start();
            fillOccurrencesMap();
            while (count <nSearches) {
                for (String word : words) searchMap.get(word);
                timePerformanceListener.setTime();
                timePerformanceListener.reset();
                count++;
            }
            double timePerformance = timePerformanceListener.getTime();
            return new MapBenchResult(nSearches, timePerformance);

   }


}
