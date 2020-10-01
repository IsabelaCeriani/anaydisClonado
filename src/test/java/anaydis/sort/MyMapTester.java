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
        Assert.assertEquals(emptyMap.size(), 0);
    }

    @Test
    public void testContainsKey() {
        map.getKeys().add(1);
        Assert.assertFalse(emptyMap.containsKey(4));
        Assert.assertTrue(map.containsKey(1));
    }

    @Test
    public void testGet() {
        map.put(2, "B");
        Object value = map.get(2);
        Object valueNotFound = map.get(9);
        Assert.assertEquals("B", value);
    }

    @Test
    public void testPut() {
        map.put(2, "B");
        Assert.assertTrue(map.getKeys().contains(2));
        Assert.assertTrue(map.getValues().contains("B")); //testeo agregar un valor al mpaa vacio
        map.put(2, "A");
        Assert.assertTrue(map.getValues().contains("A")); //testeo que sobreescriba al agregar un valor con una clave ya ingresada

    }

    @Test
    public void testComparator(){
        int actual = map.compare(1, 4);
        int actual1 = map.compare(4, 1);
        int actual2 = map.compare(1, 1);
        Assert.assertEquals(-1, actual);
        Assert.assertEquals(1, actual1);
        Assert.assertEquals(0, actual2);
    }



    @Test
    public void testFindKey() {
        map.getKeys().add(1);
        map.getKeys().add(2);
        map.getKeys().add(3);
        map.getKeys().add(4);
        map.getKeys().add(5);
        map.getKeys().add(6);
        int index1 = map.findKey(1, 0, map.getKeys().size()-1);
        int index2 = map.findKey(2, 0, map.getKeys().size()-1);
        int index3 = map.findKey(3,0,  map.getKeys().size()-1);
        int index4 = map.findKey(4,0,  map.getKeys().size()-1);
        int index5 = map.findKey(5,0,  map.getKeys().size()-1);
        int index6 = map.findKey(6,0,  map.getKeys().size()-1);
        int index7 = map.findKey(7,0,  map.getKeys().size()-1);


        Assert.assertEquals(1,index2);
        Assert.assertEquals(3,index4);
        Assert.assertEquals(5,index6);

        Assert.assertEquals(0, index1);
        Assert.assertEquals(2, index3);
        Assert.assertEquals(4,index5);
        Assert.assertEquals(-1,index7);
    }


    @Test
    public void testClear() {

    }

}
