package anaydis.search;


import org.jetbrains.annotations.NotNull;

public class Node<T> {


        T elem;
        Node<T>[] next = new Node[256];

        public Node( T elem) {
            this.elem = elem;
        }



}
