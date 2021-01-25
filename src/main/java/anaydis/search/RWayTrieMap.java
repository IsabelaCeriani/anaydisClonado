package anaydis.search;

import anaydis.immutable.dynamicStack.DynamicStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RWayTrieMap<T> implements Map<String, T> {

    private Node<T> root;
    private int size;
    private T prev;

    public RWayTrieMap() {
        root=null;
        size=0;
    }

    //implementar el put usando Result
    private class Result{
        private final Node<T> node;
        private final T prevElem;

        public Result(Node<T> node, T prevElem) {
            this.node = node;
            this.prevElem = prevElem;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean containsKey(@NotNull String key) {
        return (find(root, key, 0)!=null);
    }

    @Override
    public T get(@NotNull String key) {
        Node<T> node = find(root, key, 0);
        return node != null ? node.elem : null;
    }



    @Override
    public void clear() {
        size =0;
        root = null;
    }



    @Override
    public Iterator<String> keys() {
        List<String> list = new ArrayList<>();
        keys(root, "", list);
        return list.iterator();
    }

    private void keys(Node<T> node, String string, List<String> list){
        if(node == null) return;

        if(node.elem != null)list.add(string);
        for (int i = 0; i < node.next.length; i++) {
            keys(node.next[i], string+ i, list);
        }
    }




     protected Node<T> find(Node<T> node, String word, int level)  {
        if (node == null) return null;

        if (level == word.length()) return node;

        int next = (int) word.charAt(level);
        return find(node.next[next], word, level + 1);
    }

    @Override
    public T put(@NotNull String key, T value) {
        root = put(root, key, value, 0);
        return prev;
    }

    protected Node<T> put(Node<T> node, String key, T value, int level) {
        if(node == null) {
            node = new Node<>(value);
            if (level < key.length()) {
                char c = key.charAt(level);
                node.next[c] = put(node.next[c], key, value, level+1);
            }else{
                node.elem = value;
                size++;
            }
        }else {

            if (level < key.length()) {
                char c = key.charAt(level);
                node.next[c] = put(node.next[c], key, value, level + 1);
            }

            prev = node.elem;
            node.elem  = value;

        }
        return node;

    }

//    public Node<T> pon(Node<T> node, String key, T value, int level){
//        if(node == null){
//            node = new Node<>(value);
//            if(level < key.length()) node.next[key.charAt(level)] = put(node.next[key.charAt(level)], key, value, level+1);
//            prev = node.elem;
//            node.elem = value;
//            size++;
//            return node;
//        }
//
//        if(level < key.length()) node.next[key.charAt(level)] = put(node.next[key.charAt(level)], key, value, level+1);
//        prev = node.elem;
//        node.elem = value;
//
//        return node;
//
//    }

    //ternary
//    public void autocomplete(Node node, String prefix, int level){
//        if(node == null) return;
//        if(level < prefix.length()){
//            int c = prefix.charAt(level);
//            if(node.elem == c) autocomplete(node.m, prefix, level+1);
//            if(node.elem < c) autocomplete(node.l, prefix, level);
//        }
//
//    }

    protected Node<T> getRoot(){
        return this.root;
    }

    protected void setRoot(Node<T> newNode){
        root=newNode;
    }


}
