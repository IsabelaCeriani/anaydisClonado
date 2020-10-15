package anaydis.sort.maps;

import junit.framework.TestCase;
import org.assertj.core.data.Percentage;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TreeMapTester extends TestCase {

    anaydis.sort.maps.TreeMap<Integer, String> tree = new TreeMap<>();


    public void testGet() {
        tree.put(2, "B");
        Object value = tree.get(2);
        Assert.assertEquals("B", value);
    }

    public void testContains() {
        tree.put(2, "B");
        Assert.assertFalse(tree.containsKey(4));
        Assert.assertTrue(tree.containsKey(2));
    }

    public void testFind() {
        DoubleNode<Integer, String> node = new DoubleNode<>();
        node.key = 1;
        node.elem = "a";
        Assert.assertEquals(null, tree.find(node, 3));

        tree.put(1, "a");
        Assert.assertEquals(node, tree.find(node, 1));
    }

//    public void testPut() {
//        tree.put(2, "B");
//        Assert.assertTrue(tree.getKeyList().contains(2));
//        Assert.assertTrue(tree.getValuesList().contains("B"));
//
//        //testeo que sobreescriba al agregar un valor con una clave ya ingresada
//        tree.put(2, "A");
//        Assert.assertTrue(tree.getValuesList().contains("A"));
//    }

    public void testRootPut() {
        tree.put(2, "B");
        Assert.assertTrue(tree.getKeyList().contains(2));
        Assert.assertTrue(tree.getValuesList().contains("B"));

        //testeo que sobreescriba al agregar un valor con una clave ya ingresada
        tree.put(2, "A");
        Assert.assertTrue(tree.getValuesList().contains("A"));

        //testeo que no este muy desbalanceado
        tree.put(3, "A");
        tree.put(4, "A");
        tree.put(5, "A");
        tree.put(6, "A");
        tree.put(7, "A");

        int left = tree.amountOfLeavesInTree(tree.getRoot().left);
        int right = tree.amountOfLeavesInTree(tree.getRoot().right);

        assertThat(left).isCloseTo(right, Percentage.withPercentage(50));

    }

    public void testRotateLeft() {
    }

    public void testRotateRight() {
    }

    public void testCompare() {
        int actual = tree.compare(1, 4);
        int actual1 = tree.compare(4, 1);
        int actual2 = tree.compare(1, 1);
        Assert.assertEquals(-1, actual);
        Assert.assertEquals(1, actual1);
        Assert.assertEquals(0, actual2);
    }



//    public void testTestGetKeyList() {
//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(5);
//        tree.put(2, "B");
//        tree.put(5, "B");
//        Assert.assertEquals(list,tree.getKeyList(tree.getRoot()));
//    }
//
//    public void testGetValuesList() {
//        List<String> list = new ArrayList<>();
//        list.add("B");
//        list.add("B");
//        tree.put(2, "B");
//        tree.put(3, "B");
//        Assert.assertEquals(list,tree.getValuesList(tree.getRoot()));
//    }

    public void testTestGetValuesList() {
        List<String> list = new ArrayList<>();
        list.add("B");
        tree.put(2, "B");
        Assert.assertEquals(list,tree.getValuesList());
    }

    public void testClear() {
    }

    public void testTestClear() {
    }

    public void testGetHeight() {
    }

    public void testGetRoot() {
    }

    public void testGetSize() {
    }
}