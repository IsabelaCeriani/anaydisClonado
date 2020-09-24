package anaydis.sort.sorters;

import anaydis.sort.SorterType;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class QuickNonRecursive extends QuickSorter {
    @Override
    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list) {
        sort(comparator, list, 0, list.size()-1);

    }

    public <T> void sort(@NotNull Comparator<T> comparator, @NotNull List<T> list, int l, int r) {
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(r);
        while (!stack.empty()) {
            r = stack.pop();
            l = stack.pop();
            if (r <= l) {
                continue;
            }
            int i = partition(comparator, list, l, r);
            if (i - l > r - i) {
                stack.push(l);
                stack.push(i - 1);
            }
            stack.push(i + 1);
            stack.push(r);
            if (r - i >= i-l) {
                stack.push(l);
                stack.push(i - 1);
            }
        }

    }

    @NotNull
    @Override
    public SorterType getType() {
        return SorterType.QUICK_NON_RECURSIVE;
    }
}
