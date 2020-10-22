package anaydis.search;

import anaydis.search.Map;
import anaydis.search.Node;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class RWayTrieMap<T> implements Map<String, T> {

    private Node<T> root;
    private int size;

    public RWayTrieMap() {
        root=null;
        size=0;
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
        return node.elem;
    }



    @Override
    public void clear() {
        size =0;
        for (Node<T> t: root.next) {
            t = null;
        }
    }



    @Override
    public Iterator<String> keys() {
        return null;
    }


     protected Node<T> find(Node<T> node, String word, int d) {
        if (node == null) {
            return null;
        }
        if (d == word.length()) {
            return node;
        }
        char c = word.charAt(d);
        return find(node.next[c], word, d + 1);
    }

    @Override
    public T put(@NotNull String key, T value) {
        root = put(root, key, value, 0);
        return root.elem;
    }

    protected Node<T> put(Node<T> node, String key, T value, int level) {
        if(node == null) {
            Node<T> result = new Node<>(value);
            return result;
        }

            if(level == key.length()) {
                node.elem = value;
                return node;
            }

            char c = key.charAt(level);
            node.next[c] = put(node.next[c], key, value, level + 1);
            return node;
            }


}
