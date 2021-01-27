package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class BurrowsWheelerTester {

    BurrowsWheeler burrowsWheeler = new BurrowsWheeler();


    @Test
    public void testEncode() throws IOException {

        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        outputStream.write("BANANA".getBytes());

        burrowsWheeler.encode(inputStream, outputStream);

        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();

        Assert.assertEquals("NNBAAA", str);


    }

    @Test
    public void testDecode() throws IOException {

        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        outputStream.write("BANANA".getBytes());

        burrowsWheeler.decode(inputStream, outputStream);

        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();

        Assert.assertEquals("BANANA", str);



    }
}
