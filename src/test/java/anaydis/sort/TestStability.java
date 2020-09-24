package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class TestStability {

    public static void main(String[] args) {
        List<String> strnigs = new ArrayList<>();
        strnigs.add("1");
        strnigs.add("2");
        strnigs.add("3");
        strnigs.add("4");
        strnigs.add("5");
        strnigs.add("6");
        strnigs.add("7");

        testQuickStability(strnigs, 0, strnigs.size()-1);

        StringBuilder string = new StringBuilder();
        for (String name: strnigs) string.append(name).append(", ");
        System.out.println(string);


    }


    @Test
    public  void testShellStability(List<String> strnigs){

        //al ordenar por el tama;o de los arrays, si el algoritmo es estable deberia quedar respetando lor ordenes"

        StringBuilder string = new StringBuilder();
        for (String name: strnigs) string.append(name).append(", ");
        System.out.println(string);

        //shellsort
        for (int gap = strnigs.size()/3; gap >= 1; gap /= 3) {
            for (int j = gap; j < strnigs.size(); j++) {
                for (int i = j - gap; i >= 0; i -= gap) {
                    if (strnigs.get(i).length() < strnigs.get(i+gap).length() ) break;
                    swap(strnigs, i + gap, i);
                }

            }
        }

        StringBuilder string2 = new StringBuilder();
        for (String name: strnigs) string2.append(name).append(", ");
        System.out.println(string2);


    }

    public static int partition(@NotNull List<String> list, int left, int right) {
        int i = left-1;
        int j = right;

        while(true) {
            while(list.get(right).length() < list.get(++i).length()){
                if (i == right)
                    break;
            }
            while(list.get(--j).length() < list.get(right).length()) {

                if (j == left)
                    break;
            }
            if (i >= j)
                break;

            swap(list, i, j);

        }
        swap(list, i, right);
        return i;



    }

    @Test
    public static void testQuickStability(List<String> strings, int left, int right){
            if(right <= left) return;
            int i = partition(strings, left, right);
            testQuickStability(strings, left, i - 1);
            testQuickStability(strings, i + 1, right);

        }

    }

