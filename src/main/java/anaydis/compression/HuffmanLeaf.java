package anaydis.compression;


class HuffmanLeaf extends HuffmanTree {
        public final char value; // the character this leaf represents

        public HuffmanLeaf(char val, int freq) {
            super(freq);
            value = val;

    }
}
