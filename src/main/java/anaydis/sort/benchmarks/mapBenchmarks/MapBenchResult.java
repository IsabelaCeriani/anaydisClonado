package anaydis.sort.benchmarks.mapBenchmarks;

public class MapBenchResult {

    int amountOfSearches;
    double timeTaken;

    public MapBenchResult(int amountOfSearches, double timeTaken) {
        this.amountOfSearches = amountOfSearches;
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "MapBenchResult{" +
                "amountOfSearches=" + amountOfSearches +
                ", timeTaken=" + timeTaken +
                '}';
    }
}
