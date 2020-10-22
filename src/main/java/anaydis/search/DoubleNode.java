package anaydis.search;


public class DoubleNode<T, V>{
    public V elem;
    public T key;
    DoubleNode <T, V> left, right;


    public DoubleNode(T key,V elem) {
        this.key =key;
        this.elem = elem;
        left = null;
        right = null;
    }




}
