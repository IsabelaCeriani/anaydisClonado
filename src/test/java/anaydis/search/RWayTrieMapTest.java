package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class RWayTrieMapTest extends RWayTrieMap<Integer> {

    RWayTrieMap<String> tree = new RWayTrieMap<>();

    @Test
    public void testSize() {
        tree.put("a", "a");

        Assert.assertEquals(1, tree.size());

    }

    @Test
    public void testContainsKey() {
        tree.put("a", "a");

        Assert.assertTrue(tree.containsKey("a"));
    }

    @Test
    public void testGet() {

    }


    @Test
    public void testClear() {

    }

    @Test
    public void testKeys() {

    }


    @Test
    public void testFind(){


    }

    @Test
    public void testPut() {

    }

    @Test
    public void testPuut() {

    }


}
