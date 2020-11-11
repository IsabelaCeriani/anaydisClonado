package anaydis.immutable.dynamicStack;

public class Node<T> {

    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
