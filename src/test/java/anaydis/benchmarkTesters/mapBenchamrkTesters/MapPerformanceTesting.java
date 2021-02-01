package anaydis.benchmarkTesters.mapBenchamrkTesters;

import anaydis.search.ArrayMap;
import anaydis.search.RandomizedTreeMap;
import anaydis.sort.StringDataSetGenerator;
import anaydis.benchmarks.mapBenchmarks.MapBenchResult;
import anaydis.benchmarks.mapBenchmarks.MapBenchamrkGenerator;
import anaydis.benchmarks.mapBenchmarks.MapGenerator;
import anaydis.sort.listeners.TimePerformanceListener;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MapPerformanceTesting {

    TimePerformanceListener timePerformanceListener = new TimePerformanceListener();

    StringDataSetGenerator sdg = new StringDataSetGenerator();
    ArrayMap<String, Integer> arrayMap = new ArrayMap<>(sdg.getComparator());
    RandomizedTreeMap<String, Integer> randomizedTreeMap = new RandomizedTreeMap<>(sdg.getComparator());
    String quijote = "src/test/resources/books/quijote.txt";
    MapGenerator arrayMapGenerator= new MapGenerator(arrayMap, quijote);
    MapGenerator treeMapGenerator= new MapGenerator(randomizedTreeMap, quijote);



    MapBenchamrkGenerator treeMapBenchmarker= new MapBenchamrkGenerator(timePerformanceListener,treeMapGenerator);


    @Test
    public void testGenerateBenchmarkArrayMap() throws FileNotFoundException {
        MapBenchamrkGenerator arrayMapBenchmarker= new MapBenchamrkGenerator(timePerformanceListener,arrayMapGenerator);
//        MapBenchResult result = arrayMapBenchmarker.generateBenchMark(3000);
//        System.out.println(result.toString());


    }

    @Test
    public void testGenerateBenchmarkTreeMap(){
        MapBenchamrkGenerator treeMapBenchmarker= new MapBenchamrkGenerator(timePerformanceListener,treeMapGenerator);

    }



}
