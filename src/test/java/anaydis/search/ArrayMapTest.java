package anaydis.search;

import org.junit.Assert;
import org.junit.Test;

public class ArrayMapTest<Integer, String>extends ArrayMap {

    ArrayMap<java.lang.Integer,String> map = new ArrayMap<>();


    @Test
    public void testSize() {
        map.addKey(1);
        map.addKey(2);
        map.addKey(3);
        map.addKey(4);
        map.addKey(5);

        Assert.assertEquals(5, map.size());
    }


    //checkear que pasa con numeros negativos
    @Test
    public void testContainsKey() {
        map.addKey(1);
        map.addKey(2);
        map.addKey(3);
        map.addKey(4);
        map.addKey(5);
        map.addKey(8);

        Assert.assertTrue(map.containsKey(1));
        Assert.assertTrue(map.containsKey(2));
        Assert.assertTrue(map.containsKey(3));
        Assert.assertFalse(map.containsKey(9));
//        Assert.assertFalse(map.containsKey(-4));
    }

    @Test
    public void testGet() {
        map.put(1, (String) "A");
        map.put(2, (String) "B");
        map.put(3, (String) "C");

        String a = (String) map.get(1);
        String b = (String) map.get(2);
        String c = (String) map.get(3);

        Assert.assertEquals("A", a);
        Assert.assertEquals("B", b);
        Assert.assertEquals("C", c);

    }

    @Test
    public void testPut() {
        map.put(1, (String) "A");
        map.put(2, (String) "B");
        map.put(3, (String) "C");

        Assert.assertTrue(map.containsKeyt(1));
        Assert.assertTrue(map.containsKeyt(2));
        Assert.assertTrue(map.containsKeyt(3));
        Assert.assertTrue(map.containsKeyt(1));

        Assert.assertTrue(map.containsValueT((String) "A"));
        Assert.assertTrue(map.containsValueT((String) "B"));
        Assert.assertTrue(map.containsValueT((String) "C"));

        //pruebo que sobreescriva una key que ya esta en la lista con un nuevo valor
        map.put(2, (String) "Nuevo");
        Assert.assertTrue(map.containsValueT((String) "Nuevo"));
        Assert.assertTrue(!map.containsValueT((String) "B"));

        //testeo que esten en el lugar correcto usando indexOf que ya fue testeado
        int indexOfOne = map.indexOf(1);
        int indexOfTwo = map.indexOf(2);
        int indexOfThree = map.indexOf(3);

        map.getKeys().forEach(k -> System.out.println(k));

        Assert.assertEquals(0, indexOfOne);
        Assert.assertEquals(1, indexOfTwo);
        Assert.assertEquals(2, indexOfThree);

    }

    @Test
    public void testClear() {
        map.addKey(1);
        map.addKey(2);
        map.addKey(3);
        map.addKey(4);
        map.addKey(5);
        map.addKey(8);

        map.clear();

        Assert.assertTrue(map.size() == 0);
    }

    //falta
    @Test
    public void testKeys() {
    }

    @Test
    public void testIndexOf() {
        map.addKey(1);
        map.addKey(2);
        map.addKey(3);
        map.addKey(4);
        map.addKey(5);
        map.addKey(8);

        int indexOfOne = map.indexOf(1);
        int indexOfTwo = map.indexOf(2);
        int indexOfThree = map.indexOf(3);
        int indexOfFour = map.indexOf(4);
        int indexOfFive = map.indexOf(5);
        int indexOfSix = map.indexOf(6);

        Assert.assertEquals(0, indexOfOne);
        Assert.assertEquals(1, indexOfTwo);
        Assert.assertEquals(2, indexOfThree);
        Assert.assertEquals(3, indexOfFour);
        Assert.assertEquals(4, indexOfFive);
        Assert.assertEquals(-1, indexOfSix);



    }

    @Test
    public void testFind(){
        map.addKey(1);
        map.addKey(2);
        map.addKey(3);
        map.addKey(4);
        map.addKey(5);
        map.addKey(8);

        int indexOfOne = map.find(1, 0, 5);
        int indexOfTwo = map.find(2, 0, 5);
        int indexOfThree = map.find(3, 0, 5);
        int indexOfFour = map.find(4, 0, 5);
        int indexOfFive = map.find(5, 0, 5);

        Assert.assertEquals(0, indexOfOne);
        Assert.assertEquals(1, indexOfTwo);
        Assert.assertEquals(2, indexOfThree);
        Assert.assertEquals(3, indexOfFour);
        Assert.assertEquals(4, indexOfFive);

        //testeo si al buscar un numero que no se encuentra en el mapa me devuelve el indice en el que debria estar en valor negativo
        //el 6 deberia estar entre el 5 y el 8 en el indice 5
        int indexOfSix = map.find(6, 0, 5);
        Assert.assertEquals(-5, indexOfSix);





    }


    @Test
    public void testCompare() {
        Assert.assertEquals(0, compare(1,1));
        Assert.assertEquals(-1, compare(1,2));
        Assert.assertEquals(1, compare(2,1));
    }
}