package anaydis.compression;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.PriorityQueue;

public class Huffman implements anaydis.compression.Compressor {

    //la key es el caracter y el value es el codigo en forma de String
    BidiMap<Character, String> codes = new TreeBidiMap<>();
    HuffmanTree tree;

    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = "";
        PrintWriter pr = new PrintWriter(output);
        String text = "";

        while ((str = br.readLine()) != null) {
            text+=str;
            text+="\n";
        }
        text = text.substring(0, text.length()-1);


            //creo un arreglo con todos los chars del string (sin repeticion)
            char[] charsUnrepeated = eliminateRepetitions(text.toCharArray());
            //creo un arreglo con la frecuencia de cada char en su lugar correspondiente
            int[] frequencies = getFrequences(text, charsUnrepeated);


            // creo el arbol
            this.tree = buildTree(frequencies, charsUnrepeated);


            //guardo en un mapa todos los caracteres con su codigo
            getCodeMap(tree, new StringBuffer());

            //escribo en el ouput el mensaje codificado
            for (Character aChar : text.toCharArray()) {
                pr.write(codes.get(aChar));
            }
            pr.println();


        pr.flush();


    }

    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = "";
        PrintWriter pr = new PrintWriter(output);

        while ((str = br.readLine()) != null) {
            String code = "";
            for (int i = 0; i < str.length(); i++) {
                code += str.charAt(i);
                if (codes.containsValue(code)) {
                    pr.write(codes.getKey(code));
                    code = "";
                }

            }
            pr.println();
        }
        pr.flush();

    }




    //cuenta la cantidad de ocurrencias de un char en un String
    public static int calculateOccurrences(String str, char charater) {
        int count = (int) str.chars().filter(ch -> ch == charater).count();
        return count;
    }

    //obtiene las frecuencias de cada caracter en un string
    public static int[] getFrequences(String str, char[] characters) {
        int[] frequencies = new int[characters.length];

        for (int i = 0; i < characters.length; i++) {
            frequencies[i] = calculateOccurrences(str, characters[i]);
        }
        return frequencies;
    }

    //elimina caracteres repetidos en un String
    public static char[] eliminateRepetitions(char[] chars) {
        String str = "";

        for (int i = 0; i < chars.length; i++) {
            if (!str.contains(chars[i] + "")) str += chars[i];
        }
        return str.toCharArray();
    }


    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(test2[i], charFreqs[i]));

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


    public void getCodeMap(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
//            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
            codes.put(leaf.value, prefix.toString());





        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            getCodeMap(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            getCodeMap(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }



}









