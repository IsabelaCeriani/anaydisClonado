package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class RWayTrieMapTest extends RWayTrieMap<String> {

    RWayTrieMap<String> tree = new RWayTrieMap<>();

    @Test
    public void testSize() {
        tree.put("a", "a");
        Assert.assertEquals(1, tree.size());
        tree.put("b", "b");
        Assert.assertEquals(2, tree.size());
        tree.put("c", "c");
        Assert.assertEquals(3, tree.size());


    }

    @Test
    public void testContainsKey() {
        tree.put("a", "a");
        Assert.assertTrue(tree.containsKey("a"));
        tree.put("b", "b");
        Assert.assertTrue(tree.containsKey("b"));
        tree.put("c", "c");
        Assert.assertTrue(tree.containsKey("c"));
        Assert.assertFalse(tree.containsKey("d"));
    }

    @Test
    public void testGet() {
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put("c", "c");

        String a = tree.get("a");
        String b = tree.get("b");
        String c = tree.get("c");

        Assert.assertEquals("a", a);
        Assert.assertEquals("b", b);
        Assert.assertEquals("c", c);



    }


    @Test
    public void testClear() {
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put("c", "c");

        tree.clear();

        Assert.assertEquals(0, tree.size());


    }

    @Test
    public void testKeys() {

    }


    @Test
    public void testFind(){
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put("c", "c");

        Node<String> firstActual = tree.find(tree.getRoot(), "a", 0);
        Node<String> firstExpected  =  new Node<>("a");

        Assert.assertEquals(firstExpected.elem, firstActual.elem);

        Node<String> secondActual = tree.find(tree.getRoot(), "b", 0);
        Node<String> secondExpected  =  new Node<>("b");

        Assert.assertEquals(secondExpected.elem, secondActual.elem);

        Node<String> thirdActual = tree.find(tree.getRoot(), "c", 0);
        Node<String> thirdExpected  =  new Node<>("c");

        Assert.assertEquals(thirdExpected.elem, thirdActual.elem);


    }

    @Test
    public void testPut() {
        tree.put("a", "a");
        Node<String> first = tree.find(tree.getRoot(), "a", 0);
        Assert.assertEquals("a", first.elem);

        Assert.assertEquals(1, tree.size());
        Assert.assertTrue(tree.containsKey("a"));
    }

    @Test
    public void testPuut() {
        Node<String> newRoot = tree.put(tree.getRoot(),"a", "a", 0);
        tree.setRoot(newRoot);

        Node<String> first = tree.find(tree.getRoot(), "a", 0);
        Assert.assertEquals("a", first.elem);

        Assert.assertTrue(tree.containsKey("a"));

    }

    @Test
    public void testGetRoot(){
        tree.put("a", "a");
        Assert.assertEquals("a", tree.getRoot().elem);

    }

    @Test
    public void testSetRoot(){
        Node<String> node  =  new Node<>("a");
        tree.setRoot(node);
        Assert.assertEquals("a", tree.getRoot().elem);

        Node<String> newNode  =  new Node<>("b");
        tree.setRoot(newNode);
        Assert.assertEquals("b", tree.getRoot().elem);

    }

}
