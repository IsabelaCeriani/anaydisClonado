package anaydis.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;

public class BinaryTreeTester {

    Comparator<Integer> comparator =  new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return  o1-o2;
        }
    };

    BinaryTree<Integer, String> tree = new BinaryTree<Integer, String>(comparator);

    @Test
    public void testContainsKey(){
        BinaryTree<Integer, String> first = (BinaryTree<Integer, String>) tree.put(1, "a");
        BinaryTree<Integer, String> second = (BinaryTree<Integer, String>) tree.put(8, "a");
        BinaryTree<Integer, String> third = (BinaryTree<Integer, String>) tree.put(4, "a");
        BinaryTree<Integer, String> fourth = (BinaryTree<Integer, String>) tree.put(6, "a");
        //Assert.assertTrue(fourth.containsKey(1));

        second.keys().forEachRemaining(System.out::println);




    }


    @Test
    public void testPut(){
        BinaryTree<Integer, String> first = (BinaryTree<Integer, String>) tree.put(2, "a");
        BinaryTree<Integer, String> second = (BinaryTree<Integer, String>) tree.put(1, "a");
        BinaryTree<Integer, String> third = (BinaryTree<Integer, String>) tree.put(3, "a");
        BinaryTree<Integer, String> fourth = (BinaryTree<Integer, String>) tree.put(4, "a");





    }
}
