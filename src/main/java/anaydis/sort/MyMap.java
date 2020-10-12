package anaydis.sort;

import anaydis.search.Map;
import anaydis.sort.binarySearchTree.RandomizedBST;
import org.jetbrains.annotations.NotNull;

import java.util.*;


//The key values must be able to be sorted.
public  class MyMap<T extends Comparable<T>, V> implements Map{

    private final RandomizedBST treeMap;

    public MyMap() {
        treeMap = new RandomizedBST();
    }


    @Override
    public int size() {
        return treeMap.getSize();
    }




    @Override
    public boolean containsKey(@NotNull Object key) {
        return treeMap.contains((T)key);
    }



    @Override
    public Object get(@NotNull Object key) {
        if(treeMap.contains((T)key)) return treeMap.get((T)key);

        return null;
    }

    @Override
    public Object put(@NotNull Object key, Object value) {
        return treeMap.put((T)key, value);
    }





    @Override
    public void clear() {
            treeMap.clear();
    }

    @Override
    public Iterator<T> keys() {
        return (Iterator<T>) treeMap.getKeyList();
    }


    public RandomizedBST getTreeMap() {
        return treeMap;
    }
}
