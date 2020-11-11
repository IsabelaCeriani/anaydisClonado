package anaydis.immutable;

import org.jetbrains.annotations.NotNull;


public class BankersQueue<T> implements Queue<T> {

    private final List<T> in;
    private final List<T> out;

    public BankersQueue() {
        this.in = List.nil();
        this.out = List.nil();
    }

    public BankersQueue(@NotNull  List<T> in, @NotNull List<T> out) {
        this.in = in;
        this.out = out;
    }

    @NotNull
    @Override
    public Queue<T> enqueue(@NotNull T value) {
       final List<T> newIn =  List.cons(value, in);
        return new BankersQueue<>(newIn, out);
    }

    @NotNull
    @Override
    public Result<T> dequeue() {
        if(out.isEmpty()){
            if(in.isEmpty()) throw  new IllegalStateException("Queue is empty");
            final List<T> reverse= in.reverse();
            return new Result<>(reverse.head(), new BankersQueue<>(List.nil(),reverse.tail()));
        }else{
            return new Result<>(out.head(), new BankersQueue<>(in, out.tail()));
        }
    }

    @Override
    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}
