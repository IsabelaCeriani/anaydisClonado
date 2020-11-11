package anaydis.inmutable;

import anaydis.immutable.List;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class Node<T> implements List<T> {

    private final T head;
    private final List<T> tail;

    public Node(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @NotNull
    @Override
    public List<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @NotNull
    @Override
    public List<T> reverse() {
        List<T> reversed = List.nil(), current = this;
        while (!current.isEmpty()){
            reversed = List.cons(current.head(), reversed);
            current = current.tail();
        }
        return reversed;

    }
}
