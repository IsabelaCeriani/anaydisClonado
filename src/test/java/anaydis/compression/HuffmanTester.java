package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class HuffmanTester {

    Huffman huffman = new Huffman();


    @Test
    public void testEncode() throws IOException {


        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        OutputStream os = new ByteArrayOutputStream();



        huffman.encode(is, os);

        String result = os.toString();
        Assert.assertEquals("111111111110101010101010100", result);


    }

    @Test
    public void testDecode() throws IOException {
        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream is = new ByteArrayInputStream(str.getBytes());
        OutputStream os = new ByteArrayOutputStream();



        huffman.encode(is, os);

        String result = os.toString();
        System.out.println(result);


        InputStream newInputStream = new ByteArrayInputStream(os.toString().getBytes());
        OutputStream newOS = new ByteArrayOutputStream();


        huffman.decode(newInputStream, newOS);


        result = newOS.toString();
        System.out.println(result);





    }
}

