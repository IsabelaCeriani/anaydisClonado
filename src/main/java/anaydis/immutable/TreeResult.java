package anaydis.immutable;

import anaydis.search.DoubleNode;

public class TreeResult<K, V> {

    private final DoubleNode<K, V> node;
    private final int size;

    public TreeResult(DoubleNode<K, V> node, int size) {
        this.node = node;
        this.size = size;
    }

    public DoubleNode<K, V> getNode() {
        return node;
    }

    public int getSize() {
        return size;
    }
}
