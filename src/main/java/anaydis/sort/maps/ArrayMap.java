package anaydis.sort.maps;
import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ArrayMap<T extends Comparable<T>, V> implements Map<T, V>, Comparator<T> {

    private final List<T> keys = new ArrayList<>();
    private final List<V> values = new ArrayList<>();

    public ArrayMap() {
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean containsKey(@NotNull T key) {
        return (indexOf(key) >= 0);
    }

    @Override
    public V get(@NotNull T key) {
        int index = indexOf(key);
        return values.get(index);
    }

    @Override
    public V put(@NotNull T key, V value) {
        if (keys.isEmpty()) {
            keys.add(key);
            values.add(value);
        }

        int index = find(key, 0, size() - 1);
        T lastKey = null;
        V lastValue = null;

        if (index < 0) {
            index = -index;
            for (int i = index + 1; i < size(); i++) {
                lastKey = keys.set(i, keys.get(i + 1));
                lastValue = values.set(i, values.get(i + 1));
            }
            keys.add(lastKey);
            values.add(lastValue);

            keys.set(index, key);
            values.set(index, value);
            return null;
        }
        return values.set(index, value);


    }



    @Override
    public void clear() {
        keys.clear();

    }

    @Override
    public Iterator<T> keys() {
        return null;

    }

    public int indexOf(T key) {
        int index = find(key, 0, size() - 1);
        if (index >= 0) return index;
        return -1;
    }

    public int find(T searchedKey, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;

            int compare = compare(searchedKey, keys.get(middle));

            if (compare == 0) return middle;
            if (compare < 0) high = middle - 1;
            if (compare > 0) low = middle + 1;
        }

        return -(low);
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }


    //para testear sin acarrear posibles errores del put
    protected void addKey(T key) {
        keys.add(key);
    }

    protected List<T> getKeys() {
        return keys;
    }

    protected boolean containsKeyt(T key) {
        return keys.contains(key);
    }

    protected boolean containsValueT(V value) {
        return values.contains(value);
    }
}