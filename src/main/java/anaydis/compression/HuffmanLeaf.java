package anaydis.compression;


class HuffmanLeaf extends HuffmanTree {
        public final char value;

        public HuffmanLeaf(char val, int freq) {
            super(freq);
            value = val;

    }
}
