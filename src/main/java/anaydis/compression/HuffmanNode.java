package anaydis.compression;

//public class HuffmanNode {
//    int frequency;
//    HuffmanNode left, right;
//    char aChar;
//
//    public HuffmanNode(char achar, int frequency) {
//        this.aChar = achar;
//        this.frequency = frequency;
//        this.left = null;
//        this.right = null;
//    }

    class HuffmanNode extends HuffmanTree {
        public final HuffmanTree left, right; // subtrees

        public HuffmanNode(HuffmanTree l, HuffmanTree r) {
            super(l.frequency + r.frequency);
            left = l;
            right = r;
        }
    }

//}
