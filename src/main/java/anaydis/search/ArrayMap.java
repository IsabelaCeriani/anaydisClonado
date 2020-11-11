package anaydis.search;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ArrayMap<K, V> implements Map<K, V> {

    private final List<K> keys;
    private final List<V> values;
    private final Comparator<K> comparator;

    public ArrayMap(Comparator<K> comparator) {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean containsKey(@NotNull K key) {
        return (indexOf(key) >= 0);
    }

    @Override
    public V get(@NotNull K key) {
        int index = indexOf(key);
        if (index < 0) return null;
        return values.get(index);
    }

    @Override
    public V put(@NotNull K key, V value) {
        if (keys.isEmpty()) {
            keys.add(key);
            values.add(value);

        }

        int index = find(key, 0, size() - 1);


        if (index < 0) {
            keys.add(-index - 1, key);
            values.add(-index - 1, value);
            return null;
        }

        return values.set(index, value);


    }



    @Override
    public void clear() {
        keys.clear();

    }

    @Override
    public Iterator<K> keys() {
        return null;

    }

    public int indexOf(K key) {
        int index = find(key, 0, size() - 1);
         return (index >= 0) ?  index:  -1;

    }

    public int find(K searchedKey, int low, int high) {
        while (low <= high) {
            int middle =  (high + low) / 2;

            int compare = comparator.compare(searchedKey, keys.get(middle));

            if (compare == 0) return middle;
            return compare > 0 ? find(searchedKey, middle + 1, high) : find(searchedKey, low, middle - 1);
        }

        return -(low + 1);
    }




    //para testear evitando posibles errores del put
    protected void addKey(K key) {
        keys.add(key);
    }

    protected List<K> getKeys() {
        return keys;
    }

    protected boolean containsKeyt(K key) {
        return keys.contains(key);
    }

    protected boolean containsValueT(V value) {
        return values.contains(value);
    }
}