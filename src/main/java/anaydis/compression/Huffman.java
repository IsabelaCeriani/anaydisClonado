package anaydis.compression;

import anaydis.immutable.BinaryTree;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Huffman implements anaydis.compression.Compressor {
    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
//        char[] chars = eliminateRepetitions();
//        int[] frequencies = getFrequences();
//        HuffmanTree huffmanTree = buildTree(frequencies, chars);

    }

    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {

    }

    private BinaryTree<Integer, String> buildHuffmanTree(){
        return null;
    }


    //cuenta la cantidad de ocurrencias de un char en un String
    //(contar letras)
    public static int calculateOccurrences(String str, char charater) {
        int index;
        int count = 0;

        index = str.indexOf(charater);

        while (index != -1) {
            count++;
            index = str.indexOf(str, index + 1);
        }
        return count;
    }

    //obtiene las frecuencias de cada caracter en un string
    // (obtener frecuencias)
    public static int[] getFrequences(String str, char[] characters) {
        int[] frecuencias = new int[characters.length];

        for (int i = 0; i < characters.length; i++) {
            frecuencias[i] = calculateOccurrences(str, characters[i]);
        }
        return frecuencias;
    }

    //elimina caracteres repetidos en un String
    //obtener letras unicas
    public static char[] eliminateRepetitions(char[] chars) {
        String str = "";

        for (int i = 0; i < chars.length; i++) {
            if (!str.contains(chars[i] + "")) str += chars[i];
        }
        return str.toCharArray();
    }

//
//    public static String toPrint(HuffmanNode root, String s, String print) {
//        if (root.left == null && root.right == null && Character.isLetter(root.aChar)) {
//
//            print += root.aChar + ":" + s + "\n";
//            return print;
//        }
//
//        // Va recursivamente por los hijos del arbol.
//        print = toPrint(root.left, s + "0", print);
//        print = toPrint(root.right, s + "1", print);
//        return print;
//    }

    // Lee el archivo de texto y entrega una lista.
    public static List readData(InputStream input) throws FileNotFoundException, IOException {
        List<String> list = new ArrayList<String>();

        String str = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(input));

        while ((str = br.readLine()) != null) {
            list.add(str);
        }

        return list;

    }

    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] frequencies, char[] chars) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < frequencies.length; i++)
            if (frequencies[i] > 0)
                trees.offer(new HuffmanLeaf(chars[i], frequencies[i]));

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }




}


