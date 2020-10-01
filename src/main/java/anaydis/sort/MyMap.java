package anaydis.sort;

import anaydis.search.Map;
import org.jetbrains.annotations.NotNull;

import java.util.*;


//The key values must be able to be sorted.
public  class MyMap<T extends Comparable<T>, V> implements Map, Comparator<T> {

    private final List<T> keys;
    private final List<V> values;

    public MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }


    @Override
    public int size() {
        return keys.size();
    }




    @Override
    public boolean containsKey(@NotNull Object key) {
        return findKey(key, 0, keys.size() - 1) != -1;
    }


    public int findKey(@NotNull Object key, int left, int right){

        while(left<=right){
        int middle = (left + right)/2;
        int compareValue = compare((T) key, keys.get(middle));

        if(compareValue == 0) return middle;
        if(compareValue < 0) right = middle-1;
        if (compareValue > 0) left = middle+1;


        }

        return -1;

    }


    @Override
    public Object get(@NotNull Object key) {
        int index = findKey(key, 0, keys.size()-1);
        if(index != -1){
            return values.get(index);
        }

        return new Exception("Key not found in Map");
    }

    @Override
    public Object put(@NotNull Object key, Object value) {
        if(keys.isEmpty()) {
            keys.add((T) key);
            values.add((V) value);
            return null;
        }
        int index = findKey(key, 0, keys.size()-1);
        if(index < 0){
            index = (-index) -1;
            int size = keys.size()+1;
            for (int i = index; i <= size; i++) {
                keys.set(i++, keys.get(i));
                values.set(i++, values.get(i));
                return null;
            }
            keys.set(index, (T)key);
        }
        return values.set(index, (V)value);


    }




    @Override
    public void clear() {
        keys.forEach(Objects::isNull);
    }

    @Override
    public Iterator<T> keys() {
        return (Iterator<T>) keys;
    }




    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }



    //methods for tester
    protected List<T> getKeys(){
        return keys;
    }

    protected List<V> getValues(){
        return values;
    }
}
