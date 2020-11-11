package anaydis.search;


public class DoubleNode<T, V>{
    public V elem;
    public T key;
    public DoubleNode <T, V> left, right;


    public DoubleNode(T key,V elem) {
        this.key =key;
        this.elem = elem;
        left = null;
        right = null;
    }


    public DoubleNode(T key,V elem, DoubleNode<T,V> left, DoubleNode<T, V> right) {
        this.key =key;
        this.elem = elem;
        this.left = left;
        this. right = right;
    }




}
