package anaydis.search;

public class TreeMapResult<K, V> {

    private final DoubleNode<K, V> newNode;
    private final V prevValue;

    public TreeMapResult(DoubleNode<K, V> newNode, V prevValue) {
        this.newNode = newNode;
        this.prevValue = prevValue;
    }

    public DoubleNode<K, V> getNewNode() {
        return newNode;
    }

    public V getPrevValue() {
        return prevValue;
    }
}
