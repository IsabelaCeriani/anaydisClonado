package anaydis.search;

import anaydis.immutable.BankersQueue;
import anaydis.immutable.dynamicStack.DynamicStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;



public class RWayTrieMap<T> implements Map<String, T> {

    

    private TrieNode<T> root;
    private int size;
    private T prev;

    public RWayTrieMap() {
        root=null;
        size=0;
    }

    //para devolver el prev element en put()
    private class Result{
        private final TrieNode<T> TrieNode;
        private final T prevElem;

        public Result(TrieNode<T> TrieNode, T prevElem) {
            this.TrieNode = TrieNode;
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
        TrieNode<T> TrieNode = find(root, key, 0);
        return TrieNode != null ? TrieNode.elem : null;
    }



    @Override
    public void clear() {
        size =0;
        root = null;
    }



    @Override
//    public Iterator<String> keys() {
//        List<String> list = new ArrayList<>();
//        keys(root, "", list, 0);
//        return list.iterator();
//    }
////
//    private void keys(TrieNode<T> TrieNode, String string, List<String> list, int level){
//        if(TrieNode == null) return;
//
//        if(TrieNode.elem != null)list.add(string);
//        for (int i = 0; i < TrieNode.next.length; i++) {
//            keys(TrieNode.next[i], string+Character.toString((char)i), list, level);
//        }
//    }

    public Iterator<String> keys() {
        List<String> list = new ArrayList<>();
        keys(root, "", list, 0);
        return list.iterator();
    }
    //
    private void keys(TrieNode<T> TrieNode, String string, List<String> list, int level){
        if(TrieNode == null) return;

        if(TrieNode.elem != null)list.add(string);
        for (int i = 0; i < TrieNode.next.length; i++) {
            keys(TrieNode.next[i], string+Character.toString((char)i), list, level);
        }
    }




    protected TrieNode<T> find(TrieNode<T> TrieNode, String word, int level)  {
        if (TrieNode == null) return null;

        if (level == word.length()) return TrieNode;

        int next = (int) word.charAt(level);
        return find(TrieNode.next[next], word, level + 1);
    }

    @Override
    public T put(@NotNull String key, T value) {
        root = put(root, key, value, 0);
        return prev;
    }

    protected TrieNode<T> put(TrieNode<T> TrieNode, String key, T value, int level) {
        if(TrieNode == null) {
            TrieNode = new TrieNode<>();
            if (level < key.length()) {
                char c = key.charAt(level);
                TrieNode.next[c] = put(TrieNode.next[c], key, value, level+1);
            }else{
                TrieNode.elem = value;
                size++;
            }
        }else {

            if (level < key.length()) {
                char c = key.charAt(level);
                TrieNode.next[c] = put(TrieNode.next[c], key, value, level + 1);
            } else {

                prev = TrieNode.elem;
                TrieNode.elem = value;
            }
        }


        return TrieNode;

    }



    protected TrieNode<T> getRoot(){
        return this.root;
    }

    protected void setRoot(TrieNode<T> newTrieNode){
        root=newTrieNode;
    }


}
