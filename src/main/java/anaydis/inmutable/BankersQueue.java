package anaydis.inmutable;

import anaydis.immutable.Queue;
import org.jetbrains.annotations.NotNull;

public class BankersQueue<T> implements Queue<T> {
    @NotNull
    @Override
    public Queue<T> enqueue(@NotNull T value) {
        return null;
    }

    @NotNull
    @Override
    public Result<T> dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
