package anaydis.search;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Comparator;


public class RandomizedTreeMapTester extends TestCase {

    Comparator<Integer> comparator =  new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return  o1-o2;
        }
    };

    RandomizedTreeMap<Integer, String> tree = new RandomizedTreeMap<>(comparator);


    public void testGet() {
        tree.put(2, "B");
        Object value = tree.get(2);
        Assert.assertEquals("B", value);
    }

    public void testContains() {
        tree.put(2, "B");
        tree.put(3, "9");
        tree.put(1, "9");
        Assert.assertFalse(tree.containsKey(4));
        Assert.assertTrue(tree.containsKey(2));
        Assert.assertTrue(tree.containsKey(3));
        Assert.assertTrue(tree.containsKey(1));
    }

    public void testFind() {
        DoubleNode<Integer, String> node = new DoubleNode<>(1, "a");
        Assert.assertNull(tree.find(node, 3));

        tree.put(1, "a");
        Assert.assertEquals(node, tree.find(node, 1));
    }

    //deberia testear lo que retorna el put
    public void testPut() {
        tree.put(2, "B");
        Assert.assertTrue(tree.containsKey(2));
        Assert.assertEquals("B", tree.get(2));

        tree.put(2, "A");
        Assert.assertEquals("A",tree.get(2) );
        Assert.assertEquals("A", tree.get(2));

        tree.put(3, "A");
        Assert.assertTrue(tree.containsKey(3));
        Assert.assertEquals("A", tree.get(3));



    }

    public void testRootPut() {
//        TreeMapResult<Integer, String> result = tree.put(tree.getRoot(), 2, "B");
//        Assert.assertTrue(node.key == 2 && node.elem.equals("B"));
//
//        //testeo que sobreescriba al agregar un valor con una clave ya ingresada
//        DoubleNode<Integer, String> newNode = tree.put(tree.getRoot(), 2, "A");
//        Assert.assertTrue(newNode.key == 2 && newNode.elem.equals("A"));
//
//        //testeo que inserte bien las keys con los valores correctamente mapeados tanto a izq como a derecha
//        DoubleNode<Integer, String> rightNode = tree.put(tree.getRoot(),3, "B");
//        Assert.assertTrue(rightNode.key == 3 && rightNode.elem.equals("B"));
//
//        DoubleNode<Integer, String> leftNode =tree.put(tree.getRoot(),1, "B");
//        Assert.assertTrue(leftNode.key == 1 && leftNode.elem.equals("B"));



    }


    ////////////////////////////////
    public void testRotateLeft() {
    }

    public void testRotateRight() {
    }
    ////////////////////////////////


    public void testCompare() {
        int actual = tree.getComparator().compare(1, 4);
        int actual1 = tree.getComparator().compare(4, 1);
        int actual2 = tree.getComparator().compare(1, 1);
        Assert.assertTrue(actual<0);
        Assert.assertTrue(actual1>0);
        Assert.assertTrue(actual2==0);
    }

    public void testClear() {
        tree.put(2, "B");
        tree.put(3, "9");
        tree.put(1, "9");
        tree.clear(tree.getRoot());
        Assert.assertNull(tree.getRoot().key);

    }

    public void testTestClear() {
        tree.put(2, "B");
        tree.put(3, "9");
        tree.put(1, "9");
        tree.clear();
        Assert.assertTrue(tree.isEmpty());
        Assert.assertEquals(0, tree.size());
    }



    public void testGetRoot() {
        tree.put(2, "A");
        DoubleNode<Integer, String> node = new DoubleNode<>(2, "A");
        Assert.assertEquals(node.elem, tree.getRoot().elem);
        Assert.assertEquals(node.key, tree.getRoot().key);
    }

    public void testGetSize() {
        tree.put(2, "B");
        Assert.assertEquals(1, tree.size());
        tree.put(3, "A");
        Assert.assertEquals(2, tree.size());
        tree.put(4, "C");
        Assert.assertEquals(3, tree.size());
    }


}