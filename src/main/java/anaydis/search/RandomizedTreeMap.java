package anaydis.search;

import org.jetbrains.annotations.NotNull;

import java.util.*;


public class RandomizedTreeMap<T , V> implements Map<T, V>{

    private DoubleNode<T, V> root;
    private int size;
    private Comparator<T> comparator;

    public RandomizedTreeMap(Comparator<T> comparator){
        root = null;
        size= 0;
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean containsKey(@NotNull T key) {
        return  (find(root, key) != null);
    }

    @Override
    public V get(@NotNull T key) {
        DoubleNode<T,V> node = find(root,  key);
        return node.elem;
    }

    //deberian retornar el elemento que habia en el nodo anterior, no en el nuevo
    @Override
    public V put(@NotNull T key, V value) {
         root = put(root, key, value);
        return root.elem;
    }

    public DoubleNode<T, V> put(DoubleNode<T, V> node, @NotNull T key, V value) {
        if (node == null) {
            node = new DoubleNode<>(key, value);
            size++;
            return node;
        }


        if (Math.random()< 0.5) return put(node, key, value);


        int compareValue = comparator.compare(key, node.key);


        if (compareValue < 0) {
            node.left = put(node.left, key, value);
        }

        if (compareValue > 0) {
            node.right = put(node.right, key, value);


        }
        if(compareValue == 0){
            node.elem = value;
            return node;
        }

        return node;
    }


    @Override
    public void clear() {
        clear(root);
        size =0;
    }
    public void clear(DoubleNode<T,V> node){
        if(node != null){
            clear(node.left);
            node.key = null;
            clear(node.right);
        }
    }

    @Override
    public Iterator<T> keys() {
        return null;
    }


    public DoubleNode<T, V> find(DoubleNode<T, V> node, T key) {
        if (node == null ) return null;
        int compareValue = comparator.compare(key, node.key);

        if(compareValue == 0) return node;
        return (compareValue < 0)?find(node.left, key): find(node.right, key);


    }




    public DoubleNode<T, V> rotateLeft(DoubleNode<T, V> node)  {
        DoubleNode<T, V> result = node.right;
        node.right = result.left;
        result.left = node;
        return result;
    }
    public DoubleNode<T,V> rotateRight(DoubleNode<T, V> node)  {
        DoubleNode<T, V> result = node.left;
        node.left = result.right;
        result.right = node;
        return result;
    }



    //for testing
    public int getHeight(){
        return getHeight(root);
    }
    public int getHeight(DoubleNode<T, V> node) {

        if (node == null) return -1;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public DoubleNode<T, V> getRoot() {
        return this.root;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }
}
