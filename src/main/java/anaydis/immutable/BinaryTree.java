package anaydis.immutable;

import anaydis.immutable.dynamicStack.DynamicStack;
import anaydis.search.DoubleNode;
import org.jetbrains.annotations.NotNull;


import java.util.Comparator;
import java.util.Iterator;


public class BinaryTree<K, V> implements anaydis.immutable.Map<K, V> {

    private final Comparator<K> comparator;
    private final DoubleNode<K, V> head;
    private final int size;

    public BinaryTree(Comparator<K> comparator, DoubleNode<K, V> node, int size) {
        this.comparator = comparator;
        this.head = node;
        this.size = size;
    }

    public BinaryTree(Comparator<K> comparator) {
        this.comparator = comparator;
        this.head = null;
        size = 0;

    }



    private boolean containsKey(K key, DoubleNode<K, V> node){
        if(node == null) return false;
        final int compare = comparator.compare(key, node.key);
        if(compare == 0) return true;
        return compare > 0 ? containsKey(key, node.right): containsKey(key, node.left);
    }

    private V get(K key, DoubleNode<K,V> node){
        if(node == null) return null;
        final int compare = comparator.compare(key, node.key);
        if(compare == 0) return node.elem;
        return compare > 0 ? get(key, node.right): get(key, node.left);
    }

    @Override
    public V get(@NotNull K k) {
        return get(k, head);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(@NotNull K k) {
        return containsKey(k, head);
    }


    @Override
    public Map<K, V> put(@NotNull K k, V v) {
        TreeResult<K, V> result = put(head, k, v);
        return new BinaryTree<>(comparator, result.getNode(), result.getSize());
    }

    private TreeResult<K,V> put(DoubleNode<K, V> node, @NotNull K k, V v) {
        if(node == null) return new TreeResult<>(new DoubleNode<>(k, v), size + 1);

        int comp = comparator.compare(node.key, k);

        if(comp > 0){
            TreeResult<K, V> result = put(node.left, k, v);
            //DoubleNode<K, V> newNode = new DoubleNode<K, V>(node.key, node.elem, result.getNode(), node.right);
            return new TreeResult<>(new DoubleNode<>(node.key, node.elem, result.getNode(), node.right), result.getSize());
        }

        if(comp == 0) return new TreeResult<>(new DoubleNode<>(k, v), size);

        final TreeResult<K, V> result = put(node.right, k, v);
        //DoubleNode<K, V> newNode = new DoubleNode<>(node.key, node.elem, node.left, result.getNode());
        return new TreeResult<>(new DoubleNode<>(node.key, node.elem, node.left, result.getNode()), result.getSize());

    }


    /**     @Override
    public Iterator<K> keys() {
    return new Iterator<K>() {
    ArrayList<DoubleNode<K, V>>  nodesSorted = new ArrayList<>();
    int index = -1;


    private void inorder(DoubleNode<K, V> root) {
    if (root == null) return;
    this.inorder(root.left);
    this.nodesSorted.add(root);
    this.inorder(root.right);
    }


     @Override
     public boolean hasNext() {
     inorder(head);
     return this.index + 1 < this.nodesSorted.size();
     }

     @Override
     public K next() {
     return this.nodesSorted.get(++this.index).key;
     }


     };

     }
     **/


    @Override
    public Iterator<K> keys() {
        DynamicStack<DoubleNode<K,V>> stack = new DynamicStack<>();

        return new Iterator<>() {

            DoubleNode<K, V> current = head;

            @Override
            public boolean hasNext() {
                return !(current == null && stack.isEmpty());
            }

            @Override
            public K next() {
                if (!hasNext()) throw new IllegalStateException("Tree is already empty");
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                DoubleNode<K, V> aux = stack.pop();
                current = aux.right;
                return aux.key;
            }
        };
    }

    public DoubleNode<K, V> getHead() {
        return head;
    }
}
