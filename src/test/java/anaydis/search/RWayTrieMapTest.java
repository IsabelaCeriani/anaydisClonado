package anaydis.search;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class RWayTrieMapTest extends RWayTrieMap<String> {

    RWayTrieMap<String> tree = new RWayTrieMap<>();

    @Test
    public void testSize() {
        tree.put("a", "a");
        Assert.assertEquals(1, tree.size());
//        tree.put("b", "b");
//        Assert.assertEquals(2, tree.size());
//        tree.put("c", "c");
//        Assert.assertEquals(3, tree.size());


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
        tree.put("a", "a");
        tree.put("b", "a");
        tree.put("c", "a");
        tree.put("d", "a");

//        tree.keys().forEachRemaining(System.out::println);
        List<String> actualKeys = new ArrayList<>();
        actualKeys.add("a");
        actualKeys.add("b");
        actualKeys.add("c");
        actualKeys.add("d");

        List<String> foundKeys = new ArrayList();


        tree.keys().forEachRemaining(foundKeys::add);





        RWayTrieMap<Integer> treeI = new RWayTrieMap<>();
        treeI.put("aaaa", 1);
        treeI.put("bbb", 1);
        treeI.put("cc", 1);
        treeI.put("dd", 1);

        treeI.keys().forEachRemaining(System.out::println);

    }


    @Test
    public void testFind(){
        tree.put("a", "a");
        tree.put("b", "b");
        tree.put("c", "c");

        TrieNode<String> firstActual = tree.find(tree.getRoot(), "a", 0);
        TrieNode<String> firstExpected  =  new TrieNode<>();
        firstExpected.elem = "a";

        Assert.assertEquals(firstExpected.elem, firstActual.elem);

        TrieNode<String> secondActual = tree.find(tree.getRoot(), "b", 0);
        TrieNode<String> secondExpected  =  new TrieNode<>();
        secondExpected.elem = "b";

        Assert.assertEquals(secondExpected.elem, secondActual.elem);

        TrieNode<String> thirdActual = tree.find(tree.getRoot(), "c", 0);
        TrieNode<String> thirdExpected  =  new TrieNode<>();
        thirdExpected.elem = "c";

        Assert.assertEquals(thirdExpected.elem, thirdActual.elem);


    }

    @Test
    public void testPut() {
        tree.put("a", "a");
        TrieNode<String> first = tree.find(tree.getRoot(), "a", 0);
        Assert.assertEquals("a", first.elem);

//        Assert.assertEquals(1, tree.size());
        Assert.assertTrue(tree.containsKey("a"));
        String prev= tree.put("a", "b");
        Assert.assertEquals("a", prev);
    }

    @Test
    public void testPuut() {
        TrieNode<String> newRoot = tree.put(tree.getRoot(),"a", "a", 0);
        tree.setRoot(newRoot);

        TrieNode<String> first = tree.find(tree.getRoot(), "a", 0);
        Assert.assertEquals("a", first.elem);

        Assert.assertTrue(tree.containsKey("a"));

    }

   

    @Test
    public void testSetRoot(){
        TrieNode<String> TrieNode  =  new TrieNode<>();
        TrieNode.elem= "a";
        tree.setRoot(TrieNode);
        Assert.assertEquals("a", tree.getRoot().elem);

//        TrieNode<String> newTrieNode  =  new TrieNode<>();
//        TrieNode.elem= "b";
//        tree.setRoot(newTrieNode);
//        Assert.assertEquals("b", tree.getRoot().elem);

    }




}
