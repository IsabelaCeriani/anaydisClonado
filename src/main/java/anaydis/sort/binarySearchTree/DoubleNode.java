package anaydis.sort.binarySearchTree;


public class DoubleNode<T, V>{
    public V elem;
    public T key;
    DoubleNode <T, V> left, right;

    public DoubleNode() {

    }
    public DoubleNode(T key,V elem) {
        this.key =key;
        this.elem = elem;
    }
    public DoubleNode(V elem, DoubleNode <T, V> izq, DoubleNode <T, V>der) {
        this.elem = elem;
        this.left = izq;
        this.right = der;
    }

    public boolean inEmpty(){
        return (elem ==null);
    }

    public void changeElem(V obj){
        this.elem = obj;
    }


}
