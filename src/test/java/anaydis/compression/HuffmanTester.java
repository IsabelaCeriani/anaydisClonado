package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class HuffmanTester {

    Huffman huffman = new Huffman();


    @Test
    public void testEncode() throws IOException {

        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));


        outputStream.write("AAAABBC".getBytes());

        huffman.encode(inputStream, outputStream);

        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();
        System.out.println(str);

//        Assert.assertEquals("OBRSDDB5", str);


    }

    @Test
    public void testDecode() throws IOException {

        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));


//        outputStream.write("OBRSDDB5".getBytes());

        huffman.decode(inputStream, outputStream);

        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();
        System.out.println(str);

//        Assert.assertEquals("AAAABBC", str);



    }
}

