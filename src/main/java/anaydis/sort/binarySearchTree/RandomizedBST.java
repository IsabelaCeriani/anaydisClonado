package anaydis.sort.binarySearchTree;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomizedBST <T extends Comparable<T> , V> implements Comparator<T> {


    private DoubleNode<T, V> root;
    private int size;

    public RandomizedBST(){ root = null; }


    public V get(T key)  {
        DoubleNode<T,V> node = find(root, key);
        return node.elem;
    }

    public boolean contains(T key){
        return (find(root, key) != null);
    }

    public DoubleNode<T, V> find(DoubleNode<T, V> node, T key) {
        if (node == null || node.key == null ) return null;
        int compareValue = compare(key, node.key);

        switch (compareValue) {
            case 0:
                return node;
            case -1:
                find(node.left, key);
            case 1:
                find(node.right, key);
        }

        return find(node.right, key);

    }


    public  DoubleNode<T,V> put(@NotNull T key, V value) {
        root = rootPut(root, key, value);
        return root;
    }

    public DoubleNode<T, V> rootPut(DoubleNode<T, V> node, @NotNull T key, V value) {
        DoubleNode<T, V> newNode = new DoubleNode<T, V>();
        newNode.elem = value;
        newNode.key = key;
            if (node == null  || node.key == null){
                node = newNode;
                size++;
                return newNode;
            }

//            if (Math.random()< 0.5) return rootPut(node, key, value);

        while(true) {
            int compareValue = compare(key, node.key);


            if (compareValue < 0) {
//                node.left = rootPut(node.left, key, value);
                if(node.left == null) {
                    node.left = newNode;
                    rotateRight(node);
                    break;
                }
                node = node.left;
            }

            if (compareValue > 0) {
//                node.right = rootPut(node.right, key, value);
                if(node.right == null) {
                    node.right = newNode;
                    rotateLeft(node);
                    break;
                }
                node = node.right;
            }
            }

            return node;
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


    @Override
    public int compare(T o1, T o2) {
            return o1.compareTo(o2);

    }

    public List<T> getKeyList(DoubleNode<T,V> node){
        List<T> keys = new ArrayList<>();
        if(node != null){
            getKeyList(node.left);
            keys.add(node.key);
            getKeyList(node.right);
        }
        return keys;
    }

    public List<T> getKeyList(){
        return getKeyList(root);
    }
    public List<V> getValuesList(DoubleNode<T,V> node){
        List<V> values = new ArrayList<>();
        if(node != null){
            getValuesList(node.left);
            values.add(node.elem);
            getValuesList(node.right);
        }
        return values;
    }

    public List<V> getValuesList(){
        return getValuesList(root);
    }

    public void clear(DoubleNode<T,V> node){
        if(node != null){
            getKeyList(node.left);
            node.key = null;
            getKeyList(node.right);
        }
    }

    public void clear(){
         clear(root);
    }
    public int getHeight(DoubleNode<T, V> node) {

        if (node == null) return -1;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public DoubleNode<T, V> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    int amountOfLeavesInTree(DoubleNode<T, V> node){

        if(node != null){
            if(node.left != null && node.right != null){
                return 1;

            }
            else{

                return amountOfLeavesInTree(node.left) + amountOfLeavesInTree(node.right);

            }
        }
        else return 0;

    }
}
