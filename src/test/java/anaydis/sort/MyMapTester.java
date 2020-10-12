package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

public class MyMapTester extends MyMap{
    MyMap<Integer, String> map = new MyMap<>();
    MyMap<Integer, String> emptyMap = new MyMap<>();


    @Test
    public void testSize() {
        map.put(1, "a");
        Assert.assertEquals(map.size(), 1);
        Assert.assertEquals(emptyMap.size(), 0);
    }

    @Test
    public void testContainsKey() {
        map.put(1, "A");
        Assert.assertFalse(emptyMap.containsKey(4));
        Assert.assertTrue(map.containsKey(1));
    }

    @Test
    public void testGet() {
        map.put(2, "B");
        Object value = map.get(2);
        Assert.assertEquals("B", value);
    }

//    @Test
//    public void testPut() {
//        //testeo agregar un valor al mpaa vacio
//        map.put(2, "B");
//        map.put(1, "A");
//        Assert.assertTrue(map.getTreeMap().getKeyList().contains(1));
//        Assert.assertTrue(map.getTreeMap().getKeyList().contains(2));
//        Assert.assertTrue(map.getTreeMap().getValuesList().contains("B"));
//
//        //testeo que sobreescriba al agregar un valor con una clave ya ingresada
//        map.put(2, "A");
//        Assert.assertTrue(map.getTreeMap().getValuesList().contains("A"));
//
//    }







    @Test
    public void testClear() {
        map.put(2, "B");
        Assert.assertTrue(map.getTreeMap().getKeyList().contains(2));

        map.clear();
        Assert.assertTrue(map.getTreeMap().getRoot().key == null);
    }

}
