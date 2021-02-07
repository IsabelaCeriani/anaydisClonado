package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class HuffmanTester {

    Huffman huffman = new Huffman();


    @Test
    public void testEncode() throws IOException {


        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();



        huffman.encode(inputStream, outputStream);

        String result = outputStream.toString();
        Assert.assertEquals("111111111110101010101010100", result);


    }

    @Test
    public void testDecode() throws IOException {
        String str = "AAAAAAAAAAABBBBBBBC";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();



        huffman.encode(inputStream, outputStream);

        String result = outputStream.toString();

        InputStream newInputStream = new ByteArrayInputStream(outputStream.toString().getBytes());
        OutputStream newoutputStream = new ByteArrayOutputStream();


        huffman.decode(newInputStream, newoutputStream);


        result = newoutputStream.toString();





    }
}

