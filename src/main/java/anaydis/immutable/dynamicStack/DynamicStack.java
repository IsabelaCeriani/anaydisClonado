package anaydis.immutable.dynamicStack;

public class DynamicStack<T>  {

    Node<T> top;
    int size;

    public void DynamicaStack(){
        top = null;
        size = 0;
    }

    public void push(T o) {
            Node<T> aux = new Node<T>(o);
            aux.next = top;
            top = aux;
            size++;


    }


    public T pop() {
        T aux = top.data;
        if(!isEmpty()){
            top = top.next;
            size--;
        }
        return aux;

    }


    public T peek() {
            T aux = top.data;
            return aux;

    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void empty() {
       while(!isEmpty()){
           pop();
       }

    }
}
