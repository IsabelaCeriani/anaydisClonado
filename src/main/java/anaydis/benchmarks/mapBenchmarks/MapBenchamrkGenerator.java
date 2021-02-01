package anaydis.benchmarks.mapBenchmarks;


import anaydis.search.Map;
import anaydis.sort.listeners.TimePerformanceListener;

import java.io.FileNotFoundException;
import java.util.List;

public class MapBenchamrkGenerator {


    private TimePerformanceListener timePerformanceListener;
    private MapGenerator ocurrencesCounter;

    public MapBenchamrkGenerator(TimePerformanceListener timePerformanceListener, MapGenerator ocurrencesCounter) {
        this.timePerformanceListener = timePerformanceListener;
        this.ocurrencesCounter = ocurrencesCounter;
    }



    public Map<String, Integer>  fillOccurrencesMap() throws FileNotFoundException {
        return ocurrencesCounter.getOcurrencesMap();
    }

    public List<String> getReversedList(int mapSize) throws FileNotFoundException {
        return ocurrencesCounter.getReversedList(mapSize);
    }

    //calcula el tiempo promedio de busqueda del mapa
    public MapBenchResult generateBenchMark(int nSearches) throws FileNotFoundException {
        Map<String, Integer> ocurrencesMap = fillOccurrencesMap();
        List<String> reversedKeys = getReversedList(nSearches);

        for (String word: reversedKeys) {
            timePerformanceListener.start();
            ocurrencesMap.get(word);
            timePerformanceListener.setTime();
//            timePerformanceListener.reset();
        }

        double timePerformance = timePerformanceListener.getTime();
        return new MapBenchResult(nSearches, timePerformance);



    }


}
